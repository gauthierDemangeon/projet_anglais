
object RVB extends App {
  import com.tncy.top.image.ImageWrapper;
  var fileNameO:String="plusCadreN6.jpg";
  var fileName:String="Images/ImTests_Cadre/plusCadreN6.jpg";
  var wrappedImage : ImageWrapper = new ImageWrapper(fileName);
  var image2D : Array[Array[Int]] = wrappedImage.getImage();
  var image2DCopie=copy(image2D)
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
  
   
def RVBImage(src:Array[Array[Int]],l:Int,c:Int):(Int,Int,Int)={ //Renvoie les valeurs R,V,B d'un pixel
   var pixel=src(l)(c)
   var B=pixel&255
   pixel=pixel>>8
   var V=pixel&255
   pixel=pixel>>8
   var R=pixel&255
 return (R,V,B)
}


//Fonctions pour avoir une seule valeur pour R,V,B (-->Gris: R=V=B)

def newPixS(R:Int,V:Int,B:Int):Int={
  return ((R+V+B)/3)					//Moyenne simple
}
  												//"S" pour simple,"C" pour contrasté
def newPixC(R:Int,V:Int,B:Int):Int={
  return ((0.299*R+0.587*V+0.114*B).toInt)		//Moyenne coefficientée => Plus grand contraste 
}												//NotetoSelf: Optimiser les coefficients

//Construction du nouveau pixel GrayLevel

def intToPix(a:Int):Int={
  var T=255<<24
  var R=a<<16
  var V=a<<8
  return (T+R+V+a)
}

//GreyLevel  
def filtreGris(src:Array[Array[Int]])={
   for (i<-0 to (h-1)){
      for (j<-0 to (w-1)){
        var (r,v,b)=RVBImage(src,i,j)
        var l=newPixC(r,v,b)
        var PixGris=intToPix(l)
        src(i)(j)=PixGris
        }
      }
   }

filtreGris(image2DCopie)

var outputFile:String="Results/GrayC"+" "+fileNameO
 wrappedImage.saveImage(outputFile);
  
  
}