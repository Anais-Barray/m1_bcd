#!/usr/bin/perl
#emplacement de l'interpreteur perl (au depart on est sous shell, qui va pouvoir lancer perl)
#oblige à déclarer les variable, règled de programmation plus strict.
#INPUT : deux fichiers triés contenant des fragments de génome
#-triés de la même façon, d'abord sur le chr, puis sens, puis position début.
#-dont leur colonnes sont : n° chr, pos deb, pos fin, nom, score, sens.
#OUTPUT : 
#-les entrées du fich1 qui ont une intersection avec des entrées du fich2.
#/!\ l'ordre des paramètres importe.

###############################################	

use strict;


if (@ARGV != 2){die "\n\tUsage : $0 file1 file2\nFile1 : the file containing genomic blocks to be filtered\nFile2 : genomic blocks to check intersection with";}


##############################################
##############################################
##############################################


my @block;
my $nomBlock;

# @_ liste des param recus
# $_[0] #1er param recu

#fonction de lecture d'un fichier => dictionnaire
sub Cree_Dico_depuis_fichier{
	open (FICH, "<$_[0]") or die "Cannot open $_[0] file";
	my $ligne1; my %DICO;
	while ($ligne1 = <FICH>) {
	  chomp $ligne1; 	
	  #@elem1 = split /\t/, $ligne1; $nomBlock = "$elem1[0] $elem1[5]";
	  #push $ligne1,@block; #ajoute $ligne1 à la fin de @block; 
	  $ligne1 =~ /^(chr[^\t]+)\t.+\t([+-])$/i;  #=~  : regex, [^\t]+ : tout sauf \t, .+ : au moins un carac, peut etre répété; i = insensible a la casse.
	  $nomBlock = "$1 $2"; #$1 : premier group entre ()	
	  push @{$DICO{$nomBlock}}, $ligne1; #ajoute la $ligne1 dans le tableau @DICO1 à la clé $nomBlock
	}
	close FICH; return %DICO;
}

#Lecture des deux fichiers d'entrée : 
my %DICO1 = Cree_Dico_depuis_fichier($ARGV[0]);
#print "Clefs DICO1 = " . join ("," , keys(%DICO1))."\n"; #affiche les clés jointes par des ','
#print join "\n", @{$DICO1{"chr18 +"}}; 
#print "\n";

my %DICO2 = Cree_Dico_depuis_fichier($ARGV[1]);
#print "Clefs DICO2 = " . join ("," , keys(%DICO2))."\n";
#print join "\n", @{$DICO2{"chr18 +"}}; 
#print "\n";


##############################################
##############################################
##############################################


my $clef;
my $nbIntersect=0;

foreach $clef (keys(%DICO1)){ #pour chaque clé trouvées dans DICO1 cad dans chq block
	if (exists $DICO2{$clef}) {
	
		my @block1 = @{$DICO1{$clef}};
		my @block2 = @{$DICO2{$clef}};
		my $l1=0; #pointeur indiquant la ligne du block en cours de fich1
		my $l2=0;
		
		while (($l1 <= $#block1) && ($l2 <= $#block2)) { #   $# : indice de la derniere case du tableau
			
			my @elem1 = split /\t/, $block1[$l1];
			my @elem2 = split /\t/, $block2[$l2];

			if ( (($elem1[1] <= $elem2[1]) && ($elem2[1] <= $elem1[2]))
			   || (($elem2[1] <= $elem1[1]) && ($elem1[1] <= $elem2[2])) ){ #intersection
				print $block1[$l1]."\n"; $l1++; $nbIntersect++;
			}

			elsif #on avance dans le fichier ayant le block dont la pos de deb est la plus petite
			 
			($elem1[1] < $elem2[1]) {$l1++;} 	else {$l2++;}
				
		}#while parcourant les blocks;
		
	} #si block present dans les deux fichier

}#fin du foreach examinant les blocks du FICH1
print "\nnb intersections : $nbIntersect\n";
#print "i1=$nbIntersect1\n";
#print "i2=$nbIntersect2\n";

##############################################
##############################################
##############################################


#my $i1=0; #pointeur indiquant la ligne du block en cours de fich1
#my $i2=0; #pointeur indiquant la ligne du block en cours de fich2 

#my @ligne2;
#chomp $ligne2[$i2]; #enleve le retour chariot
#my @elem2 = split /\t/, $ligne2[$i2]; #coupe en morceau la ligne2 à l'emplacement i2, en fonction des tab
#my $block2 = $elem2[0] . " " . $elem2[5]; #ensemble de portion sur le meme chr et meme sens. concaténation à l'aide du "."

#my $nbligne=0;
#my $ligne1;
#my @elem1;
#my @ligne2=<FICH2>; close FICH2; #recup les lignes de fich2, les met dans un tableau ligne2


#print "$block2 = *$block2*\n"; #les * : pour être sur qu'on a pas d'espace avant et après (pas d'espace entre chr et sens)
#(exit(1)); #tester le script morceau par morceau.

#recup 1ere ligne du fichier
#$ligne1 = <FICH1>; chomp $ligne1; #Permet d'examiner ligne par ligne dans la boucle tant que.
#my @elem1 = split /\t/, $ligne1; 
#my $block1 = "$elem1[0] $elem1[5]";#my $block1 = $elem1[0] . " " . $elem1[5]; #var qui indique dans quel bloc on est, besoin d'etre initialisé.

#print "block1 et 2 : *$block1* *$block2*\n";


#close FICH1;
#print "\n$nbligne\n";

###############################################	

exit;
