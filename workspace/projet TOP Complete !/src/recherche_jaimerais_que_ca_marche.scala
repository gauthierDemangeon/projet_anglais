

object recherche_jaimerais_que_ca_marche extends App {
  


  
//------------------------------------------------------------------------------------------------------------------------------------------
  
  // Import the API library
   import com.tncy.top.image.ImageWrapper;
   import Array._

   // Source image file
   var fileName : String = "sampleImage.jpg";

   // Load wrapped image
   var wrappedImage : ImageWrapper = new ImageWrapper("Results_Lissage/LissageEM2 8.jpg");
   // Get the image
   var image2D : Array[Array[Int]] = wrappedImage.getImage();/*

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
  val e=20
  //Largeur max, hauteur max
  val wmax = wrappedImage.width-1
  val hmax = wrappedImage.height-1
  
  //Création du tableau des listes de routes potentielles respectives à chaque bordure
  var listes_routes_potentielles:Array[List[Any]]=Array(List(),List(),List(),List())
//------------------------------------------------------------------------------------------------------------------------------------------

  
  // La fonction store_route_potentielle
  def store_route_potentielle(couple:(Int,Int),bordure:Int){
    listes_routes_potentielles(bordure)=(couple)::listes_routes_potentielles(bordure)
  }
//------------------------------------------------------------------------------------------------------------------------------------------
  
  //Idée pour améliorer la fonction contour :
  
  
  
 
  
  
  //Si on part de l'hypothese qu'une fonction contour a été créée, et qui stocke True  là ou il y a des contours :
  //TODO Fonction CONTOUR booleenne
  
//------------------------------------------------------------------------------------------------------------------------------------------

  //Fonction sur le bord haut
  def cherche_bord_haut(img:Array[Array[Int]]){
    var w1=0
    var w2=0
    var i=0
    while (w1<wmax-2){
      if (math.abs(img(w1)(0)&255-img(w1+1)(0)&255)>e){
        w2=w1+1
        i=1
        
        while (!(math.abs(img(w2)(0)&255-img(w2+1)(0)&255)<e)&i<9&w2<(wmax-2)){
          w2+=1
          i+=1
        }
        
        if (i>2&i!=9&w2!=wmax-2) {
          store_route_potentielle((w1,w2),haut)
        }
        
        w1=w2
      }
      
      w1+=1
      
    }
    
  }

  //Fonction sur le bord bas
  def cherche_bord_bas(img:Array[Array[Int]]){
    var w1=0
    var w2=0
    var i=0
    while (w1<wmax-2){
      if (math.abs(img(w1)(hmax)&255-img(w1+1)(hmax)&255)>e){
        w2=w1+1
        i=1
        
        while (math.abs(img(w2)(hmax)&255-img(w2+1)(hmax)&255)<e&i<9&w2<wmax-2){
          w2+=1
          i+=1
        }
        
        if (i>2&i!=9&w2!=wmax-1) {
          store_route_potentielle((w1,w2),bas)
        }
        
        w1=w2
      }
      
      w1+=1
    }
  }
  
  //Fonction sur le bord droit
  def cherche_bord_droit(img:Array[Array[Int]]){
    var h1=0
    var h2=0
    var i=0
    while (h1<hmax){
      if (math.abs(img(wmax)(h1)&255-img(wmax)(h1+1)&255)>e){
        h2=h1+1
        i=1
        
        while (math.abs(img(wmax)(h2)&255-img(wmax)(h2+1)&255)<e&i<9&h2<hmax-2){
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
  def cherche_bord_gauche(img:Array[Array[Int]]){
    var h1=0
    var h2=0
    var i=0
    while (h1<hmax){
      if (math.abs(img(0)(h1)&255-img(0)(h1+1)&255)>e){
        h2=h1+1
        i=1
        
        while ((math.abs(img(0)(h1)&255-img(0)(h1+1)&255)<e)&i<9&h2<hmax-2){
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
  
  def recherche_route_etape_1(img:Array[Array[Int]]){
    cherche_bord_haut(img)
    cherche_bord_bas(img)
    cherche_bord_gauche(img)
    cherche_bord_droit(img)
  }
  
//------------------------------------------------------------------------------------------------------------------------------------------
    
  def recherche_route_etape_2(trouvés:Array[List[Any]]){
  }
//------------------------------------------------------------------------------------------------------------------------------------------
  
  //Code de suivi
  
  var imagePassed : Array[Array[Boolean]] = ofDim[Boolean](wrappedImage.height,wrappedImage.width)
  var imageFin : Array[Array[Int]] = ofDim[Int](wrappedImage.height,wrappedImage.width) //tableau de 0
   
   //Lancement de la recherche de chemins
  /* def recherche(srce:Array[Array[Int]]){
     
     
     
     var trouv=false
     var pos1=(0,0)
     var pos2=(0,0)
     for (L<-1 to wrappedImage.width-1)
       if (false)
         
   }*/
   
   
   
   //Verifies if pixel is on an edge of the picture
   def estBord(x:Int,y:Int):(Boolean,Boolean,Boolean,Boolean)={
     return (x==0,y==0,y==wrappedImage.width-1,x==wrappedImage.height-1)
   }
   
   
  
   // Modify it
   
   val err:Int=20
   
   def isTooDifferent(x:Int,y:Int,c:Int):Boolean = {
     return (math.abs(c-(image2D(x)(y)&255))>err)
   }
   
    
   def suivre_r(x:Int,y:Int,N:Boolean,O:Boolean,S:Boolean,E:Boolean,c:Int){
	   			
     //comp.+(1)
	   			
	   			
			   if (imagePassed(x)(y)) 
			   			{} //Checks if we have already been here
			     
				   
			   else { 
				   imagePassed(x)(y)=(true)
				   
				   if (math.abs(c-(image2D(x)(y)&255))>err) { //Checks if the pixel-value is too different to the last one //edited 25/11 proble franchis la barrière
					   }
				   else {
				     /*if (comp==9) {
				       c=image2D2(x)(y)
				       comp.!=(0)
				     }*/
				     // if not...
				     
				     var cnew=image2D(x)(y)&255
					   
				     imageFin(x)(y)=0 // ...save this pixel...

							   var (n,o,s,e)=(x!=0,y!=0,x!=wrappedImage.height-1,y!=wrappedImage.width-1)
							    // ...and proceed to the next pixels if possible.


							   if (n&N) 
							     {
							     //println(x,y,"N")
							     suivre_r(x-1,y,true,true,false,true,cnew)
							     }
							   if (o&O) 
							     {
							     //println(x,y,"O ; ")
							     suivre_r(x,y-1,true,false,true,false,cnew)
							     }
							   if (s&S) {
							     //println(x,y,"S ; ")
							     suivre_r(x+1,y,false,true,true,true,cnew)
							   }
							   if (e&E) {
							     //println(x,y,"E ; ")							     
							    suivre_r(x,y+1,true,false,true,true,cnew)//PROBLEME RECURSION A DROITE
				   				}
				   }
			   }
   }
  
  
  
  
  
  
  
//--- TESTING AREA --- TESTING AREA --- TESTING AREA --- TESTING AREA --- TESTING AREA --- TESTING AREA --- TESTING AREA --- TESTING AREA --
  listes_routes_potentielles(haut).::(5)
  listes_routes_potentielles(haut)=5::listes_routes_potentielles(haut)
  recherche_route_etape_1(image2D)
  println(listes_routes_potentielles(haut))
  
  println("Initialisation des tableaux 'imagePassed' et 'imageFin'...")
  for (i<-0 to wrappedImage.height-1)
     for (j<-0 to wrappedImage.width-1){
       imagePassed(i)(j)=false
       imageFin(i)(j)=(-1)
     }
  println("Début boucle for '1' ...")
  for ((x1,x2)<-listes_routes_potentielles(haut)){
    print(".")
    var x=(x1.asInstanceOf[Int]+x2.asInstanceOf[Int])/2
    var c=image2D(x)(0)&255
    suivre_r(x,0,false,true,true,true,c)
    }
  println()
  println("Boucle terminée")
  
  
       
   
       
     
       
   /*for (i<-0 to wrappedImage.height-1)
     for (j<-0 to wrappedImage.width-1){
       image2D(i)(j)=imageFin(i)(j)
       print(image2D(i)(j))}*/
       
       */
   image2D(87)(76)=98764
  var outputFile:String="Results_Lissage/ATentative_Timothy.jpg"
  wrappedImage.saveImage(outputFile);
    
      
//---FIN DE ZONE DE TESTS---FIN DE ZONE DE TESTS---FIN DE ZONE DE TESTS---FIN DE ZONE DE TESTS---FIN DE ZONE DE TESTS---FIN DE ZONE DE TESTS
  
  
  
  

}