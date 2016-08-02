#include <iostream>
#include <string>
using namespace std;

int main (int argc, char ** argv){
  string fich;
  int nb;
  cout << "Quel fichier voulez vous lire?";
  cin >> fich;
  cout << "Vous avez saisi le nom : " << fich << endl;
  cout << "Combien de ligne voulez vous lire ? ";
  cin >> nb;
  cout << "Vous avez saisi : " << nb << endl;

  return 0;
}
