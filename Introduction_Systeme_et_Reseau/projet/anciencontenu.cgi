#!/usr/bin/env python
import sys, os, re, cgi

#Faire une fonction pour afficher les images, à appeler plus tard avec pour paramètre l'extension, fera changer le type d'image à afficher.
def blocprint(extension) :

	print "<div style='float :left; width:150px;  height:150px;'>" #code CSS. espace les images
	print "	<a href='http://localhost/~jdemontigny/cgi-bin/projet/contenu.cgi?rep=" +repertoire +"/" +fichier +"'>"
	print "		<img src='../../images/"+extension+".png' width='50' height='50' /> <br/>"+fichier #affichage de l'image en fonction de l'extension du fichier. nomext.group(1) est le nom de l'extension. prend l'image .png dont le nom est nomext.group(1)
	print "	</a>"
	print "</div>"

#appel avec http://localhost/~jdemontigny/cgi-bin/projet/contenu.cgi?rep=/auto_home/jdemontigny/test/
print """content-type: text/html

<html>
	<head>
		<style>
			a:link{text-decoration:none;}
		</style>
	</head>
	<body>
		<h2>affichage du contenu</h2>
	<BODY oncontextmenu="return false" >
"""

#afficher menu contextuel clic droit

print"""

"""
# afficher une arborescence
def afficher (repertoire):
	listeD=os.listdir(repertoire)
	files=list()
	directories=list()
	for fichier in listeD:
		if os.path.isfile(fichier):
			files.append(fichier)
		elif os.path.isdir(fichier):
			directories.append(fichier)
	files=sorted(files)
	directories=sorted(dirs)
	for fichier in directories+files :
		extension=re.search(".*(\..*)", fichier)


#affichage des images en fonction du type de fichier (if) et dossier (else)
		if extension:
			nomext=re.search(".*\.(.*)", fichier)
			if os.path.exists("auto_home/jdemontigny/public_html/images/"+nomext.group(1)+".png"): #verifie, theoriquement, l'existence d'une image correspondant a l'extension
				blocprint('nomext.group(1)') #entre '' car c'est une string qu'on passe en parametre.

			else : #si le fichier correspondant a l'extension n'existe pas, attribution d'une image par defaut
				blocprint('defaut')
			#pour print une image, juste mettre print "<img src=..."
			#pour texte, boucle qui print chaque ligne avec /br a la fin de chaque ligne : .readlines()

#if (nomext.group(1)==txt or nomext.group(1)==py or nomext.group(1)==cgi or nomext.group(1)==sql):
#	fd = open(fichier)
#	for lines in fd.readlines():
#		print lines.replace("\n","<br/>")
#	fd.close()

		else :
			blockprint('imgdoss')



#besoin des droits d'acces en lecture pour le dossier que l'on veut explorer en HMTL, mais pas besoin en bash car il a les droits
#plus tard : mettre les droits sur tout le repertoire d'accueil? En attendant, creation d'un dossier test


#FieldStorage est un dictionnaire, a pour valeur (value) ce qu'il y a apres "rep" (la clef) dans la barre d'adresse du navigateur
params=cgi.FieldStorage()
#params["rep"]=cgi.FieldStorage()["rep"].value
#afficher (cgi.FieldStorage()["rep"].value)

#sert a verifier si il y a un parametre apres rep dans la barre d'adresse, et si non, ou si non conforme, envoie automatique sur test
#hey, ca marche pas, on reviendra dessus plus tard. avec d'autre verifications
if "rep" in params.keys(): #même chose que if params.has_key("rep"), mais version python 3.
	afficher (params["rep"])
#else :
#	afficher ("/auto_home/jdemontigny/test/")


print """
	</body>
</html>"""


