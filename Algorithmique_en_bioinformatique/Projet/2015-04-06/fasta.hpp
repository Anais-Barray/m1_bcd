#ifndef FASTA_CLASS_H
#define FASTA_CLASS_H

#include <string>
#include <vector>

class Fasta{
	private:
		std::string header;
		std::vector<unsigned char> sequence;
		unsigned int seqSize;

		inline unsigned char encode(unsigned const char& nuc) const;
		unsigned char encodeBloc(std::string const& bloc) const;
		std::vector<unsigned char> encodeSequence(const std::string& sequence);

		unsigned char decode(unsigned char const& nuc) const;
		std::string decodeBloc(unsigned char bloc) const;
		std::string decodeSequence() const;

	public:
		Fasta(std::string header, std::string sequence);

		std::string getHeader() const;
		std::string getSequence() const;
};

#endif
