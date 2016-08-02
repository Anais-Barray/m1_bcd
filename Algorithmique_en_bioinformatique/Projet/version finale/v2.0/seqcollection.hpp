#ifndef SEQCOL_H
#define SEQCOL_H

#include <string>
#include <vector>

typedef struct seq{
	std::string header;
	unsigned int length;
	unsigned int position;
} seqStruct;

class SeqCollection{
	private:
		std::string filepath;
		std::vector<seqStruct> sequences;

	public:
		SeqCollection(std::string p_filepath);

		void addSequence(std::string const& header, const unsigned int& start, const unsigned int& length);

		bool getSequence(std::string const& header, seqStruct& sequence) const;

		std::vector<seqStruct> getSequences() const;

		std::string getFilePath() const;
};

#endif
