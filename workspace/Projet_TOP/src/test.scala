

object test extends App {
  import com.tncy.top.image.ImageWrapper;
  import Array._
  
  // Load wrapped image
   var wrappedImage : ImageWrapper = new ImageWrapper("Images/ImagesTests/6.jpg");
   
   // Get the image
   var image2D : Array[Array[Int]] = wrappedImage.getImage();
       
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
    var im = copy(image2D)
    for(i<-0 to wrappedImage.width-1)
    {
      im(1)(i) = 0
    }
  var outputFile:String="Images/test.jpg"
  wrappedImage.saveImage(outputFile);
}