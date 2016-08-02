#include <iostream>
#include <cstring> //calcul de la longueur de la sqc, pas bon pour les longues sqc
#include <bitset> //pour afficher sous forme de bits 01.
//cmd avec # => analyse par le processeur lors de la compilation.
//Mettre dans FastXSeq
//créer un tableau d'octet, pb : il faut connaitre la taille du génome (compter long de la seq, créer tableau de cette long)
//pb : si autre nt => T, verif qu'il y ai que des ATGC, sinon pas d'analyse, ou remplacer N par A.
//Standard IUPAC!
//Encode decode compl en privé

using namespace std;


/*
On encode : 
-A/a en 00 (=0) : 0x(2^0) + 0x(2^1) = 0 + 0 = 0 
-C/c en 01 (=1) : 1x(2^0) + 0x(2^1) = 1 + 0 = 1 
-G/g en 10 (=2) : 0x(2^0) + 1x(2^1) = 0 + 2 = 2 
-T/t en 11 (=3) : 1x(2^0) + 1x(2^1) = 1 + 2 = 3  
On sait que : 
-Purine A/G (bit de poids faible = 0)
-Pyrimidine C/T (bit de poids faible = 1)
*/

inline unsigned char Encode(const char nuc) { // unsigned char => renvoie 0123, char => ACGT
  return ((nuc == 'A') || (nuc == 'a')
	  ? 0
	  : ((nuc == 'C') || (nuc == 'c')
	     ? 1
	     : ((nuc == 'G') || (nuc == 'g')
		? 2
		: 3)));
}

inline char Decode(unsigned char nuc) {
  return (nuc == 0 ? 'A' : (nuc == 1 ? 'C' : (nuc == 2 ? 'G' : 'T')));
} //condition ? result_if_true : result_if_false

inline unsigned char Compl(unsigned char nuc) {
  return (~(nuc) & 3);
}

/*
A = 	00000000
~ A=	11111111
 3 =	00000011
~A&3=	00000011 => T
& : on multiplie le compl de A avec 3

C = 	00000001
~ C=	11111110
3	00000011
~C&3 = 	00000010 => G
*/

inline unsigned char IsPyrimidine(unsigned char nuc) {
  return ((nuc) & 1);
}
/*
 A=	00000000
 1 =	00000001
A&1=	00000000 = 0  : veut dire faux


C=	00000001
1=	00000001
C&1=	00000001 = 1 : veut dire vrai
*/

inline unsigned char IsPurine(unsigned char nuc) {
  return !IsPyrimidine(nuc);
}

size_t getOctet(size_t pos) {
  return ((pos + 1) / 4) + (((pos + 1) % 4) != 0) - 1; //-1 car premier octet est en 0
}

size_t getPlaceInOctet(size_t pos) {
  return (pos % 4);
}

int main(int argc, char** argv) {

  char const *seq = NULL;
  if (argc < 2) {
    seq = "ACGTGCGATGCAGTCAGCATCAGCAGCTAGCAGCATACGC";
  } else {
    seq = argv[1];
  }

  size_t n = strlen(seq);
  size_t l = (n > 0 ? getOctet(n - 1) : 0);
  unsigned char * enc_seq = new unsigned char [l];
  for (size_t i = 0; i < l; i++) {
    enc_seq[i] = 0;
  }

  cout << "seq=" << seq << endl;
  for (size_t i = 0; i < n; i++) {
    unsigned char c = Encode(seq[i]);
    enc_seq[getOctet(i)] |= c<<(6-(getPlaceInOctet(i)<<1));
#ifdef DEBUG
    unsigned char cc = Compl(c);
    cout << seq[i] << ":" << (int) c
	 << " (" << Decode(c)
	 << ") ["
	 << (IsPyrimidine(c) ? "Pyrimidine" : "Purine")
	 << "]" << endl;
    cout << "compl(" << seq[i] << "):" << (int) cc
	 << " (" << Decode(cc)
	 << ") ["
	 << (IsPurine(cc) ? "Purine" : "Pyrimidine")
	 << "]" << endl;
    cout << "L'acide nuc. à la position " << i << " dans "
	 << seq << " (" << seq[i] << ") doit être stocké dans l'octet "
	 << getOctet(i) << " à la place "
	 << getPlaceInOctet(i) << endl;
    cout << "enc_seq[" << getOctet(i) << "] = " << bitset<8>(enc_seq[getOctet(i)]) << endl;
#endif
  }

  cout << "Fin de l'encodage" << endl;

  cout << "Décodage de la séquence seq" << endl;
  for (size_t i = 0; i < n; i++) {
    unsigned char c = (enc_seq[getOctet(i)] >> (6-(getPlaceInOctet(i)<<1))) & 3;
    cout << Decode(c);
  }
  cout << endl;
  cout << seq << " (pour rappel)" << endl;
  delete [] enc_seq;
  return 0;
}
