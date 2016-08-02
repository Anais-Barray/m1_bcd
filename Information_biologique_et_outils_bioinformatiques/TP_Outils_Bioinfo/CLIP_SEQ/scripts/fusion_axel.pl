#!/usr/bin/perl
# By Axel Verdier

use strict;

if (@ARGV != 3){die "nombre de paramètres incorrects, 3 sont demandés : fichier entrant, fichier sortant et l'écart.";}
my $clustersFile=$ARGV[0];
my $fusionFile=$ARGV[1];
my $ecart=$ARGV[2];

open (FILE, "<$clustersFile") or die "impossible d'ouvrir le fichier $clustersFile";
open(OUTFILE, ">$fusionFile") or die "impossible d'écrire le fichier $fusionFile";

my $nbFusion=0;
my $nbCluster=1;

my $l0= <FILE>;
chomp $l0;
my @elem0 = split (/\t/,$l0);
while(<FILE>){     # $_ =<FILE>
	chomp ;     #chomp $_;
	my @l = split /\t/ ;   #split(/\t/,$_);
	#0:chr, 1:début, 2:fin, 3:sens, 4:nombre de reads
	if($elem0[0] eq $l[0] and $elem0[3] eq $l[3] and $elem0[2]+$ecart >= $l[1]){
		$elem0[2]=$l[2];
		$elem0[4]+=$l[4];
		$nbFusion++;
	}
	else{
		print OUTFILE join("\t", @elem0), "\n";
		@elem0=@l;
		$nbCluster++;
	}
}
print OUTFILE join("\t", @elem0), "\n";
close(FILE);
close(OUTFILE);
print "nombre de fusions\t: $nbFusion\n";
print "nombre de clusters\t: $nbCluster\n";
exit;
