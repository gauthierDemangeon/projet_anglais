

object Amelioration_lissage extends App {
  
  import com.tncy.top.image.ImageWrapper;
  var fileNameO:String="plusCadreN6.jpg"
  var fileName:String="Results/GrayC plusCadreN6.jpg";
  var wrappedImage : ImageWrapper = new ImageWrapper(fileName);
  var image2D : Array[Array[Int]] = wrappedImage.getImage();
  var l=8 //largeur du cadre
  var im2=copy(image2D);
  
  val h=wrappedImage.height
  val w=wrappedImage.width

  
//-----------------------------------------------------------------------------------------------------  
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
  
//-----------------------------------------------------------------------------------------------------
   
def PixRouge(src:Array[Array[Int]],l:Int,c:Int):Int={ //Renvoie les valeurs R,V,B d'un pixel
   var pixel=src(l)(c)
   pixel=pixel>>16
   var R=pixel&255
 return R
}

def redBound(r:Int):Int={
  var res=r
  if (r<0){
    res=0
  }
  if (r>255){
    res=255
  }
  return res
}

def newGreyPix(R:Int,V:Int,B:Int):Int={
  var T=255<<24
  var r=R<<16
  var v=V<<8
  return(T+r+v+B)
}
 

//----------------------------------------------------------------------------------------------------- 

//Contours des objets
def Lissage(src:Array[Array[Int]],dst:Array[Array[Int]])={
  for (y<-1 to w-2){  //prise en compte des pixels du cadre à sauter
    for (x<-1 to h-2){
      var r0=PixRouge(src,x,y)
      var r1=PixRouge(src,x,y-1)
      var r2=PixRouge(src,x-1,y-1)
      var r3=PixRouge(src,x-1,y)
      var r4=PixRouge(src,x-1,y+1)
      var r5=PixRouge(src,x,y+1)
      var r6=PixRouge(src,x+1,y+1)
      var r7=PixRouge(src,x+1,y)
      var r8=PixRouge(src,x+1,y-1)
      
      var R=13*r0-r1-r2-r3-r4-r5-r6-r7-r8
      R=R/7
      R=R+128
      R=redBound(R)
      var r=255-R
      var v=r
      var b=r
      var g=newGreyPix(r,v,b)
      dst(x)(y)=g
 
    }
  }
  
}


 


//pixels a peu pres noirs convertis en noir
def LissageM(src:Array[Array[Int]],dst:Array[Array[Int]],epsi:Int)={
  for (y<-1 to w-2){  //prise en compte des pixels du cadre à sauter
    for (x<-1 to h-2){
      var r0=PixRouge(src,x,y)
      if (r0<=epsi){
        var r1=PixRouge(src,x,y-1)
        var r2=PixRouge(src,x-1,y)
        var r3=PixRouge(src,x,y+1)
        var r4=PixRouge(src,x+1,y)
      
        var a=(r1-r3)*(r1-r3)
        var c=(r2-r4)*(r2-r4)
        var l=math.sqrt(a+c)
        
        if (l<100){
          dst(x)(y)=0
        }
      }
    } 
  }
}



//pixels à peu près blances convertis en blanc
def LissageB(src:Array[Array[Int]],dst:Array[Array[Int]],epsi:Int)={
  for (y<-1 to w-2){  //prise en compte des pixels du cadre à sauter
    for (x<-1 to h-2){
      var r0=PixRouge(src,x,y)
      if (r0>=255-epsi){
        var r1=PixRouge(src,x,y-1)
        var r2=PixRouge(src,x-1,y)
        var r3=PixRouge(src,x,y+1)
        var r4=PixRouge(src,x+1,y)
      
        var a=(r1-r3)*(r1-r3)
        var c=(r2-r4)*(r2-r4)
        var l=math.sqrt(a+c)
        
        if (l<270){
          var g=newGreyPix(255,255,255)
          dst(x)(y)=g
        }
      }
    } 
  }
}



Lissage(image2D,im2)
var im3=copy(im2);
LissageB(im2,im3,155)
image2D=copy(im3)
LissageM(im3,image2D,100)




 var outputFile:String="NResults_Lissage/LissageATest8"+" "+fileNameO
 wrappedImage.saveImage(outputFile);
  
}