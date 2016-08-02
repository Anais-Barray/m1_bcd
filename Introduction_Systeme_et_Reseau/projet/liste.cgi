#!/usr/bin/env python
import sys, os, re

i = 0

#appel avec http://localhost/~jdemontigny/cgi-bin/projet/liste.cgi?rep=/auto_home/jdemontigny/test/
print """content-type: text/html

<html>
	<head>
		<style>
			div{list-style-type: none;line-height: 30px;margin-left: 2px; padding-left: 0;}
			a:link{text-decoration:none;}
		</style>
		<script type="text/javascript">
			function gereDossier(id_image){

			 
                		var cible=document.getElementById("div"+id_image);
                					    // alert(""+id_image+" "+cible);
                		if (cible.style.display=="block"){
                		   // alert("block");
                    			document.getElementById("div"+id_image).style.display="none";
                    		}
               			else {
               			 //   alert("none");
                   			document.getElementById("div"+id_image).style.display="block";
                   		}    
                   		//evt.stopImmediatePropagation();
               		}
		</script>

	</head>
	<body>

		<h3>arboc</h3>"""
#imprimer un ligne avec racine parent pour revenir au dossier originel. mais mettre une image de dossier different
print "<img src='../../images/racine.png' width='20' height='20' />","<a href='http://localhost/~jdemontigny/cgi-bin/projet/contenu.cgi?rep=/auto_home/jdemontigny/test/'target='droite'>racine</a>"

# affichage recursif d'une arborescence
def afficherliste (liste, indent):
        global i
	listeD=os.listdir(liste)
	for dossier in listeD :
		if os.path.isdir (liste+"/"+dossier) :
			
			#print une image de dossier et le nom des dossiers/sous dossier dans une liste
			print  "<div>", indent*"&nbsp;&nbsp;" ,"<a href=""> <img id='"+str(i)+"' onClick=gereDossier("+str(i)+"); src='../../images/imgdoss.png' width='20' height='20' /></a>","<a  href='http://localhost/~jdemontigny/cgi-bin/projet/contenu.cgi?rep=" +liste +"/" +dossier +"'","target='droite'",">",dossier,"</a></div>"
			print "<div id='div"+str(i)+"' style='display: block'>"
			i+=1
			afficherliste (liste+"/"+dossier, indent+2)
			print  "</div>"

afficherliste ("/auto_home/jdemontigny/test/",0)
			
print """
	
	</body>
</html>"""

#TARGET='contenu'
#ul,li{margin-left: 20px; padding-left: 0;}
#&nbsp;&nbsp;&nbsp;	
