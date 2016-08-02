#!/usr/bin/python
import sys
import re

#fd=open("home/.bashrc", "r")
#cont=fd.readlines()
#for ligne in cont:
	#print ligne
#fd.close()

if len(sys.argv)>1:
	res=re.search("a", sys.argv[1])
	if res:
		print "option a"
	else:
		print "pas d'option a"
	resu=re.search("p", sys.argv[1])
	if resu:
		print "option p"
	else:
		print "pas d'option p"
else:
	print "pas d'option"
