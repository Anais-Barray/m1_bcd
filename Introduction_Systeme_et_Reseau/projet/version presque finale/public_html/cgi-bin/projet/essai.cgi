#!/usr/bin/env python
import sys, os, re, cgi, shutil

#fonction permettant d'afficher les dossiers et fichiers, avec leurs images correspondantes.
def afficher_div(index, repertoire, fichier, nom_image):
	print "<div id='dossier"+str(index)+"' style='float :left; width:150px;  height:150px;'>"
		if os.path.isdir(repertoire+"/"+fichier):
			print "	<a href='http://localhost/~jdemontigny/cgi-bin/projet/contenu.cgi?rep="+repertoire+"/"+fichier+"'>"
			print "		<img src='../../images/"+nom_image+".png' width='50' height='50' /> <br/>"+fichier
			print "	</a>"
		else :
			print "	<a href='http://localhost/~jdemontigny/test/"+fichier +"' target='_blank'>" #_blank fait apparaitre une popup avec le contenu texte par exemple, si target='droite', fait apparaitre le txt dans la frame de droite
			print "		<img src='../../images/"+nom_image+".png' width='50' height='50' /> <br/>"+fichier
			print "	</a>"
		print 	"""
		<form method='GET' id='renom_id+str(index)' action='http://localhost/~jdemontigny/cgi-bin/projet/contenu.cgi?rep="""+repertoire+"/"+fichier+"""' style='display:none' position: absolute; left:'<script>document.write(posX)</script>'; top:'<script>document.write(posY)</script>' >
			<label id="renomm">Entrez votre nouveau nom ici</label>
			<input type='text' name='renom'></input>
			<input type='hidden' name='ancien_nm'>"""repertoire+"/"+fichier"""</input>
			<button type='submit'>OK</button>
		</form>
		<form method='GET' id='suppr_id+str(index)' action='http://localhost/~jdemontigny/cgi-bin/projet/contenu.cgi?rep="""+repertoire+"/"+fichier+"""' style='display:none' position: absolute; left:'<script>document.write(posX)</script>'; top:'<script>document.write(posY)</script>' >
			<label id="suppr">Voulez vous vraiment supprimer ce fichier ?</label>
			<input type='hidden' name='nom_a_suppr'>"""repertoire+"/"+fichier"""</input>
			<button type='submit'>oui</button>
			<button type='reset' onClick="disparition_form(index)">non</button>
		</form>
	print "</div>"

print """content-type: text/html

#Les fonctions suivantes fonctionneraient en théorie si le click droit reconnaissait qu'il s'agit d'un dossier (par son index) et non les coordonnées (x,y) de la souris.
def renommer(ancien_nom_get,nouveau_nom_get)
	nouveau_nom=""
	ancien_nom=""
	
	if ancien_nom_get != null :
		ancien_nom = ancien_nom_get
	else :
		ancien_nom = null
			
	if nouveau_nom_get != null :
		nouveau_nom = nouveau_nom_get
	else :
		nouveau_nom = null
		
	if ((nouveau_nom != null) and (ancien_nom != null)):
		os.rename(ancien_nom,nouveau_nom)
	#recharger la page
		
renommer(cgi.FieldStorage()["ancien_nm"].value,cgi.FieldStorage()["renom"].value)

def supprimer(element_a_suppr_get)
	path_element_suppr = ""
	
	if element_a_suppr_get != null :
		path_element_suppr = element_a_suppr_get
		
		if os.path.isfile(path_element_suppr):
			os.remove(path_element_suppr)
			
		elif os.path.isdir(path_element_suppr):
			shutil.rmtree(path_element_suppr)

supprimer(cgi.FieldStorage()["nom_a_suppr"].value)

<html>
	<head>
		<style>
			a:link{text-decoration:none;}
			ul{list-style:none;}
		</style>
		<script>
		
		afficher_form_renom(index){
			document.getElementById("renom_id"+str(index)).style.display = "block";
		};
		
		afficher_form_suppr(index){
			document.getElementById("suppr_id"+str(index)).style.display = "block";
		};
		
		disparition_form(index){
			document.getElementById("suppr_id"+str(index)).style.display = "none";
		};
		
		//tracking de la souris
		var posX = 0;
		var posY = 0;
		document.onmousemove = function(event) {
		   posX = event.pageX;
		   posY = event.pageY;
		}
		//creation de la box au clic droit selon la position de la souris
		document.oncontextmenu = function() {
			   document.getElementById("actions").style.display = "block";
			   document.getElementById("actions").style.left = posX;
			   document.getElementById("actions").style.top = posY + 25;
                           return false;
                };
				
		//
		</script>
	</head>
	<body>
		<!-- afficher les options dans le menu contextuel -->
	    <div id="actions" style="display: none; position: absolute; background-color: rgb(200,200,200);">
			<ul>
				<li><a href="" onClick=afficher_form_renom(index)> renommer </a></li>
				<li><a href="" onClick=afficher_form_suppr(index)> supprimer </a></li>
			</ul>
	    </div>   
	    
		<h2>affichage du contenu</h2>

"""

# afficher une arborescence, en creant des liste separees pour dossier et fichier pour les ordonner, affichage dossier puis fichiers
def afficher(repertoire):
	listeD=os.listdir(repertoire)
	files=list()
	directories=list()
	for fichier in listeD:
		if os.path.isfile(repertoire+"/"+fichier):
			files.append(fichier)
		elif os.path.isdir(repertoire+"/"+fichier):
			directories.append(fichier)
	files=sorted(files)
	directories=sorted(directories)
	for fichier in directories+files:
		extension=re.search(".*(\..*)", fichier)

#parcourt les listes pour afficher les images correspondantes avec afficher_div()
#i correspond a l'index du fichier
		i=0 #servira d'ID, appelé index par la suite
		if extension:
			nomext=re.search(".*\.(.*)", fichier)
			if os.path.exists("/auto_home/jdemontigny/public_html/images/"+nomext.group(1)+".png"): #verifie l'existence d'une image correspondant a l'extension dans le dossier contenant les images
				afficher_div(i, repertoire, fichier, nomext.group(1))
				
			else : #si l'extension du fichier n'a pas d'image portant son nom, attribution d'une image par defaut
				afficher_div(i, repertoire, fichier, "defaut")
		else : #cas d'un dossier
			if os.path.isdir (repertoire+"/"+fichier):
				afficher_div(i, repertoire, fichier, "imgdoss")
		i+=1

#premier appel en fonction de la valeur de rep (clef du cgi.FieldStorage())
params={}
params["rep"]=cgi.FieldStorage()["rep"].value
if params.has_key("rep") :
	afficher (params["rep"])

print """
	</body>
</html>"""


