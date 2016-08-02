#ifndef __TESTB_H__
#define __TESTB_H__

#include <iostream>
#include "testA.h"

class B : public A {
 public:
  B();
  void m2() const;
  virtual void m4() const;
};

#endif
