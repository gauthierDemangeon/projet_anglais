

object TestContourNawak extends App {
  import com.tncy.top.image.ImageWrapper;
  import Array._
  var fileNameO:String="8.jpg"
  //var fileName:String="Results_Lissage/LissageM7 6.jpg";
  var fileName:String="Results_Lissage/LissageM8 7.jpg"
  var wrappedImage : ImageWrapper = new ImageWrapper(fileName);
  var image2D : Array[Array[Int]] = wrappedImage.getImage();
  
  var im2=image2D.clone()
  var im3=image2D.clone()
  //var im2=copy(image2D);
  //var im3=copy(image2D);
  val h=wrappedImage.height
  val w=wrappedImage.width

  def LissageB(src:Array[Array[Int]],dst:Array[Array[Int]],epsi:Int)={
  for (x<-1 to h-2){
    for (y<-1 to w-2){
      var r0=PixRouge(src,x,y)
      /*if (r0>=255-epsi){
        var r1=PixRouge(src,x,y-1)
        var r2=PixRouge(src,x-1,y)
        var r3=PixRouge(src,x,y+1)
        var r4=PixRouge(src,x+1,y)
      
        var a=(r1-r3)*(r1-r3)
        var c=(r2-r4)*(r2-r4)
        var l=math.sqrt(a+c)
        
        if (l<380){
          var g=newGreyPix(255,255,255)
          dst(x)(y)=g
        }*/
        if (r0>50) dst(x)(y)=(-1)
        
      }
    } 
}
  LissageB(image2D,im2,30)
  
  def copy(src:Array[Array[Int]]):Array[Array[Int]]={
    val n=src.length
    var dst=new Array[Array[Int]](n) //tableau de même taille que src, à elts de type Array[Int]
    
    val t=(src(0)).length
    var tab=Array.fill(t)(0)
   
    for (i<-0 to n-1){
      dst(i)=tab		//on remplit dst avec des tab[Int] remplis de 0
    }
    
    for (i<-0 to n-1){
      dst(i)=src(i) 	//on copie les tab de src dans dst
    }
  return dst
  }
  
   
def PixRouge(src:Array[Array[Int]],l:Int,c:Int):Int={ //Renvoie les valeurs R,V,B d'un pixel
   var pixel=src(l)(c)
   //pixel=pixel>>16
   var R=pixel&255
 return R
}


def newGreyPix(R:Int,V:Int,B:Int):Int={
  var T=255<<24
  var r=R<<16
  var v=V<<8
  return(T+r+v+B)
}
 

//Contours des objets
def Contours(src:Array[Array[Int]],dst:Array[Array[Int]])={
    
    var r0=0
	  var r1=0;
	  var r2=0;
	  var r3=0;
	  var r4=0;

			  var a=0
			  var c=0

  for (x<-h/2 to h-2){
    for (y<-w/2 to w-2){
      r0=PixRouge(src,x,y)
      r1=PixRouge(src,x,y-1)
      r2=PixRouge(src,x-1,y)
      r3=PixRouge(src,x,y+1)
      r4=PixRouge(src,x+1,y)
      
      a=math.abs(r1-r3)
      c=math.abs(r2-r4)
      var l=a+c        
        if (l<200){
          var h=newGreyPix(0,0,0)
          dst(x)(y)=h
        }
        else{
          var g=newGreyPix(255,255,255)
          dst(x)(y)=g
        }
      
    } 
  }
}

Contours(im2,image2D)
 var outputFile:String="Results_Contour/ContourNawak2"+" "+fileNameO
 wrappedImage.saveImage(outputFile);
}