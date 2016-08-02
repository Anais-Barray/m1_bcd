#ifndef __QUOTIENT_H__
#define __QUOTIENT_H__

#include <iostream>

class Quotient {
 private:
  int num, den;
  void simplification();
 public:
  Quotient(int num = 0, int den = 1);
  int getNumerateur() const;
  int getDenominateur() const;
  void setNumerateur(int num);
  void setDenominateur(int den);
  Quotient &operator=(const Quotient &q);
  Quotient &operator+=(const Quotient &q);
  Quotient operator+(const Quotient &q) const;
  Quotient operator*(const Quotient &q) const;
};

std::ostream &operator<<(std::ostream &os, const Quotient &q);

Quotient operator-(const Quotient &q1, const Quotient &q2);

#endif


