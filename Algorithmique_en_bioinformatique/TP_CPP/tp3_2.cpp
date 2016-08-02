#include <iostream>
#include <fstream>
#include <libgen.h>
#define BUFSIZE 1024 //le def au début fait que si on le change, ca le change dans tous le prog
using namespace std;

int main (int argc, char ** argv){
  if (argc<2){
    cerr << "usage : " << basename(argv[0]) << " <fich1> ... <fich n> " << endl;
    return 1;
  }

  for (int i = 1 ; i < argc ; i++){
    ifstream fich (argv[i]);
    bool debligne=true; litEntete=false;
    size_t nbSeq = 0; nbNuc = 0;
    char buffer[BUFSIZE];
    while (fich){
      fich.read(buffer, BUFSIZE);//lis les 1024 premiers octets et les met dans le buffer
      for(size_t x=0 ; x < fich.gcount() ; x++){
	if (buffer[x] == '\n'){
	  debligne=true;
	} else {
	  if(debligne){
	    if(litEntete){
	      litEntete=false;
	      nbSeq++;
	      nbNuc=0;
	    } else {
	      if (buffer[x] == '>' || buffer[x] == ';'){
		litEntete=true;
		debligne=false;
	      }
	      if ((buffer[x] == a || buffer[x] == A) || 
		(buffer[x] == c || buffer[x] == C) ||
		(buffer[x] == g || buffer[x] == G) ||
		(buffer[x] == t || buffer[x] == T)) 
	      {
	      nbNuc++;
	      debligne=false;
	      }
 	      else {
		cerr << "symbole non reconnu" << endl;
		return 1;
	    }
	  }
	}
      }
	fich.close();
	return 0;
    }
    


