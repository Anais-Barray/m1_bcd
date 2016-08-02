#!/usr/bin/python
import sys
import re
import os

if len(sys.argv)>1:
	res=re.search("a", sys.argv[1])
	if res:

		if os.path.isfile("/auto_home/jdemontigny/.bashrc"):
			fd=open("/auto_home/jdemontigny/.bashrc", "r")
			cont=fd.readlines()
			for ligne in cont:
				#print ligne
				rre=re.search("alias (.*)=(.*)", ligne)
				if rre:
					print "la ligne de commande", rre.group(1), "est devenue", rre.group(2)
			fd.close()
		else:
			print "pas de fichier bashrc"
	else:
		print "pas d'option a"
#passe a l'option p

	resu=re.search("p", sys.argv[1])
	if resu:
		if os.path.isfile("/auto_home/jdemontigny/.bashrc"):
			fd=open("/auto_home/jdemontigny/.bashrc", "r")
			cont=fd.readlines()
			for ligne in cont:
				rree=re.search("PATH=[^:]+:(.*)\"", ligne)
				#print ligne
				if rree:
					print "Les repertoires suivants ont été rajoues au PATH :", rree.group(1)
			fd.close()
	else:
		print "pas d'option p"
else:
	print "pas d'option. veuillez preciser les options sour la forme commande -option. merci."
