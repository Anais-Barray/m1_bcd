#!/usr/bin/perl

die "\n\n\tUsage: tri_fusion.pl <fic1> <fic2>\n\n" unless $#ARGV==1;
open F1, "<$ARGV[0]" or die "Impossible d'ouvrir le fichier $ARGV[0]\n";
open F2, "<$ARGV[1]" or die "Impossible d'ouvrir le fichier $ARGV[1]\n";
@Fich1 = <F1>; @Fich2 = <F2>;  $i1 = 0 ; $i2 = 0 ;

# Traite l'ensemble des lignes des deux fichiers
while ( ($i1 <= $#Fich1) && ($i2 <= $#Fich2) ) {
    # Utile pour le 1er tour de la boucle suivante 
    $Fich1[$i1]  =~ /^chr(\w+)(\s+\d+){2}\s+([-+])/ ;
    $chrom1 = $1 ;  $brin1 = $3 ;
    $Fich2[$i2]  =~ /^chr(\w+)(\s+\d+){2}\s+([-+])/ ;
    $chrom2 = $1 ;  $brin2 = $3 ;
    #$i2++; print "chrom $1 brin : $3\n";
    $fin1=0; $fin2=0;
    # Traiter un bloc commun de Fich1 et Fich2 
    while (  (!$fin1) && (!$fin2)
     && ($chrom1 eq $chrom2) && ($brin1 eq $brin2))  {
      # Recupere positions de debut ds Fich1 et Fich2     
      $Fich1[$i1] =~ /^chr\w+\s+(\d+)/ ;  $deb1 = $1; 
      $Fich2[$i2] =~ /^chr\w+\s+(\d+)/ ;  $deb2 = $1; 
      #print "Debuts : $deb1 $deb2\n";
      if (int($deb1) < int($deb2)) {
        print $Fich1[$i1];$i1++; 
        if ($i1<=$#Fich1) {
        $Fich1[$i1] =~ /^chr(\w+)(\s+\d+){2}\s+([-+])/ ; $chrom1 = $1 ;  $brin1 = $3 ;
        }
        else {$fin1 = 1;} # on a fini le Fich1
      }
      else { print $Fich2[$i2];$i2++;
              if ($i2<=$#Fich2) {
                 $Fich2[$i2] =~ /^chr(\w+)(\s+\d+){2}\s+([-+])/ ; $chrom2 = $1 ;  $brin2 = $3 ;
              }
              else {$fin2 = 1;} # on a fini le Fich2
       }
    }
    # Vider ds le resultat la fin du Fich non fini
    exit;
    while (0) {
    
    }
}















