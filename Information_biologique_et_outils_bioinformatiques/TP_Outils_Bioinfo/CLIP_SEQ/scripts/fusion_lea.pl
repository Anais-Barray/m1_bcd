#!/usr/bin/perl


use strict;

# @ARGV est le tableau qui contient tous les arguments de la ligne de commande. 
# Un tableau "total" est précédé d'un @ : @tableau
# Une variable est précédée d'un $ : $variable
# Un tableau a des cases numérotées de 0 À N-1
# Chaque case d'un tableau contient une variable
# Pour accéder à la case 0, on utilise donc la variable $tableau[0]


# Bon ici c'est un peu dégueulasse, en fait si on utilise @tableau comme une variable, ça renvoie la taille du tableau
# C'est comme si tu faisais : $taille = @ARGV ; C'est laid :D
# Si la taille est différente de 3, le programme s'arrête en affichant une erreur
if (@ARGV != 3){die "nombre de paramètres incorrects, 3 sont demandés : fichier entrant, fichier sortant et l'écart.";}

# Ici tu crées 3 variables, chacune correspondant à 1 case du tableau
my $clustersFile=$ARGV[0];
my $fusionFile=$ARGV[1];
my $ecart=$ARGV[2];


# Alooors on ouvre 2 fichiers : 1 en lecture, et 1 en écriture
# FILE et OUTFILE sont des "pointeurs" vers le début du fichier (je t'expliquerai après), on les crée ici
#Ouvrir un fichier en lecture  "< $variablequicontientlenomdufichieràouvrir"
# Ouvrir un fichier en écriture (attention ça l'efface s'il existe déjà) : #> $nomdufichieràécrire"
# Si on arrive pas à l'ouvrir, on die - le prog s'arrête avec un message d'erreur
open (FILE, "<$clustersFile") or die "impossible d'ouvrir le fichier $clustersFile";
open(OUTFILE, ">$fusionFile") or die "impossible d'écrire le fichier $fusionFile";

# Bon je sais pas ce que ce programme fait car je connais pas ces fichiers, là on initialises 2 compteurs
my $nbFusion=0;
my $nbCluster=1;

# ALORS pour lire une ligne d'un fichier qu'on a ouvert, on fait $ligne = <POINTEURDUFICHIER>
# DU coup on va stocker dans la variable toute la ligne jusqu'au marqueur de saut de ligne
# Et du coup le pointeur va se trouver au début de la ligne suivante
my $l0= <FILE>;  # Donc ici on stocke la 1e ligne du fichier dans la variable $l0
chomp $l0; # chomp est une commande qui supprime le marqueur de fin de ligne qui a aussi été stocké dans la variable, car la 1e ligne finit par un saut de ligne
my @elem0 = split (/\t/,$l0); # split sépare une variable en différents éléments séparés d'un séparateur ( ici la tabulation \t ), et stocke tous les éléments dans un tableau (ici @elem0)
while(<FILE>){     # Alors là c'est un raccourci d'écriture moche. Normalement on fait while($ligne=<FILE>), donc "tant qu'on peut mettre une ligne dans $line et mettre le pointeur à la ligne suivante"
					# Faire while(<FILE>), c'est un raccourci, perl comprend qu'on utilise une variable implicite qui s'appelle $_
					# Beaucoup de programmateurs perl l'utilisent, moi j'aime pas parce qu'on voit pas explicitement qu'on crée une variable, mais bon chacun son truc...
					# Donc en gros retiens : while(<LINE>) c'est "Tant qu'on peut mettre dans la variable $_ la ligne indiquée par le pointeur FILE, on le fait et on bouge le pointeur vers la ligne suivante
	chomp ;     #chomp $_; Là on chompe la variable implicite $_ , donc on vire le marqueur de fin de ligne \n comme précédemment - si j'avais utilisé avant while($ligne=<FILE>), je ferais un chomp($ligne);
	my @l = split /\t/ ;   #split(/\t/,$_); # Pareil, on crée un tableau @l qui contient les éléments de la ligne séparés par une tabulation \t
							# Proprement, ça ferait my @l = split(/\t\,$ligne);
							
	#0:chr, 1:début, 2:fin, 3:sens, 4:nombre de reads # Bon je suppose que là il se fait un rappel des éléments du tableau
	# DU coup proprement tu peux faire $chr=$elem0[0] , $debut=$elem0[1] , $fin=$elem0[2], etc etc...
	if($elem0[0] eq $l[0] and $elem0[3] eq $l[3] and $elem0[2]+$ecart >= $l[1]){ # Bon là j'ai la flemme de décortiquer tu devrais comprendre :D
		$elem0[2]=$l[2];
		$elem0[4]+=$l[4];# Ça équivaut à faire $elem0[4] = $elem0[4] + $l[4]
		$nbFusion++; # On incrémente le compteur, c'est équivalent à $nbFusion=$nbFusion+1
	}
	else{
		print OUTFILE join("\t", @elem0), "\n"; # Si la condition n'est pas respectée, on printe dans le fichier de sortie les éléments du tableau @elem0 séparés par une tabulation \t - join, c'est l'inverse du split
												# Et on ajoute un \n à la fin pour finir la ligne
												# Je trouve la syntaxe moche, là moi j'écrirais :
												# $newline = join("\t",@elem0);
												# print OUTFILE $newline."\n";
		@elem0=@l; # On remplace le contenu de @elem0 par le contenu de @l (OUAIS JE SAIS PAS POURQUOI MAIS ON PEUT LE FAIRE)
		$nbCluster++; # ON incrémente le compteur comme on l'a fait avant pour $nbFusion
	}
}
print OUTFILE join("\t", @elem0), "\n"; # Idem que ligne 59
close(FILE); # On ferme joliment nos petits fichiers
close(OUTFILE);
# On affiche nos compteurs
print "nombre de fusions\t: $nbFusion\n";
print "nombre de clusters\t: $nbCluster\n";
# ET TADAAA C'EST FINIIIIII
exit;
