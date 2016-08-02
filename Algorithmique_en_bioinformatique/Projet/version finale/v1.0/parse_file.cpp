#include <iostream>
#include <fstream>
#include <string>
#include <libgen.h>
#include "seqcollection.hpp"



using namespace std;

int main(int argc, char * argv[]){
	if(argc < 2){
		cerr << "usage:" << basename(argv[0]) << " <fich1.fas>...<fichn.fas>" << endl;
		return EXIT_FAILURE;
	}

	string line;
	for(int i(1); i <argc ;++i){ //parcours tous les fichier.fas
		ifstream fich(argv[i]);
		SeqCollection SeqColl(argv[i]);
		unsigned int numline(0), pos(0);
		string sequence, head;
		while(getline(fich, line)){
			if(line[0] == '>' || line[0] == ';'){
				if(sequence != ""){
					SeqColl.addSequence(head, pos, sequence.size());
					head = "";
					sequence = "";
				}
				head += line;
			} else {
				if(sequence == "")
					pos = numline;
				if(line.back() == '\n')
					line = line.substr(0, line.size()-1);
				sequence += line;
			}
			++numline;
		}
		SeqColl.addSequence(head, pos, sequence.size());
		for(auto var: SeqColl.getSequences()){
			cout << var.header << endl;
			cout << "debut : " << var.position << " longueur : " << var.length << endl;
			cout << endl;
		}
	}
	return EXIT_SUCCESS;
}
