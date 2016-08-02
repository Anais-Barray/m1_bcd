#include "seqCollection.h"
#include <fstream> //ifstream
#include <iostream> //cout cin cerr


using namespace std;


SeqCollection::SeqCollection():fileName(""),tabFastX(NULL){} //constructeur vide
SeqCollection::SeqCollection(string f, vector<fastX> t): //constructeur avec paramètres
  fileName(f), tabFastX(t){}


int SeqCollection::SeqNumber(){//methode pour avoir le nombre de sequences dans un fichier
    return this->tabFastX.size();
}

string SeqCollection::GetFileName()const{ //methode pour avoir le nom du fichier
    return fileName;
  }

void TypeFile (){
    ifstream file(this->fileName, ios::in) //on ouvre le fichier file en lecture
    string firstLine;
    if(file){
    getline(file,firstLine); //fonction getline qui lit la premiere ligne du fichier file
        if((firstLine[0] == '>') || (firstLine[0] == ';')){cout << "Ce fichier est un fasta." << endl;
        } else {
            if ((firstLine[0] == '@')){cout << "Ce fichier est un fastq." << endl;}
            else {cout << "Votre fichier n'est ni un fasta ni un fastq au format correct." << endl;}
            }
}

int main (int argc, char**argv){
  return 0;
}
