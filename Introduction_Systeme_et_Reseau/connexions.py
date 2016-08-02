#!/usr/bin/python
import sys,os,re

dico = {}


listeConnexions = os.popen("last")
for ligne in listeConnexions:
	#print ligne
	recup=re.search("([^ ]*) *[^ ]* *[^ ]* *([a-zA-Z]{3} *[a-zA-Z]{3} *[0-9])+ *[0-9]{2}:[0-9]{2} *(.*)", ligne) 
	#[^ ]: sauf espace. ([^ ]*): n'importe quoi sauf espace
	#faire sous expression reguliere

	if recup :
		login=recup.group(1)
		date=recup.group(2)	
		recupfin=re.search("- [0-9]{2}:[0-9]{2} *\(([0-9]{2}):([0-9]{2})\)", recup.group(3)) 
		#print "login : ", login, "	date : ", date

		#if recupfin :
		#	nb_heures=recupfin.group(1)
		#	nb_minutes=recupfin.group(2)
		#	print "login : ", login, "	date : ", date, "	heures : ", nb_heures, "	minutes : ", nb_minutes
		


		if dico.has_key(login):
			if dico[login].has_key(date):
				dico[login][date]+=1
			else :
				dico[login][date]=1
		else:
			dico[login] = {}
			dico[login][date]=1

for login in dico.keys():
	print login, ":", dico[login]

