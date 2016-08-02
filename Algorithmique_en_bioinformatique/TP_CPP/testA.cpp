#include "testA.h"
using namespace std;


A::A(){
  cout << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;
}

void A::m1() const{
  cout << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;
}

void A::m2() const{
  cout << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;
}

void A::m3() const{
  cout << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;
}

void A::m4() const{
  cout << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;
}
