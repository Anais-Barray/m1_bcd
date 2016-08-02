#include <iostream>
#include "fastaSeq.h"
using namespace std;

int main (int argc, char ** argv){
  FastaSeq seq;
  cout<<seq.GetDescription();
  seq.SetDescription("rien");
 
  return 0;
}
