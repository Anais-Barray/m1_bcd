#include <iostream>
#include <fstream>
#include <string>
#include <libgen.h>
#include "seqcollection.hpp"
#include "fasta.hpp"

using namespace std;

int main(int argc, char * argv[]){
	string line, inheader, fastaseq;
	seqStruct requestedSeq;

//test nombre argument passé en paramètre
	if(argc < 2){
		cerr << "usage:" << basename(argv[0]) << " <fich1.fas>...<fichn.fas>" << endl;
		return EXIT_FAILURE;
	}
	
//test type de fichier
    ifstream file(basename(argv[1]), ios::in); //on ouvre le fichier file en lecture
    string firstLine;
    if(file){
		getline(file,firstLine); //fonction getline qui lit la premiere ligne du fichier file
		if((firstLine[0] == '>') || (firstLine[0] == ';')){cout << "Ce fichier est un fasta." << endl << endl; } 
		else {
            if ((firstLine[0] == '@')){cout << "Ce fichier est un fastq." << endl << endl;}
            else {
				cout << "Votre fichier n'est ni un fasta ni un fastq au format correct." << endl << endl;
				return EXIT_FAILURE;
			}
        }
	}
  
//parcours du fichier
	for(int i(1); i <argc ;++i){ //parcours tous les fichier.fas
		ifstream fich(argv[i]);
		SeqCollection SeqColl(argv[i]);
		unsigned int numline(0), pos(0);
		string sequence, head;
		
		while(getline(fich, line)){
			if(line[0] == '>' || line[0] == ';'){ //nouvelle entete
				if(sequence != ""){
					if(head.back() == '\n')
						head = head.substr(0, head.size()-1);
					SeqColl.addSequence(head, pos, sequence.size());
					head = "";
					sequence = "";
				}
				head += line;
			} else { //séquence
				if(sequence == "")
					pos = numline;
				if(line.back() == '\n')
					line = line.substr(0, line.size()-1);
				sequence += line;
			}
			++numline;
		}	
		SeqColl.addSequence(head, pos, sequence.size()); //dernière sequence du fichier
		
		for(auto var: SeqColl.getSequences()){
			cout << var.header << endl;
			cout << "debut : " << var.position << " longueur : " << var.length << endl;
			cout << endl;
		}
		cout << "Quelle séquence voulez vous extraire ? (Header?)" << endl;
		getline(cin, inheader); // equivalent de cin, stock dans inheader, pas de probleme avec des espaces

		numline = 0;
		if(SeqColl.getSequence(inheader, requestedSeq)){ //inheader : ce qu'on cherche. requestedseq est une struct vide. S'il trouve le header, remplie la struc, sinon laisse vide.
			ifstream fich(SeqColl.getFilePath());
			while(getline(fich, line)){
				if((line[0] == '>' || line[0] == ';') && fastaseq != ""){
					break; //sort du while
				} else if(numline == requestedSeq.position || fastaseq != ""){ //si on trouve la séquence
					fastaseq += line;
				}
				++numline;
			}
			Fasta fasta(inheader, fastaseq);
			
			cout << "Sequence : " << endl;
			cout << fasta.getSequence() << endl << endl;
			//cout << "Complement : " << endl;
			//cout << fasta.getComplement() << endl << endl;
			//cout << "Reverse : " << endl;
			//cout << fasta.getReverse() << endl << endl;
			cout << "Reverse Complement : " << endl;
			cout << fasta.getReverseComplement() << endl << endl;
			cout << "GC content : " << endl;
			cout << fasta.getGCContent() << endl << endl;
			cout << "Sous séquence de la position 15 à 36 : " << endl;
			cout << fasta.getSubSequence(15, 36) << endl << endl;
			
		} else {
			cout << "Impossible de trouver la séquence " << inheader << " dans ce fichier" << endl;
		}
	}

	return EXIT_SUCCESS;
}
