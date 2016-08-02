#!/usr/bin/env python
import sys, os, re, cgi

param = {}

for clef in cgi.FieldStorage().keys() : 
	param[clef] = cgi.FieldStorage()[clef].value

for cle in param.keys():
	Print clef, ":", param[clef]
