#!/usr/bin/env python
import sys, os, re, cgi

def afficher_div(index, repertoire, fichier, nom_image):
	print "<div id='dossier"+str(index)+"' style='float :left; width:150px;  height:150px;'>" #code CSS. espace les images
	print "	<a href='http://localhost/contenu.cgi?rep=" +repertoire +"/" +fichier +"'>"
	print "		<img src='../../images/"+nom_image+".png' width='50' height='50' /> <br/>"+fichier
	print "	</a>"
	print "</div>"

#appel avec http://localhost/contenu.cgi?rep=/auto_home/jdemontigny/test/
print """content-type: text/html

<html>
	<head>
		<style>
			a:link{text-decoration:none;}
		</style>
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
		</script>
	</head>
	<body>
		<div id="actions" style="display: none; position: absolute; background-color: rgb(200,200,200);">
      		  <span onClick="renommer('+str(i)+');">renommer</span><br/>
      		  <span> supprimer</span> <br/>
      	  	</div>
	    
		<h2>affichage du contenu</h2>

"""

#afficher menu contextuel clic droit


# afficher une arborescence
def afficher (repertoire):
	listeD=os.listdir(repertoire)
	for fichier in listeD :
		extension=re.search(".*(\..*)", fichier)

#essai de rangeage par type de fichier ou dossier
	#files = sorted(f for f in os.listdir(repertoire) if os.path.isfile(os.path.join(repertoire, f)))	
	#dirs = sorted(d for d in os.listdir(repertoire) if os.path.isdir(os.path.join(repertoire, d)))

#affichage des images en fonction du type de fichier (if) et dossier (else)
		i=0
		if extension:
			nomext=re.search(".*\.(.*)", fichier)
			if os.path.exists("/auto_home/jdemontigny/public_html/images/"+nomext.group(1)+".png"): #verifie, theoriquement, l'existence d'une image correspondant a l'extension
				afficher_div(i, repertoire, fichier, nomext.group(1))

			else : #si le fichier correspondant a l'extension n'existe pas, attribution d'une image par defaut
				afficher_div(i, repertoire, fichier, "defaut")

			#pour print une image, juste mettre print "<img src=..."
			#pour texte, boucle qui print chaque ligne avec /br a la fin de chaque ligne : .readlines()
		else :
			if os.path.isdir (repertoire+"/"+fichier):
				afficher_div(i, repertoire, fichier, "imgdoss")
		i+=1



#besoin des droits d'acces en lecture pour le dossier que l'on veut explorer en HMTL, mais pas besoin en bash car il a les droits
#plus tard : mettre les droits sur tout le repertoire d'accueil? En attendant, creation d'un dossier test


#FieldStorage est un dictionnaire, a pour valeur (value) ce qu'il y a apres "rep" (la clef) dans la barre d'adresse du navigateur
params={}
St=cgi.FieldStorage()
params["rep"]=St["rep"].value
#afficher (cgi.FieldStorage()["rep"].value)

#sert a verifier si il y a un parametre apres rep dans la barre d'adresse, et si non, ou si non conforme, envoie automatique sur test
#hey, ca marche pas, on reviendra dessus plus tard. avec d'autre verifications
if params.has_key("rep") :
	afficher (params["rep"])
#else :
#	afficher ("/auto_home/jdemontigny/test/")


print """
	</body>
</html>"""


