

object ajout_cadre extends App {
  import com.tncy.top.image.ImageWrapper;
  import Array._
  
  // Load wrapped image
   var wrappedImage : ImageWrapper = new ImageWrapper("Images/ImagesTests/6.jpg");
   
   // Get the image
   var image2D : Array[Array[Int]] = wrappedImage.getImage();
   
   var wrappedImage2:ImageWrapper=new ImageWrapper("Images/cadre4_8.png")
   var im_plusC : Array[Array[Int]] = wrappedImage2.getImage();
   
   val h1=wrappedImage.height
   val w1=wrappedImage.width
   val h2=wrappedImage2.height
   val w2=wrappedImage2.width
   println(h1,w1,h2,w2)
   
   def ajouter_un_cadre_de_Largeur(L:Int){
     for (i<-0 to h1-1)
       for (j<-0 to w1-1){
         
         im_plusC(i+L)(j+L)=image2D(i)(j)}
         
   }
       
  ajouter_un_cadre_de_Largeur(8)//L/2     
  var outputFile:String="Images/ImTests_Cadre/plusCadreN6.jpg"
  wrappedImage2.saveImage(outputFile);
}