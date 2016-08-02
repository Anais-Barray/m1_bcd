#include "A.h"
#include "B.h"
#include "C.h"

using namespace std;

void affiche(const A &a) {
  cout << a << endl;
}

int main(int argc, char** argv) {

  cout << "Construction d'une instance de B" << endl;
  B b;
  cout << "Construction d'une instance de C" << endl;
  C c;

  cout << "Méthodes de la classe B" << endl;
  affiche(b);

  cout << "Méthodes de la classe C" << endl;
  affiche(c);

  b.m2();

  b.m2(cout);

  return 0;
}

