#include "testA.h"
#include "testB.h"

using namespace std;

void affiche(const A &a) {
//passe par reference avec &, et on le modifie pasavec const
  a.m1();
  a.m2();// pour B, affiche A meme si redefinie dans B, car considère que c'est un A
  a.m3();
  a.m4();// pour B, comme virtual, va affiche la methode fille
  cout << endl;

}
int main (int argc, char** argv){
  
  cout << "Construction d'une instance de A" << endl;
  A a;
  cout << "Construction d'une instance de B" 
<< endl;
  B b;
  cout << "Construction d'une instance de C" << endl;
  C c;
  cout << "Méthodes de la classe A" << endl;
  affiche (a);

  cout << "Méthodes de la classe B" << endl;
  affiche(b);

  cout << "Méthodes de la classe C" << endl;
  affiche(c);

  return 0;
}
