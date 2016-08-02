#!/usr/bin/env python
import sys, os, re

#appel avec http://localhost/~jdemontigny/cgi-bin/projet/liste.cgi?rep=/auto_home/jdemontigny/test/
print """content-type: text/html

<html>
	<head>
		<style>
			ul,li{list-style-type: none;line-height: 5px;margin-left: 2px; padding-left: 0;}
			a:link{text-decoration:none;}
		</style>

	</head>
	<body>
		<h3>arboc</h3>"""
#imprimer une ligne avec racine parent pour revenir au dossier originel. mais mettre une image de dossier different
print "<img src='../../images/racine.png' width='20' height='20' />","<a href='http://localhost/~jdemontigny/cgi-bin/projet/contenu.cgi?rep=/auto_home/jdemontigny/test/'target='droite'>racine</a>"

# affichage recursif d'une arborescence
def afficherliste (liste, indent):
	listeD=os.listdir(liste)
	for dossier in listeD :
		if os.path.isdir (liste+"/"+dossier) :
			tab="&nbsp;&nbsp;&nbsp;" #\t ne marche pas
			print"<ul>"
			#print une image de dossier et le nom des dossiers/sous dossier dans une liste
			print"<li>",indent,"<img src='../../images/imgdoss.png' width='20' height='20' />","<a href='http://localhost/~jdemontigny/cgi-bin/projet/contenu.cgi?rep=" +liste +"/" +dossier +"'","target='droite'",">",dossier,"</a></li>"
			print"</ul>"
			afficherliste (liste+"/"+dossier, indent+tab)

afficherliste ("/auto_home/jdemontigny/test/","")
			
print """
	
	</body>
</html>"""

#TARGET='contenu'
#ul,li{margin-left: 20px; padding-left: 0;}
#&nbsp;&nbsp;&nbsp;	
