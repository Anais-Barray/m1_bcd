#include "fastaSeq.h"
using namespace std;

FastaSeq::FastaSeq():description(""),texte(""){}

FastaSeq::FastaSeq(string description, string texte){}

string FastaSeq::GetDescription() const{
  return description;
}

string FastaSeq::GetSequence() const{
  return texte;
}
/*
size_t length() const{
  
}

float GetGCcontent() const{
  
}

string Complement() const{
  
}

string Reverse() const{
  
}

string SousSequence(size_t debut, size_t fin) const{

}

size_t GetPosition(string sequence) const{

}
*/
void FastaSeq::SetDescription(string description){
  this->description=description;
}

void FastaSeq::SetSequence(string sequence){
  this->texte=sequence;
}
