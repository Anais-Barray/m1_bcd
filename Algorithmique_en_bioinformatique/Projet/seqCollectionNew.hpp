#ifndef SEQCOL_H
#define SEQCOL_H

#include <string>
#include <vector>

class SeqCollection{
	private:
		std::string filepath;
		struct fastX;
		
	public:
		SeqCollection(std::string p_filepath):filepath(p_filepath){}

		void addSequence(std::string const header, const unsigned int start, const unsigned int length){
			sequenceMap[header] = std::make_pair(start, length);
		}

		std::pair<const unsigned int, const unsigned int> getPair(std::string const& header){
			return sequenceMap[header];
		}
};

#endif
