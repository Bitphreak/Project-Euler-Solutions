#!/usr/bin/python

import sys

def total(twoPound, onePound, fiftyP, twentyP, tenP, fiveP, twoP, oneP):
	return twoPound * 200 + onePound * 100 + fiftyP * 50 + twentyP * 20 + tenP * 10 + fiveP * 5 + twoP * 2 + oneP

def ceil(value, denomination):
	return value//denomination + 1

sum = 0

change = 200

for twoPound in range (0, ceil(200, 200)):
	for onePound in range (0, ceil(200 - total(twoPound, 0, 0, 0, 0, 0, 0, 0), 100) ):
		for fiftyP in range (0, ceil(200 - total(twoPound, onePound, 0, 0, 0, 0, 0, 0), 50) ):
			for twentyP in range (0, ceil(200 - total(twoPound, onePound, fiftyP, 0, 0, 0, 0, 0), 20) ):
				for tenP in range (0, ceil(200 - total(twoPound, onePound, fiftyP, twentyP, 0, 0, 0, 0), 10) ):
					for fiveP in range (0, ceil(200 - total(twoPound, onePound, fiftyP, twentyP, tenP, 0, 0, 0), 5) ):
						for twoP in range (0, ceil(200 - total(twoPound, onePound, fiftyP, twentyP, tenP, fiveP, 0, 0), 2) ):
							for oneP in range (0, ceil(200 - total(twoPound, onePound, fiftyP, twentyP, tenP, fiveP, twoP, 0), 1) ):
								if total(twoPound, onePound, fiftyP, twentyP, tenP, fiveP, twoP, oneP) == 200:
									sum += 1

print "%d combinations" % sum
	

