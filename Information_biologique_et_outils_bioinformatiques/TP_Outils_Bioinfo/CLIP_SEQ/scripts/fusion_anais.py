#!/usr/bin/python
import sys, os


#test de l'existence des 3 parametres : 
if len(sys.argv) == 4:
	fichc = sys.argv[1]
	fichf = sys.argv[2]
	e = int(sys.argv[3])

else:
	print "usage : fichier_cluster, fichier_fusion, ecart"
	sys.exit(1)

#creation fichier de fusion
fout=open(fichf, 'w')

#ouverture fichier de cluster et recuperer chaque ligne
if os.path.exists(fichc):
	fd1=open(fichc, 'r')
else:
	print "fichier",fichc,"non existant"
	
content = fd1.readlines()
fd1.close()

#declaration des variables nom de colonne
chrom = 0 ; deb = 1 ; fin = 2 ; sens = 3 ; nbtags = 4
#nb de fusion realisee
nbfusion = 0 


#comparaison des l0 et l1 du fichier pour fusion des cluster
l0 = content.pop(0) #equivalent a shift(). recup la val a l'indice 0 et le suppr de cont1.
#separe la ligne en colonne
elem0 = l0.rstrip() #enleve la partie a droite : enleve le \n, car il pose un pb dans le cas ou fusion des nbtag car on perd le \n
elem0 = l0.split('\t') 
for l in content:
	elem = l.rstrip().split('\t')
	if ((elem0[chrom] == elem[chrom]) and (elem0[sens] == elem[sens]) and ((int(elem[deb]) - int(elem0[fin])) <= e)):
		#fusion
		nbfusion += 1
		elem0[fin] = elem[fin]
		elem0[nbtags] = str(float(elem0[nbtags]) + float(elem[nbtags]))
	else :
		#pas de fusion : ajout dans fichier de fusion
		fout.write('\t'.join(elem0) + '\n') # inverse du split, on doit tout reconcatener ensemble
		elem0 = elem # elem devient le nouveau elem0, au prochain tour de boucle, nouveau elem.
	
#on ecrit le dernier cluster
fout.write('\t'.join(elem0) )
fout.close()

print "Nombre de fusions realisees : ", nbfusion





