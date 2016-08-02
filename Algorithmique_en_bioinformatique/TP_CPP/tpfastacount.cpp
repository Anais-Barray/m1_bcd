#include <fstream>
#include <iostream>
#include <libgen.h>
#define BUFFSIZE 1024 // constante fixée à 1024
using namespace std;
int main (int argc, char**argv){
  if (argc<2){
    cerr<<"usage:" <<basename(argv[0]) << " <fich1>...<fichn>" << endl;
    return 1;
  }

  for (int i=1; i<argc;i++){
    ifstream fich(argv[i]);
    bool debligne = true, litentete = false;
    size_t nbseq = 0, nbnuc = 0, numline = 0, numcol = 0;
    char buffer [BUFFSIZE];
    cout << "Analyse fichier " << argv[i] << endl;
    while (fich){
      fich.read (buffer, BUFFSIZE);
      for (int x = 0; x<fich.gcount();x++){
	if (buffer[x]=='\n'){
	  numline++;
	  numcol = 0;
	  debligne = true;
	}else {
	  numcol++;
	  if(debligne){
	    if (litentete){
	      litentete = false;
	      nbseq ++;
	      nbnuc = 0;
	    }
	    if ((buffer[x]== 'a') || (buffer[x]=='A')
		||(buffer[x]== 't') ||( buffer[x]=='T')
		||(buffer[x]== 'g') ||( buffer[x]=='G')
		||(buffer[x]== 'c') ||( buffer[x]=='C')) {
	      nbnuc++;
	    }	else {
	      if ((buffer[x]== '>') || (buffer[x]== ';')){
		if (nbseq){
		  cout << "La sequence " << nbseq << "possede " << nbnuc << " nucleotides" << endl;
		}
		litentete = true;
	      } else {
		cerr <<"Le problème provient de "
		     << numline << "ème ligne "
		     << numcol << "ème colonne"
		     << " du fichier " << argv[i]
		     << ": " << buffer[x] << endl;
	      }
	    }
	    debligne = false;
	  } else{
	    if (!litentete){ 
	      if ((buffer[x]== 'a') || (buffer[x]=='A')
		  ||(buffer[x]== 't') ||( buffer[x]=='T')
		  ||(buffer[x]== 'g') ||( buffer[x]=='G')
		  ||(buffer[x]== 'c') ||( buffer[x]=='C')) {
		nbnuc++;
	      }	else {
		cerr <<"XXLe problème provient de "
		     << numline << "ème ligne "
		     << numcol << "ème colonne"
		     << " du fichier " << argv[i]
		     << ": " << buffer[x] << endl;
	      }
	    }
	  }
	}
      }
    }
    if (nbseq){
      cout << "La sequence " << nbseq << "possede " << nbnuc << " nucleotides" << endl;
    }
  }
  return 0;
}
