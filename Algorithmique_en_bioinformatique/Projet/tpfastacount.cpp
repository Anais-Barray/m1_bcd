#include <fstream> //ifstream
#include <iostream> //cout cin cerr
#include <libgen.h> // pour les regex (ici basename, qui recup le nom de l'argument)
#define BUFFSIZE 1024 // constante fixée à 1024
using namespace std;
int main (int argc, char**argv){//pointeur vers un tableau de pointeurs vers un tableau de char
  if (argc<2){//si un seul argument : si seulement le script
    cerr<<"usage:" <<basename(argv[0]) << " <fich1.fas>...<fichn.fas>" << endl; //message d'erreur au cas ou il n'y ai pas de fichier specifie a analyser
    return 1; //arrete la compilation
  }

  for (int i=1; i<argc;i++){ //parcours tous les fichier.fas
    ifstream fich(argv[i]);//ouvre en lecture le fichier en argv[i], le stock dans fich (initialisation), position du curseur au debut par defaut
    bool debligne = true, litentete = false;
    size_t nbseq = 0, nbnuc = 0, numline = 0, numcol = 0;
    char buffer [BUFFSIZE];//tableau de char
    cout << "Analyse fichier " << argv[i] << endl;
    while (fich){//tq il y a des char dans le fichier, faire ce qui suit:
      fich.read (buffer, BUFFSIZE); //lis le fichier, le met dans un buffer de taille 1024bytes
//	cout << fich.gcount() << endl ;
      for (int x = 0; x<fich.gcount();x++){//x < 1024 sauf pour le dernier buffer (le reste)
	if (buffer[x]=='\n'){
	  numline++;
	  numcol = 0;
	  debligne = true;
	}else {
	  numcol++;
	  if(debligne){
	    if (litentete){ //to do : tester si entete sur plusieurs lignes
	     	//if ';' a la ligne d'après. Faire boucle while
		litentete = false;
	      nbseq ++;
	      nbnuc = 0;
	    }
	    if ((buffer[x]== 'a') || (buffer[x]=='A')
		||(buffer[x]== 't') ||( buffer[x]=='T')
		||(buffer[x]== 'g') ||( buffer[x]=='G')
		||(buffer[x]== 'c') ||( buffer[x]=='C')) {
	      nbnuc++;
	    }	
		
		else {

	      if ((buffer[x]== '>') || (buffer[x]== ';')){//si nouvelle entete
		if (nbseq){ //on test au cas ou nbseq = 0
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
	  } else{// on est plus en debut de ligne
	    if (!litentete){ //on est pas dans l'entete
	      if ((buffer[x]== 'a') || (buffer[x]=='A')
		  ||(buffer[x]== 't') ||( buffer[x]=='T')
		  ||(buffer[x]== 'g') ||( buffer[x]=='G')
		  ||(buffer[x]== 'c') ||( buffer[x]=='C')) {
		nbnuc++;
	      }	else { //to do : si on trouve un N, changer en un autre nt, et stocker la numligne & numcol dans un autre fichier. 
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
