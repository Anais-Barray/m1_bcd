#include "quotient.h"
#include <iostream>
using namespace std;

Quotient:: Quotient(int num, int den): num(num), den(den){
  if (!den) {
    throw "Le dénominateur d'un quotient ne peux être nul"
      }
}

int Quotient::getNumerateur() const {
  return num;
}

int Quotient::getDenominateur() const {
  return den;
}

void Quotient::setNumerateur(int num) {
  this->num = num;
  simplification();
}

void Quotient::setDenominateur(int den){
  if (!den) {
    throw "Le dénominateur d'un quotient ne peux être nul"
      }
  this->den = den;
  simplification();
}


Quotient &Quotient::operator+=(const Quotient &q){
//renvoi une ref sur l'instance courante, permet de la modifier en aval.
  if (den == q.den){
    num += q.num;
  } else {
    num = num * q.den + den * q.num;
    den *= q.den;
  }
  simplification();
  return *this;
}


Quotient operator+(const Quotient &q) const{
  Quotient res(*this); //construit res par copie de l'instance courante (pointeur)
  if (res.den == q.den) {
    res.num += q.num;
  } else {
    res.den *= q.den;
    res.num *= q.den;
    res.num += den * q.num;
  }
  res.simplification();
  return res;
}


Quotient operator*(const Quotient &q) const{
  Quotient res(*this);
  res.den *= q.den;
  res.num *= q.num;
  res.simplification();
  return res;
}
 
 
ostream &operator<<(ostream &os, const Quotient &q){
  os << q.getNumerateur() << "/" << q.getDenominateur(); 
  return os;
}

Quotient operator-(const Quotient &q1, const Quotient &q2){
  return q1 + (q2 * Quotient(-1));
}

Quotient &operator=(const Quotient &q){
  if (this != &q) {
  num = q.num;
  den = q.den;
  }
  return this*;
}
// permet de faire q1 = q2 = q3 = q4;

void Quotient::simplification(){
  int i = 2;

  while ((i <= num) && (i <= den)){
    if (!(num % i) && !(den % i)) {
      num /= i;
      den /= i;
    } else {
      i++;
    }
  }
}


ostream &operator<<(ostream &os, const Quotient &q){
  os << q.getNumerateur() << "/" << q.getDenominateur(); 
  return os;
}


int main (int argc, char** argv) {
 
  Quotient q1(2, 4), q2(2, 3), q3;

  cerr << "q1 = " << q1 << endl;
  cerr << "q2 = " << q2 << endl;
  cerr << "q3 = " << q3 << endl;

  q3 = q1 + q2;
  cout << q1 << "+" << q2 << "=" << q3 << endl;
  q3 = q1 * q2;
  cout << q1 << "*" << q2 << "=" << q3 << endl;

  try (
  cout << q1 << "*" << q2 << "=" << q3 << endl;
       ) catch (char const *msg) {
      cerr << msg << endl;
    }

    return 0;
}

