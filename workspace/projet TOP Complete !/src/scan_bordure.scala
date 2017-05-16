

object scan_bordure extends App {
  import com.tncy.top.image.ImageWrapper;
  import Array._
  var fileNameO:String="8.jpg"
  //var fileName:String="Results_Lissage/LissageM7 6.jpg";
  var fileName:String="Results_Lissage/LissageM8 7.jpg"
  var wrappedImage : ImageWrapper = new ImageWrapper(fileName);
  var image2D : Array[Array[Int]] = wrappedImage.getImage();
  val wmax=wrappedImage.width;
  val hmax=wrappedImage.height;
  var im2 : Array[Array[Boolean]] = Array.fill(wmax, hmax)(false)
  
  for (i<-2 to wmax-2){}
}
      
  