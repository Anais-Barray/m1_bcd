#include "seqcollection.hpp"

void SeqCollection::addSequence(std::string const& header, const unsigned int& start, const unsigned int& length){
	sequences.push_back(seqStruct{header, length, start});
};

bool SeqCollection::getSequence(std::string const& header, seqStruct& sequence) const{
	for(auto var : sequences){
		if(var.header == header){
			sequence = var;
			return true;
		}
	}
	return false;
};

std::vector<seqStruct> SeqCollection::getSequences() const{
	return sequences;
}
