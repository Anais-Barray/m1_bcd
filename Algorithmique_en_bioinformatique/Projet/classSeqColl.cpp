#include "ClassSeqColl.h"
#include <fstream> //ifstream
#include <iostream> //cout cin cerr


using namespace std;


SeqCollection::SeqCollection():fileName(""),seqNumber(0){}
SeqCollection::SeqCollection(string fileName, size_t seqNumber):
  fileName(fileName), seqNumber(seqNumber){}//peut etre utilisé apres la premiere lecture

//this->tabSeqPosition=initialiser avec seqNumber
//this->tabSeqLenght=initialiser apres la premiere ou deuxieme lecture
  
string SeqCollection::GetFileName()const{
    return fileName;
  }
size_t SeqCollection::GetNumber()const{
    return seqNumber;
  }


int main (int argc, char**argv){
 SeqCollection sc ("fich1", 5);
 cout << sc.GetNumber() << endl;

 return 0;
}
