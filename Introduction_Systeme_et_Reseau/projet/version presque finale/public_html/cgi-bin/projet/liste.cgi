#!/usr/bin/env python
import sys, os, re

i = 0

#creation avec javascript animation pour ouverture/fermeture des sous dossiers par clic sur l'image du dossier. beug, reouverture immediate apres la fermeture
print """content-type: text/html

<html>
	<head>
		<style>
			div{list-style-type: none;line-height: 30px;margin-left: 2px; padding-left: 0;}
			a:link{text-decoration:none;}
		</style>
		<script type="text/javascript">
			function gereDossier(id_image){

			 
                		var cible=document.getElementById("div"+id_image);
                					    // alert(""+id_image+" "+cible);
                		if (cible.style.display=="block"){
                		   // alert("block");
                    			document.getElementById("div"+id_image).style.display="none";
                    		}
               			else {
               			 //   alert("none");
                   			document.getElementById("div"+id_image).style.display="block";
                   		}    
                   		//evt.stopImmediatePropagation();
               		}
		</script>

	</head>
	<body>

		<h3>arborescence</h3>"""

#affichage de la racine pour revenir au dossier originel
print "<img src='../../images/racine.png' width='20' height='20' />","<a href='http://localhost/~jdemontigny/cgi-bin/projet/contenu.cgi?rep=/auto_home/jdemontigny/test/'target='droite'>racine</a>"

# affichage recursif d'une arborescence uniquement des dossiers, avec indentation supplementaire a chaque sous dossier, i est l'id du dossier
def afficherliste (liste, indent):
        global i
	listeD=os.listdir(liste)
	for dossier in listeD :
		if os.path.isdir (liste+"/"+dossier) :

			print  "<div>", indent*"&nbsp;&nbsp;" ,"<a href=""> <img id='"+str(i)+"' onClick=gereDossier("+str(i)+"); src='../../images/imgdoss.png' width='20' height='20' /></a>","<a  href='http://localhost/~jdemontigny/cgi-bin/projet/contenu.cgi?rep=" +liste +"/" +dossier +"'","target='droite'",">",dossier,"</a></div>"
			print "<div id='div"+str(i)+"' style='display: block'>"
			i+=1
			afficherliste (liste+"/"+dossier, indent+2)
			print  "</div>"
#premier appel
afficherliste ("/auto_home/jdemontigny/test/",0)
			
print """
	
	</body>
</html>"""

