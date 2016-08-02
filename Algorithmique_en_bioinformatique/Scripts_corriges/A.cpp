#include "A.h"

using namespace std;
A::A() {
  cout << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;
}

void  A::m1(ostream &os) const {
  os << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;  
}

void  A::m2(ostream &os) const {
  os << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;  
}

void  A::m3(ostream &os) const {
  os << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;  
}

void  A::m4(ostream &os) const {
  os << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;  
}

ostream &operator<<(ostream &os, const A &a) {
  a.m1(os);
  a.m2(os);
  a.m3(os);
  a.m4(os);
  return os;
}

