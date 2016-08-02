#!/usr/bin/perl
use strict;
/* but du script : tri subtil, fct sort() pas suffisante. Faire une fct de tri. recup param $a et $b, renvoi soit un ou l'autre. en python pareillement.
split pour couper les lignes en fct des tabulations : liste de x elmt. tableau ou chq col est repérée par un elmt. 
notre fct de tri : 
	Etant donné deux elmt a ordonner, lequel est le plus petit.
	Comparer suivant la col 1 => on connait le plus petit. Si égalité, comparer la col4, si égalité, comparer col2.

*/
print "1 \n";

open (F,"wt1_short.txt") or die "probleme à l'ouverture du fichier";

my @ligne=<F>;
my @tabTrie = sort tri @ligne;

print "toto\n";

sub tri{

	my @c1 = split /\t/ , $a;
	my @c2 = split /\t/ , $b;

	print "titi";

	if ($c1[0] ne $c2[0]){
		return $c1[0] cmp $c2[0];
	}
	if ($c1[3] ne $c2[3]){
		return $c1[3] cmp $c2[3];
	}
	if ($c1[1] < $c2[1]){
		return -1;
	}
	else {
		return 1;
	}	
	if ($c1[2] < $c2[2]){
		return -1;
	}
	else {
		return 1;
	}	



}
