#include "C.h"

using namespace std;
C::C() {
  cout << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;
}

void C::m2(ostream &os) const {
  os << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;  
}

void C::m4(ostream &os) const {
  os << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;  
}
