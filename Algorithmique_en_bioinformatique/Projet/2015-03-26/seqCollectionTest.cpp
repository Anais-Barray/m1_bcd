#include <string>
#include <fstream> //ifstream
#include <iostream> //cout cin cerr

using namespace std;

int main (int argc, char**argv){

    ifstream file("FastaSeqErreur.fas", ios::in); //on ouvre le fichier file en lecture
    string firstLine;
    if(file){
    getline(file,firstLine); //fonction getline qui lit la premiere ligne du fichier file
    if((firstLine[0] == '>') || (firstLine[0] == ';')){cout << "Ce fichier est un fasta." << endl;
      } else {
            if ((firstLine[0] == '@')){cout << "Ce fichier est un fastq." << endl;}
            else {cout << "Votre fichier n'est ni un fasta ni un fastq au format correct." << endl;}
            }
   }

return 0;
}
