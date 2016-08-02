#!/usr/bin/python
# -*- coding: utf8 -*-
import sys, os, re

#creation dictionnaire d'extensions
dictionnaire={'pas de suffixe':0}

#parcourir une arborescence
def parcours(repertoire):
	print "je suis dans le dossier", repertoire
	listeFichier=os.listdir(repertoire)
	for fichier in listeFichier:
		if os.path.isdir(repertoire+"/"+fichier):
			parcours(repertoire+"/"+fichier)
		else :#MAJ dico
			recup=re.search(".*(\..*)",  fichier)
			if recup:
				clef=recup.group(1)
				if dictionnaire.has_key(clef):
					dictionnaire[clef]=dictionnaire[clef]+1
				else:
					dictionnaire[clef]=1
			else:
				dictionnaire['pas de suffixe']+=1

parcours(sys.argv[1])
#parcours("/auto_home/abarray")

#afficher le contenu du dictionnaire
total=0
clefs = dictionnaire.keys()
clefs.sort()
for elt in clefs :
	print elt, ":", dictionnaire[elt]
	total+=dictionnaire[elt]
print "total=", total

