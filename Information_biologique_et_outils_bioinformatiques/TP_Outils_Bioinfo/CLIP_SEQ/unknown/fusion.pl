#!/usr/bin/perl

die "Utilisation : fusion.pl <fichier_de_clusters> ecart_en_nb_nucleotides\n" unless ($#ARGV==1); # 2 params exiges

open F, "<$ARGV[0]" or die "Pas possible de lire le fichier $ARGV[0]\n";
$E = $ARGV[1];
@clusters = <F> ; close F;
for  (@clusters) {
	#print ;
	if (/-/) {   push  @NEG , $_  ; } else { push @POS, $_ ; }	
}
#print "$#POS , $#NEG\n";
###########################
# ETAPE 2 : comparaison des clusters POSitifs
Analyse_sens(@POS);
###########################
# ETAPE 3 : comparaison des clusters NEGatifs
Analyse_sens(@NEG);
#print "$fusion fusions realisees\n";

################################# FIN DU SCRIPT #####################

#############
# FONCTION ANALYSANT LES CLUSTERS D'UN SENS
sub Analyse_sens {
	my @TAB = @_;
	$i=0; 
	while ($i<$#TAB) {
		@ligne = split /\t/ , $TAB[$i]; 
		$j = $i +1;   
		$bFusion = 1; # VRAI intialement pour entrer dans la boucle
		while ($bFusion  && ($j<=$#TAB) ) {
			@suiv =  split /\t/ , $TAB[$j];
			if ( ($ligne[0] eq $suiv[0]) && ($suiv[1] - $ligne[2]) < $E) {  
				$fusion ++;
				#modifie le cluster codé dans @ligne
					 #print "fusion :\n".join("\t",@ligne)."\n".join("\t",@suiv);
				$ligne[2] = $suiv[2] ;  $ligne[4] = sprintf ("%.1f\n", $ligne[4] + $suiv[4]); 		
				$j++; # prêt à comparer le prochain cluster
					 #print "-->".join("\t",@ligne)."\n";
				}
			else {$bFusion = 0;} # FAUX
		}
		print join ("\t", @ligne); 	# qu'on ait fusionne dedans ou pas on imprime le cluster $ligne
		$i = $j; # on se positionne sur le prochain cluster qu'on n'a pas reussi a fusionner avec les precedents
	}
	print $TAB[$#TAB]  if (!$bFusion) ; # n'oublie pas le dernier cluster si pas utilise dans une fusion
}  # fin de la fonction

