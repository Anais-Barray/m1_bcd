#include <string>

class FastaSeq{
 private:
  std::string description, texte;
 public :
  FastaSeq();
  FastaSeq(std::string description, std::string texte);

  std::string GetDescription() const;
  std::string GetSequence() const;
  size_t length() const;
  float GetGCcontent() const;
  std::string Complement() const;
  std::string Reverse() const;
  std::string SousSequence(size_t debut, size_t fin) const;
  size_t GetPosition(std::string sequence) const;
  
  void SetDescription(std::string description);
  void SetSequence(std::string sequence);
  std::string Append(std::string sequence2);

};
