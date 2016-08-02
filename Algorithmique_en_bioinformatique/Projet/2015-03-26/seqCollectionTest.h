#include<string>
#include<vector>

class SeqCollectionTest{
private:
  std::string fileName;
  std::vector <fastX> tabFastX;

public:
  SeqCollectionTest(); //constructeur vide
  SeqCollectionTest(std::string f, std::vector <fastX> t); //constructeur avec parametres
  int SeqNumber (); //méthode pour avoir le nombre de sequences dans un fichier
  std::string GetFileName()const; // pour recuperer le nom du fichier
  //std::vector<fastX> GetTabFastX () const;
  std::string TypeFile ();//methode type de fichier
};
