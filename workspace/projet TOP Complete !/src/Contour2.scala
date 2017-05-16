
object Contour2 extends App {
  import com.tncy.top.image.ImageWrapper;
  var fileNameO:String="6.jpg"
  var fileName:String="Results/GrayC 6.jpg";
  var wrappedImage : ImageWrapper = new ImageWrapper(fileName);
  var image2D : Array[Array[Int]] = wrappedImage.getImage();
  var im2=copy(image2D);
  var im3=copy(image2D);
  val h=wrappedImage.height
  val w=wrappedImage.width

  
  
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
   pixel=pixel>>16
   var R=pixel&255
 return R
}

def difference(r:Int,seuil:Int):Int={
  var res=r
  if (r<seuil){
    res=0
  }
  else{
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
 

//Contours des objets
def Contours2(src:Array[Array[Int]],dst:Array[Array[Int]],seuil:Int)={
  for (y<-1 to w-2){
    for (x<-1 to h-2){
      var r0=PixRouge(src,x,y)
      var r1=PixRouge(src,x,y-1)
      var r2=PixRouge(src,x-1,y)
      var r3=PixRouge(src,x,y+1)
      var r4=PixRouge(src,x+1,y)
      
      var a=(r1-r3)*(r1-r3)
      var c=(r2-r4)*(r2-r4)
      var l:Int=math.sqrt(a+c).toInt
      
      var r=difference(l,seuil)
      var v=r
      var b=r
      var g=newGreyPix(r,v,b)
      dst(x)(y)=g
 
    }
  }
  
}

Contours2(image2D,im2,300)
 var outputFile:String="Results_Contour/Contour2_2"+" "+fileNameO
 wrappedImage.saveImage(outputFile);
  
}