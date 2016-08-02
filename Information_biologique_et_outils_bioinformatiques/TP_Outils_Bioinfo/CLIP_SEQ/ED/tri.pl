#!/usr/bin/perl
use strict;
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
