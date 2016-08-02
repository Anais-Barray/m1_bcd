#ifndef __B_H__
#define __B_H__

#include <iostream>
#include "A.h"

class B : public A {
 public:
  B();
  void m2(std::ostream &os = std::cout) const;
  virtual void m4(std::ostream &os = std::cout) const;
};

#endif
