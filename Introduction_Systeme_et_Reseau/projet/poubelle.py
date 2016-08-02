<script>
		
		var posX = 0;
		var posY = 0;
		document.onmousemove = function(event) {
		   console.log(""+event.pageX+""+event.pageY);
		   posX = event.pageX;
		   posY = event.pageY;
		}
		
		document.oncontextmenu = function() {
			   document.getElementById("actions").style.display = "block";
			   document.getElementById("actions").style.left = posX;
			   document.getElementById("actions").style.top = posY + 25;
                           return false;
                           //ajouter possiblite faire disparaitre menu par clic gauche ailleur. voir, clic droit que sur dossier
                };
		/*
			function clicd(evt){
			   alert(""+evt.pageX+""+evt.pageY);
			   document.getElementById("actions").style.display = "block";
			
			return false; }
			*/
		</script>
		
		
		
		
for dossier in listeD :
		if os.path.isdir (liste+"/"+dossier) :
			tab="&nbsp;&nbsp;&nbsp;" #\t ne marche pas
			print"<ul>"
			#print une image de dossier et le nom des dossiers/sous dossier dans une liste
			print"<li>",indent,"<a href=""> <img id='objet"+str(i) +"' onClick=gereDossier(this); src='../../images/imgdoss.png' width='20' height='20' /></a>","<a  href='http://localhost/~jdemontigny/cgi-bin/projet/contenu.cgi?rep=" +liste +"/" +dossier +"'","target='droite'",">",dossier,"</a></li>"
			print"</ul>"
			i+=1
			afficherliste (liste+"/"+dossier, indent+tab)

afficherliste ("/auto_home/jdemontigny/test/","")
