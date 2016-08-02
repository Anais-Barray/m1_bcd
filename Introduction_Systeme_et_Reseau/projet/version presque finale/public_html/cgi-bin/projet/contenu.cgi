#!/usr/bin/env python
import sys, os, re, cgi

#fonction permettant d'afficher les dossiers et fichiers, avec leurs images correspondantes.
def afficher_div(index, repertoire, fichier, nom_image):
	print "<div id='dossier"+str(index)+"' style='float :left; width:150px;  height:150px;'>"
	print "	<a href='http://localhost/~jdemontigny/cgi-bin/projet/contenu.cgi?rep=" +repertoire +"/" +fichier +"'>"
	print "		<img src='../../images/"+nom_image+".png' width='50' height='50' /> <br/>"+fichier
#	if (nom_image=="txt") :
#		popuptxt(fichier)
	print "	</a>"
	print "</div>"

print """content-type: text/html

<html>
	<head>
		<style>
			a:link{text-decoration:none;}
		</style>
		<script>
		
		//ouverture d'un fichier txt
	/*	popuptxt(fichier){
			w = window.open('fichier');
			w.print();

		}*/

		//tracking de la souris
		var posX = 0;
		var posY = 0;
		document.onmousemove = function(event) {
		   posX = event.pageX;
		   posY = event.pageY;
		}
		//creation de la box au clic droit selon la position de la souris
		document.oncontextmenu = function() {
			   document.getElementById("actions").style.display = "block";
			   document.getElementById("actions").style.left = posX;
			   document.getElementById("actions").style.top = posY + 25;
                           return false;
                };
		</script>
	</head>
	<body>
		<!-- afficher les options dans le menu contextuel -->
	    <div id="actions" style="display: none; position: absolute; background-color: rgb(200,200,200);">
		<a href=""> renommer </a> <br/>
		<a href=""> supprimer </a> <br/>
	    </div>   
	    
		<h2>affichage du contenu</h2>

"""

# afficher une arborescence, en creant des liste separees pour dossier et fichier pour les ordonner, affichage dossier puis fichiers
def afficher(repertoire):
	listeD=os.listdir(repertoire)
	files=list()
	directories=list()
	for fichier in listeD:
		if os.path.isfile(repertoire+"/"+fichier):
			files.append(fichier)
		elif os.path.isdir(repertoire+"/"+fichier):
			directories.append(fichier)
	files=sorted(files)
	directories=sorted(directories)
	for fichier in directories+files:
		extension=re.search(".*(\..*)", fichier)

#parcourt les listes pour afficher les images correspondantes avec afficher_div()
#i correspond a l'index du fichier
		i=0
		if extension:
			nomext=re.search(".*\.(.*)", fichier)
			if os.path.exists("/auto_home/jdemontigny/public_html/images/"+nomext.group(1)+".png"): #verifie l'existence d'une image correspondant a l'extension dans le dossier contenant les images
				afficher_div(i, repertoire, fichier, nomext.group(1))
				
			else : #si l'extension du fichier n'a pas d'image portant son nom, attribution d'une image par defaut
				afficher_div(i, repertoire, fichier, "defaut")
		else : #cas d'un dossier
			if os.path.isdir (repertoire+"/"+fichier):
				afficher_div(i, repertoire, fichier, "imgdoss")
		i+=1

#premier appel en fonction de la valeur de rep (clef du cgi.FieldStorage())
params={}
params["rep"]=cgi.FieldStorage()["rep"].value
if params.has_key("rep") :
	afficher (params["rep"])

print """
	</body>
</html>"""


