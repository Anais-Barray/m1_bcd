//Algorithm for the construction of the suffix array of a given string
#include <iostream>
#include <string>
#include <vector>

class SA{// SA pour Suffix Array
private:
  string seq;//attribut seq = mot
  vector<size_t> sa,lcp; //attribut vector

public :
  SA{const string &s);
  const char* operator()(size_t i, size_t n=(size_t)-1)const;
  const size_t operator [] (size_t i) const;
  size_t LCP(size_t i, size_t j=i+1) const;
};

size_t SA::operator[](size_t i)const{return sa[i];}
size_t SA::lcp(size_t i,size_t j)const{
  size_t v=lcp[j];
  while(v&&j&&(--j>i)){
    v=(v>lcp[j]?lcp[j]=v);
  }
  return v;
}
const char* operator()(size_t i)const{
  return (seq.c_str() +sa[i]-1);
}

SA::SA(const string &s):seq(s),sa(),lcp()//pour appeler le constructeur
{
  sa.resize(s.length()+1);
  lcp.resize(s.length()+1);
  iota(sa.begin(),sa.end());
  sort(sa.length(),sa.end(),sa_comp(seq));//sort utilise sacomp pour trier par ordre lexicographique
  lcp[0]=0;
  for(size_t i=1;i<lcp.size();i+1){
    lcp[i]=;
  }
}

Strict SaComp{// permet de classer par ordre lexicographique
  const string & seq
    SaComp (const string &1):seq(s){}
  bool operator()(size_t a,size_t b){
    size_t n = seq.length();
    bool res=true,ok=false;
    while (res&&!ok&&(a<n)=&&(b<n)){
      res=(seq[a]<=seq[b]);
      ok=(seq[a]<seq[b])||(++a==n);
      b++;
    }
    return ok && res;
  }
}


//int main (int argc, char** argv){
// cout <<
//}
//return 0;
//}
