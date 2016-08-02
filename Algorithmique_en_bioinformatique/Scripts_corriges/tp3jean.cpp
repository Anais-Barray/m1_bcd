#include <iostream>
#include <fstream>
#include <libgen.h>
#define BUFSIZE 1024

using namespace std;

int main (int argc, char** argv){
  if (argc<2){
    cerr << " usage : " << basename(argv[0]) << " <fich1>...<fichn>" << endl;
  }
  size_t nbseq = 0;
  for (int i=1; i<argc; i++){
    ifstream fich (argv[i]);
    bool debligne = true, litentete =false;
    size_t nbnuc = 0, numline = 0, numcol = 0;
    char buffer [BUFSIZE];
    while (fich) {
      fich.read (buffer, BUFSIZE);
      for (int x=0; x<fich.gcount(); x++){
	if ((buffer[x] == ' ') || (buffer[x] == '\r')) {
	  numcol++;
	} else {
	  if (buffer[x] == '\n'){
	    debligne = true;
	    numline++;
	    numcol = 0;
	  } else {
	    numcol++;
	    if (debligne){
	      if (litentete) {
		litentete = false;
		if (nbseq) {
		  cout << "nb nucléotides dans la sequence " << nbseq << " : " << nbnuc << endl;
		}
		nbseq++;
		nbnuc = 0;
	      }
	      if ((buffer[x] == 'a') || (buffer[x] == 'A')
		  || (buffer[x] == 'c') || (buffer[x] == 'C')
		  || (buffer[x] == 'g') || (buffer[x] == 'G')
		  || (buffer[x] == 't') || (buffer[x] == 'T')
		  || (buffer[x] == 'n') || (buffer[x] == 'N')){
		nbnuc ++;
	      } else {
		if ((buffer[x] == '>') || (buffer[x] == ';')){
		  litentete = true;
		} else {
		  cerr << "Warning: Don't know what to do with " << buffer[x]
		       << " (file '" << argv[i]
		       << "' at line " << numline
		       << ", column " << numcol
		       << ")" << endl;
		}
	      }
	    } else {
	      if (!litentete) {
		if ((buffer[x] == 'a') || (buffer[x] == 'A')
		    || (buffer[x] == 'c') || (buffer[x] == 'C')
		    || (buffer[x] == 'g') || (buffer[x] == 'G')
		    || (buffer[x] == 't') || (buffer[x] == 'T')
		    || (buffer[x] == 'n') || (buffer[x] == 'N')){
		  nbnuc ++;
		} else {
		  cerr << "Warning: Don't know what to do with " << buffer[x]
		       << " (file '" << argv[i]
		       << "' at line " << numline
		       << ", column " << numcol
		       << ")" << endl;
		}
	      }
	    }
	    debligne = false;
	  }
	}
      }
    }
    if (nbseq) {
      cout << "nb nucléotides dans la sequence " << nbseq << " : " << nbnuc << endl;
    }
    fich.close();
  }
  cout << "nb seq : " << nbseq <</* " nb num : " << nbnuc <<*/ endl;
  return 0;
}





	/*
explications :
soit x est un \n, soit c'set autre chose.
si autre chose : soit début de ligne, soit en cours
si milieu de ligne : soit on est dans l'entete, et on reste dans l'entete
soit on était dans une seq et on reste dans la seq (verification que l'on a a, c, g ou t)
sinon, début de ligne : on était dans l'entete : on débute une nouvelle seq.
sinon, on était dans une nouvelle seq : 
soit buffer[x] est > et je termine ma seq
soit buffer[x] est un nucléotide, et on continue la sequence




prendre en compte les erreurs (forma fichier, mauvaise configuration interne du texte,...)
affichage sur le canal normal (cout) ou canal d'erreurs (cerr)
choisir entre : avertissement/stop du prg/continuer quand même
compteur pour donner le nombre de la ligne (incrémenté a chaque \n) pour donner la ligne en cas d'erreurs
	 */
