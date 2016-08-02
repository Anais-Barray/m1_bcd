#include "B.h"

using namespace std;
B::B() {
  cout << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;
}

void B::m2(ostream &os) const {
  os << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;  
}

void B::m4(ostream &os) const {
  os << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;  
}
