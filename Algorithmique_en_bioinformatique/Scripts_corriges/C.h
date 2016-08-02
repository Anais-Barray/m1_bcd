#ifndef __C_H__
#define __C_H__

#include <iostream>
#include "A.h"

class C : public A {
 public:
  C();
  void m2(std::ostream &os = std::cout) const;
  virtual void m4(std::ostream &os = std::cout) const;
};

#endif
