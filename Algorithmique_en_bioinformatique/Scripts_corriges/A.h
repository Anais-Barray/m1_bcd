#ifndef __A_H__
#define __A_H__

#include <iostream>

class A {
 public:
  A();
  void m1(std::ostream &os = std::cout) const;
  void m2(std::ostream &os = std::cout) const;
  virtual void m3(std::ostream &os = std::cout) const;
  virtual void m4(std::ostream &os = std::cout) const = 0;
};

std::ostream &operator<<(std::ostream &, const A &a);

#endif
