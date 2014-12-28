#!/usr/bin/python

import sys

def isprime(n):
    '''check if integer n is a prime'''
    # make sure n is a positive integer
    n = abs(int(n))
    # 0 and 1 are not primes
    if n < 2:
        return False
    # 2 is the only even prime number
    if n == 2: 
        return True    
    # all other even numbers are not primes
    if not n & 1: 
        return False
    # range starts with 3 and only needs to go up the squareroot of n
    # for all odd numbers
    for x in range(3, int(n**0.5)+1, 2):
        if n % x == 0:
            return False
    return True

def recurring(n):
	remainders = {}
	m = 10
	c = 0
	# sys.stdout.write("1/%d == ." % (n))

	while m != 0:
		c += 1
		remainder = m % n
		dividend = m//n
		# sys.stdout.write("%d" % (dividend))
		if remainder in remainders:
			return c - remainders[remainder]
		else:
			m = remainder * 10
			remainders[remainder] = c
	return 0


maxNumerator = 3;
maxCycle = 1;

for d in range(2,1001):
	if isprime(d):
		r = recurring(d)
		#print ''
		print "cycle for 1/%d => %d" % (d, r)
		if r > maxCycle:
			maxCycle = r
			maxNumerator = d
			print "1/%d has a reciprocal cycle of %d" % (maxNumerator, maxCycle)

print "Max recpricol cycle  is %d from 1/%d" % (maxCycle, maxNumerator)

