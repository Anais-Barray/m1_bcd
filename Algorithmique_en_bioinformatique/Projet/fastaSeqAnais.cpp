#include "fastaSeqAnais.hpp"
#include <iostream>
#include <string>
#include <vector>

using namespace std;


inline unsigned char FastaSeq::encode(char const& nuc) const{ // unsigned char => renvoie 0123, char => ACGT
    return ((nuc == 'A') || (nuc == 'a')
    ? 0
    : ((nuc == 'C') || (nuc == 'c')
        ? 1
        : ((nuc == 'G') || (nuc == 'g')
            ? 2
            : 3)));
}

unsigned char FastaSeq::encodeBloc(const string& bloc) const{
    unsigned char value(0);
    for(unsigned int i(0); i < bloc.length(); ++i){
        value = value << 2;
        value += encode(bloc[i]);
    }
    value = value << (2 * (4-bloc.length()));
    return value;
}

vector<unsigned char> FastaSeq::encodeSequence(const string& sequence){
    vector<unsigned char> seq;
    unsigned int i(0);//divise la seqc en 4
    for(; i < sequence.length() ; i += 4)
        seq.push_back(encodeBloc(sequence.substr(i, 4))); // substr(index debut, longueur)
    return seq;
}

unsigned char FastaSeq::decode(unsigned char nuc) const{
  return (nuc == 0 ? 'A' : (nuc == 1 ? 'C' : (nuc == 2 ? 'G' : 'T')));
}

string FastaSeq::decodeBloc(unsigned char bloc) const{
    string value(""), tmp("");
    for(unsigned int i(0); i < 4;++i){
        tmp = decode(bloc & 3);
        value = tmp + value;
        bloc = bloc >> 2;
    }
    return value;
}

string FastaSeq::decodeSequence() const{
    string seq("");
    for(unsigned char c: sequence)
        seq += decodeBloc(c);
    return seq.substr(0, length);
}



//FastaSeq::FastaSeq():header(""), sequence('0') {}

FastaSeq::FastaSeq(string h, string s):
  header(h),
  sequence(encodeSequence(s)) {
  cout << "objet cree" << endl;
  }

string FastaSeq::getHeader() const {
  return header;
}

string FastaSeq::getSequence() const {
  return decodeSequence();
}



int main(){
    FastaSeq f1("seq1","CTTNAGC") ;
	cout << "header : " << f1.getHeader() << ", sequence : " << f1.getSequence() << endl;
    return 0;
}
