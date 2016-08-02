#include <iostream>
#include <string>
#include <vector>

using namespace std;

unsigned char encode(const char& nuc) { // unsigned char => renvoie 0123, char => ACGT
    return ((nuc == 'A') || (nuc == 'a')
    ? 0
    : ((nuc == 'C') || (nuc == 'c')
        ? 1
        : ((nuc == 'G') || (nuc == 'g')
            ? 2
            : 3)));
}

unsigned char encodeBloc(const string& bloc){
    unsigned char value(0);
    for(unsigned int i(0); i < bloc.length(); ++i){
        value = value << 2;
        value += encode(bloc[i]);
    }
    value = value << (2 * (4-bloc.length()));
    return value;
}

vector<unsigned char> encodeSequence(const string& sequence){
    vector<unsigned char> seq;
    unsigned int i(0);//divise la seqc en 4
    for(; i < sequence.length() ; i += 4)
        seq.push_back(encodeBloc(sequence.substr(i, 4))); // substr(index debut, longueur)
    return seq;
}

unsigned char decode(unsigned char nuc) {
  return (nuc == 0 ? 'A' : (nuc == 1 ? 'C' : (nuc == 2 ? 'G' : 'T')));
}

string decodeBloc(unsigned char bloc){
    string value(""), tmp("");
    for(unsigned int i(0); i < 4;++i){
        tmp = decode(bloc & 3);
        value = tmp + value;
        bloc = bloc >> 2;
    }
    return value;
}

string decodeSequence(vector<unsigned char> const& sequence, unsigned int size){
    string seq("");
    for(unsigned char c: sequence)
        seq += decodeBloc(c);
    return seq.substr(0, size); // reduit a la taille de la seq, au cas ou  %4!=0
}



int main(){
    string sequence("GTTACTC");
    vector<unsigned char> seq(encodeSequence(sequence));
	cout << decodeSequence(seq,7);
    return 0;
}

