#include "fasta.hpp"

#include <string>
#include <vector>

using namespace std;

inline unsigned char Fasta::encode(unsigned char const& nuc) const{
	return ((nuc == 'A') || (nuc == 'a')
	? 0
	: ((nuc == 'C') || (nuc == 'c')
		? 1
		: ((nuc == 'G') || (nuc == 'g')
			? 2
			: 3)));
}

unsigned char Fasta::encodeBloc(const string& bloc) const{
	unsigned char value(0);
	for(unsigned int i(0); i < bloc.length(); ++i){
		value = value << 2;
		value += encode(bloc[i]);
	}
	value = value << (2 * (4-bloc.length()));
	return value;
}

vector<unsigned char> Fasta::encodeSequence(const string& sequence){
	vector<unsigned char> seq;
	unsigned int i(0);
	for(; i < sequence.length(); i += 4)
		seq.push_back(encodeBloc(sequence.substr(i, 4)));
	return seq;
}

inline unsigned char Fasta::decode(unsigned char const& nuc) const{
  return (nuc == 0 ? 'A' : (nuc == 1 ? 'C' : (nuc == 2 ? 'G' : 'T')));
}

string Fasta::decodeBloc(unsigned char bloc) const{
	string value(""), tmp("");
	for(unsigned int i(0); i < 4;++i){
		tmp = decode(bloc & 3);
		value = tmp + value;
		bloc = bloc >> 2;
	}
	return value;
}

string Fasta::decodeSequence() const{
	string seq("");
	for(unsigned char c: sequence)
		seq += decodeBloc(c);
	return seq.substr(0, seqSize);
}

Fasta::Fasta(string p_header, string p_sequence) : header(p_header){
	sequence = encodeSequence(p_sequence);
	seqSize = p_sequence.length();
}

string Fasta::getHeader() const{
	return header;
}
string Fasta::getSequence() const{
	return decodeSequence();
}
string Fasta::getComplement() const{
	string seq;
	for(unsigned char c: sequence)
		seq += decodeBloc(c ^ 255); //^: xor, ou exclusif
	return seq.substr(0, seqSize);
}
string Fasta::getReverse() const{
	string seq(getSequence());
	return string(seq.rbegin(), seq.rend());
}
string Fasta::getReverseComplement() const{
	string seq;
	for(unsigned char c: sequence)
		seq += decodeBloc(c ^ 255); //complement
	seq = seq.substr(0, seqSize);
	return string(seq.rbegin(), seq.rend()); //reverse
}
string Fasta::getSubSequence(unsigned int start, unsigned int end) const{
	return getSequence().substr(start, end);
}
float Fasta::getGCContent() const{
	float cptGC(0);
    for (unsigned char c : getSequence())
        if (c == 'G' || c == 'C')
            ++cptGC;
	return (cptGC/seqSize);
}
