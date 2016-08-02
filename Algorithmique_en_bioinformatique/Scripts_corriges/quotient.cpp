#include "quotient.h"

using namespace std;

Quotient::Quotient(int num, int den): num(num), den(den) {
  if (!den) {
    throw "Le dénominateur d'un quotient ne peut être nul (gros naze) !!!";
  }
  simplification();
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

void Quotient::setDenominateur(int den) {
  if (!den) {
    throw "Le dénominateur d'un quotient ne peut être nul (gros naze) !!!";
  }
  this->den = den; 
  simplification();
}

Quotient &Quotient::operator=(const Quotient &q) {
  if (this != &q) {
    num = q.num;
    den = q.den;
    simplification();
  }
  return *this;
}

Quotient Quotient::operator+(const Quotient &q) const {
  Quotient res(*this);
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

Quotient &Quotient::operator+=(const Quotient &q) {
  if (den == q.den) {
    num += q.num;
  } else {
    num = num * q.den + den * q.num;
    den *= q.den;
  }
  simplification();
  return *this;
}

Quotient Quotient::operator*(const Quotient &q) const {
  Quotient res(*this);
  res.den *= q.den;
  res.num *= q.num;
  res.simplification();  
  return res;
}

void Quotient::simplification() {
  int i = 2;

  while ((i <= num) && (i <= den)) {
    if (!(num % i) && !(den % i)) {
      num /= i;
      den /= i;
    } else {
      i++;
    }
  }
}

ostream &operator<<(ostream &os, const Quotient &q) {
  os << q.getNumerateur() << "/" << q.getDenominateur();
  return os;
}

Quotient operator-(const Quotient &q1, const Quotient &q2) {
  return q1 + (q2 * Quotient(-1, 0));
}

int main(int argc, char** argv) {

  Quotient q1(2, 4), q2(120, 180), q3;

  cerr << "q1 = " << q1 << endl;

  cerr << "q2 = " << q2 << endl;

  cerr << "q3 = " << q3 << endl;

  q3 = q1 + q2;
  q1 += q2;

  cout << q1 << "+" << q2 << "=" << q3 << endl;

  q3 = q1 * q2;

  cout << q1 << "*" << q2 << "=" << q3 << endl;

  cout << q1 << "-" << q2 << "=" << (q1 - q2) << endl;


  return 0;
}
