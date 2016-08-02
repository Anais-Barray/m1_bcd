#!/usr/bin/env python
import sys, os, re


# afficher une arborescence
def afficher (repertoire):
	print "je suis dans le repertoire ", repertoire
	listeD=os.listdir(repertoire)
	for fichier in listeD :
		os.path.isdir (repertoire+"/"+fichier)
		print fichier

afficher("/auto_home/jdemontigny")







#		parcourir (repertoire+"/"+dossier)
#	else:
#		print "ceci n'est pas un dossier"



