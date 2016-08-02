#include <string>
#include <vector>

class FastaSeq{
 private:
 std::string header;
 std::vector<unsigned char> sequence;
 std::int longueur;
 
 public:
  FastaSeq();
  FastaSeq(std::string h, std::string s, std::int l);
  std:: string getHeader() const;
  size_t getOctet(size_t pos);
  size_t getPlaceInOctet(size_t pos);
  string getSequence() const;
  void setHeader(std::string header);
  //void setSequence(string sequence);
  
};

