#include "testB.h"
using namespace std;

B::B(){
  cout << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;
}


void B::m2() const{
  cout << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;
}


void B::m4() const{
  cout << __FILE__ << ":" << __FUNCTION__ << ":" << __LINE__ << endl;
}
