#include<string>
#include<vector>

class SeqCollection{
private:
  std::string fileName;
  size_t seqNumber; //constinitialiser à 0
  std::vector <size_t> tabSeqPosition;
  std::vector <size_t> tabSeqLength;
public:
  SeqCollection();
  SeqCollection(std::string fileName, size_t seqNumber);
 // this->tabSeqLength = vector <size> tabSeqLength;
  size_t GetNumber()const;
  std::string GetFileName()const;
}; 
