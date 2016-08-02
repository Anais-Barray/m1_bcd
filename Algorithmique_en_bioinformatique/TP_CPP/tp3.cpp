#include <iostream> //entrées et sorties (cin cout cerr)
#include <fstream> //comporte ifstream et ofstream (manipulation des fichiers sous forme de flot) ifstream : lecture dans un fichier, ofstream : écrire dans un fichier (existe ou non).
#include <libgen.h> // header qui def basename, etc qui permet de découper la partie repertoire de la partie fichier.
using namespace std;

int main(int argc, char ** argv){
  if(argc!=2){
    cerr << "usage : " << basename(argv[0]) << " <Fichier> " << endl;
    return 1;
  } //basename : recup que le nom du fichier

  ifstream fich(argv[1]); char buffer[1024]; //1024 caractères, tableau de char dans lequel on stock ce qu'on lis. Pas d'allocation dynamique mais statique.
  while (!fich.eof()){ //tq on est pas a la fin du fichier (end of file)
    fich.getline(buffer, 1024);
    cout << buffer << endl;
  }
  fich.close();
  return 0;
}
