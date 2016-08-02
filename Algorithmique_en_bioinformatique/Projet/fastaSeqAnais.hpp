#ifndef FASTA_CLASS_H
#define FASTA_CLASS_H

#include <string>
#include <vector>

class FastaSeq{
 private:
	std::string header;
	std::vector<unsigned char> sequence;
	unsigned int length;
  unsigned char encode(const char& nuc) const;
  unsigned char encodeBloc(const std::string& bloc) const;
  std::vector<unsigned char> encodeSequence(const std::string& sequence);
  unsigned char decode(unsigned char nuc) const;
	std::string decodeBloc(unsigned char bloc) const;
  std::string decodeSequence() const;
  
 public:
   FastaSeq();
  FastaSeq(std::string h, std::string s);
  std::string getHeader() const;
  std::string getSequence() const;
 // int getLength() const;
 
};

#endif
