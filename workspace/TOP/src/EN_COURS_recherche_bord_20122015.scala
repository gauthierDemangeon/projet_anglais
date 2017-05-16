

object recherche_bord_20122015 extends App {
  
//------------------------------------------------------------------------------------------------------------------------------------------
  
  // Import the API library
   import com.tncy.top.image.ImageWrapper;
   import Array._

   // Source image file
   var fileName : String = "sampleImage.jpg";

   // Load wrapped image
   var wrappedImage : ImageWrapper = new ImageWrapper("NResults_Lissage/LissageATest2 plusCadreN6.jpg");
   // Get the image
   var image2D : Array[Array[Int]] = wrappedImage.getImage();
   
   // Epaisseur du cadre
   var ep_c = 8

   // Print image height and width
   println("The image height is: " + wrappedImage.height + " px.");
   println("The image width is: " + wrappedImage.width + " px.");
   
//------------------------------------------------------------------------------------------------------------------------------------------


  //Valeurs haut,droite,bas,gauche pour caractériser les chemins potentiels trouvés
  val haut = 0
  val droit = 1
  val bas = 2
  val gauche = 3
  
  //
  val cmin=20 //Contraste entre deux pixel à partir duuel on considère que c'est une bordure
  //Largeur max, hauteur max
  val wmax = wrappedImage.width-1-ep_c
  val hmax = wrappedImage.height-1-ep_c
  
  //Création du tableau des listes de routes potentielles respectives à chaque bordure
  var listes_routes_potentielles:Array[List[Any]]=Array(List(),List(),List(),List())
//------------------------------------------------------------------------------------------------------------------------------------------

  
  // La fonction store_route_potentielle
  def store_route_potentielle(couple:(Int,Int),bordure:Int){
    listes_routes_potentielles(bordure)=(couple)::listes_routes_potentielles(bordure)
  }
  
//------------------------------------------------------------------------------------------------------------------------------------------
//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
//------------------------------------------------------------------------------------------------------------------------------------------

  //Fonction sur le bord haut
  def cherche_bord_haut(img:Array[Array[Int]],e:Int){ //e est l'épaisseur du cadre
    var w1=e
    var w2=e
    var i=0
    while (w1<wmax-1){ //on aura un w1+1
      if (math.abs(img(e+1)(w1)&255-img(e+1)(w1+1)&255)>cmin){
        w2=w1+1
        i=1
        
        while ((math.abs(img(e+1)(w2)&255-img(e+1)(w2+1)&255)<cmin)&i<9&w2<(wmax-1)){
          w2+=1
          i+=1
        }
        
        if (i>2&i!=9) {
          store_route_potentielle((w1,w2),haut)
        }
        
        w1=w2
      }
      
      w1+=1
      
    }
    
  }

  //Fonction sur le bord bas
  def cherche_bord_bas(img:Array[Array[Int]],e:Int){ //e est l'épaisseur du cadre
    var w1=e
    var w2=e
    var i=0
    while (w1<wmax-2){
      if (math.abs(img(hmax)(w1)&255-img(hmax)(w1+1)&255)>cmin){
        w2=w1+1
        i=1
        
        while (math.abs(img(hmax)(w2)&255-img(hmax)(w2+1)&255)<cmin&i<9&w2<wmax-2){//JEN SUIS A CORRIGER ICI
          w2+=1
          i+=1
        }
        
        if (i>2&i!=9&w2!=wmax-2) {
          store_route_potentielle((w1,w2),bas)
        }
        
        w1=w2
      }
      
      w1+=1
    }
  }
  
  //Fonction sur le bord droit
  def cherche_bord_droit(img:Array[Array[Int]],e:Int){ //e est l'épaisseur du cadre
    var h1=e
    var h2=e
    var i=0
    while (h1<hmax-1){
      if (math.abs(img(h1)(wmax-1)&255-img(h1+1)(wmax-1)&255)>cmin){
        h2=h1+1
        i=1
        
        while (math.abs(img(h2)(wmax-1)&255-img(h2+1)(wmax-1)&255)<cmin&i<9&h2<hmax-2){
          h2+=1
          i+=1
        }
        
        if (i>2&i!=9&h2!=hmax-2) {
          store_route_potentielle((h1,h2),droit)
        }
        
        h1=h2
      }
      
      h1+=1
    }
  }
  
  //Fonction sur le bord gauche
  def cherche_bord_gauche(img:Array[Array[Int]],e:Int){ //e est l'épaisseur du cadre
    var h1=e
    var h2=e
    var i=0
    while (h1<hmax){
      if (math.abs(img(h1)(e+1)&255-img(h1+1)(e+1)&255)>cmin){
        h2=h1+1
        i=1
        
        while ((math.abs(img(h1)(e+1)&255-img(h1+1)(e+1)&255)<cmin)&i<9&h2<hmax-2){
          h2+=1
          i+=1
        }
        
        if (i>2&i!=9&h2!=hmax-2) {
          store_route_potentielle((h1,h2),gauche)
        }
        
        h1=h2
      }
      
      h1+=1
    }
  }
  
//------------------------------------------------------------------------------------------------------------------------------------------
//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
//------------------------------------------------------------------------------------------------------------------------------------------

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
//------------------------------------------------------------------------------------------------------------------------------------------
  
  def recherche_route_etape_1(img:Array[Array[Int]],e:Int){ //e est l'épaisseur du cadre
    cherche_bord_haut(img,e)
    cherche_bord_bas(img,e)
    cherche_bord_gauche(img,e)
    cherche_bord_droit(img,e)
  }
  
//------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------
  
  //Code de suivi
  
  var imagePassed : Array[Array[Boolean]] = ofDim[Boolean](wrappedImage.height,wrappedImage.width)
  var imageFin : Array[Array[Int]] = ofDim[Int](wrappedImage.height,wrappedImage.width) //tableau de 0
   

   
   
   //Verifies if pixel is on an edge of the picture
   def estBord(x:Int,y:Int):(Boolean,Boolean,Boolean,Boolean)={
     return (x==0,y==0,y==wrappedImage.width-1,x==wrappedImage.height-1)
   }
   
   
  
   // Modify it
   
   val err:Int=40
   
   def isTooDifferent(x:Int,y:Int,c:Int):Boolean = {
     return (math.abs(c-(image2D(x)(y)&255))>err)
   }
   
    
   def suivre_r(x:Int,y:Int,N:Boolean,O:Boolean,S:Boolean,E:Boolean,c:Int){
	   			
	   			
			   if (imagePassed(x)(y)) 
			   			{
			     //print("Déja passé")
			     } //Checks if we have already been here
			     
				   
			   else { 
				   imagePassed(x)(y)=(true)
				   
				   if (math.abs(c-(image2D(x)(y)&255))>err) { //Checks if the pixel-value is too different to the last one //edited 25/11 proble franchis la barrière
					   //print("Too Diff")
				     }
				   else { // if not...
				     
				     var cnew=image2D(x)(y)&255
					   
				     imageFin(x)(y)=0 // ...save this pixel as black...

							   var (n,o,s,e)=(x!=1,y!=1,x!=hmax,y!=wmax)
							    
							   // ...then proceed to the next pixels if possible.

							   if (n&N) 
							     {
							     //println(x,y,"N")
							     suivre_r(x-1,y,true,true,false,true,cnew)
							     }
							   if (o&O) 
							     {
							     //println(x,y,"O ; ")
							     suivre_r(x,y-1,true,true,true,false,cnew)
							     }
							   if (s&S) {
							     //println(x,y,"S ; ")
							     suivre_r(x+1,y,false,true,true,true,cnew)
							   }
							   if (e&E) {
							     //println(x,y,"E ; ")							     
							    suivre_r(x,y+1,true,false,true,true,cnew)
				   				}
				   }
			   }
   }
  
  
  
  
  
  
  
//--- TESTING AREA --- TESTING AREA --- TESTING AREA --- TESTING AREA --- TESTING AREA --- TESTING AREA --- TESTING AREA --- TESTING AREA --
 
  //listes_routes_potentielles(haut)=5::listes_routes_potentielles(haut)
  
   recherche_route_etape_1(image2D,ep_c
       )
   
  println("haut :",listes_routes_potentielles(haut))
  
  println("bas :",listes_routes_potentielles(bas))  
  
  println("gauche :",listes_routes_potentielles(gauche))
  
  println("droit :",listes_routes_potentielles(droit))
  
  
  println("Initialisation des tableaux 'imagePassed' et 'imageFin'...")
  for (i<-0 to hmax)
     for (j<-0 to wmax){
       imagePassed(i)(j)=false
       imageFin(i)(j)=(-1)
     }
  
  
  /*println("suivi lancé")
  var prout =image2D(6)(618)&255
  suivre_r(6,618,true,true,true,true,prout)
  println("fin")
  
  println("Début boucle for '1' ...")
  for ((y1,y2)<-listes_routes_potentielles(haut)){
    print(".")
    var y=(y1.asInstanceOf[Int]+y2.asInstanceOf[Int])/2
    var c=image2D(6)(y)&255
    suivre_r(6,y,false,true,true,true,c)
    }
  println()
  println("Boucle terminée")*/
  
  
       
   
       /*
     
   for (i<-0 to wrappedImage.height-1)
     for (j<-0 to wrappedImage.width-1)
       image2D(i)(j)=imageFin(i)(j)
       
   //image2D=copy(imageFin)
       
       
  var outputFile:String="Results_Lissage/ATentative_Timothy.jpg"
  wrappedImage.saveImage(outputFile);*/
    
      
//---FIN DE ZONE DE TESTS---FIN DE ZONE DE TESTS---FIN DE ZONE DE TESTS---FIN DE ZONE DE TESTS---FIN DE ZONE DE TESTS---FIN DE ZONE DE TESTS
  
  
  
  
}