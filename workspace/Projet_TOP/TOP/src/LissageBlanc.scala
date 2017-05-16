
object LissageBlanc extends App {
  import com.tncy.top.image.ImageWrapper;
  var fileNameO:String="6.jpg"
  var fileName:String="Results_Lissage/LissageM8 6.jpg";
  //var fileName:String="Results_Lissage/LissageM7 8.jpg";
  var wrappedImage : ImageWrapper = new ImageWrapper(fileName);
  var image2D : Array[Array[Int]] = wrappedImage.getImage();
  var l=8 //largeur du cadre
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


def newGreyPix(R:Int,V:Int,B:Int):Int={
  var T=255<<24
  var r=R<<16
  var v=V<<8
  return(T+r+v+B)
}
 

//Contours des objets
def LissageB(src:Array[Array[Int]],dst:Array[Array[Int]],epsi:Int)={
  for (y<-l to w-1-l){  //prise en compte des pixels du cadre à sauter
    for (x<-l to h-1-l){
      var r0=PixRouge(src,x,y)
      if (r0>=255-epsi){
        var r1=PixRouge(src,x,y-1)
        var r2=PixRouge(src,x-1,y)
        var r3=PixRouge(src,x,y+1)
        var r4=PixRouge(src,x+1,y)
      
        var a=(r1-r3)*(r1-r3)
        var c=(r2-r4)*(r2-r4)
        var l=math.sqrt(a+c)
        
        if (l<50){
          var g=newGreyPix(255,255,255)
          dst(x)(y)=g
        }
      }
    } 
  }
}

LissageB(image2D,im2,30)
image2D=copy(im2)
 var outputFile:String="Results_Lissage/LissageEM2"+" "+fileNameO
 wrappedImage.saveImage(outputFile);
  
}