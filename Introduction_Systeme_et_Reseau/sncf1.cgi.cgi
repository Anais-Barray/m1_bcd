#!/usr/bin/env python
import sys, os, re

dicovd = {}
dicova = {}

if os.path.isfile("/auto_home/abarray/public_html/horaires.txt"):
	fd=open("/auto_home/abarray/public_html/horaires.txt", "r")
        cont=fd.readlines()
        for ligne in cont:
            recup=re.search("([^ ]*) ([^ ]*).*", ligne) 
            if re :
                vd=recup.group(1)
                va=recup.group(2)
		dicovd[vd] = 1
		dicova[va] = 1


print """Content-type: text/html


<html>
	<body>
		<h2> Bienvenue sur le nouveau site de la SNCFSA </h2>
		<form action="sncf2.cgi">
			Entrez votre ville de d&eacute;part :
			<select name="vd"> """


for vd in dicovd.keys() :
	print "<option>",vd,"</option>"

print """</select>
	<br/><br/>

	Entrez votre ville de d'arriv&eacute;e :
	<select name="va"> """
	
for va in dicova.keys() :
	print "<option>",va,"</option>"

print """</select>
	<br/><br/>

	Entrez l'horaire minimal de d&eacute;part :
	<select name="hd"> """

for i in range(24):
	print "<option>", i ,"</option>"

print """</select>
	<br/><br/>

	Entrez l'horaire maximal de d'arriv&eacute;e :
	<select name="ha"> """

for i in range(24):
	print "<option>", i ,"</option>"

print """</select>
	<br/><br/>
	<input type="submit" value="Soumettez votre demande"/>
	<br/><br/>

</form>
</body>
</html>"""
