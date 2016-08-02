#include <iostream>
#include <cstring> //calcul de la longueur de la sqc, pas bon pour les longues sqc
#include <bitset> //pour afficher sous forme de bits 01.

//Mettre dans FastXSeq
//créer un tableau d'octet, pb : il faut connaitre la taille du génome (compter long de la seq, créer tableau de cette long)
//pb : si autre nt => T, verif qu'il y ai que des ATGC, sinon pas d'analyse, ou remplacer N par A.
//Standard IUPAC!
//Encode decode compl en privé


using namespace std;

/*
On encode : 
-A/a en 00 (=0)
-C/c en 01 (=1)
-G/g en 10 (=2)
-T/t en 11 (=3)
On sait que : 
-Purine A/G (bit de poids faible = 0)
-Pyrimidine C/T (bit de poids faible = 1)
*/

#define ENCODE(const char nuc) (
return  ((nuc == 'A') || (nuc == 'a') 
	 ? 0 
	 : ((nuc == 'C') || (nuc == 'c') 
	    ? 1 
	    : ((nuc == 'G') || (nuc == 'g') 
	       ? 2 
	       : 3)));
 
inline char DECODE(unsigned char nuc) {
  return (nuc == 0 ? 'A' : (nuc == 1 ? 'C' : (nuc == 2 ? 'G' : 'T')))
//declaration de fct : a un cout.
}

#define COMPL(~ (nuc) & 3)

#define IS_PYRIMIDINE(nuc) ((nuc & 1))

#define IS_PURINE(nuc) (!IS_PYRIMIDINE(nuc))

size_t getOctet(size_t pos) {
  return ((pos +1) / 4) + (((pos + 1) % 4) != 0)
}

suie_t getPlaceInOctet(size_t pos) {
  return (pos % 4);
}



int main(int argc, char** argv){

  char const *seq = NULL;
  if (argc < 2) {
    seq = "AGCTGCTATAGATGCCCTCGATCGTAGCTCGAACGATC";
      } else {
    seq = argv[1];
  }


  size_t n = strlen(seq), l = (n > 0 ? getOctet(n - 1) : 0);
  unsigned char * enc_seq = new unsigned char[l] //crée un tableau de n/4 octet pour stocker la seq.
    for (size_t i = 0; i < l; i++) {
      enc_seq[i] = 0; // permet de mettre plusieurs caractères par octet en précisant la position
    }

  cout << "seq=" << seq << endl;

  for (size_t i = 0; i < n; i++) {
    unsigned char c = ENCODE(seq[i]), cc = COMPL(c);
    cout << seq[i] << ":" << int(c)
       << "(" << DECODE(c)
       <<") ["
       << (IS_PYRIMIDINE(c) ? "Pyrimidine" : "Purine")
       << "]" << endl;

    cout << "compl(" << seq[i] << "):" << (int)c
       << "(" << DECODE(cc)
       << ") [" 
       << (IS_PURINE(cc) ? "Purine" : "Pyrimidine")
       << "]" << endl;
    cout << "L'acide nuc à la position " << i << " dans "
       << seq << " doit être stocké dans l'octet " 
       << getOctet(i) << " à la place "
       << getPlaceInOctet(i) << endl;
    enc_seq[getOctet(i)] |= c << (6-2*getPlaceInOctet(i)<<1));
  cout << "enc_seq[" << getOctet(i) <<  "] = " << bitset<8>(enc_seq[getOctet(i)]) << endl;
  }

cout << "Fin de l'encodage" << endl;

cout << "Décodage de la séquence seq" << endl;
for (size_t i = 0; i < n; i++){
  unsigned char c = (enc_seq[getOctet(i)] >> (6-(getPlacetinOctet(i)<<1))) & 3;
  cout << DECODE(c);
 }
cout << endl;
cout << seq << " (pour rappel)" << endl;


  return 0;
}
