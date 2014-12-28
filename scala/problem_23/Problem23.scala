/** A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example,
  * the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
  * 
  * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
  * 
  * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant
  * numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two
  * abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest
  * number that cannot be expressed as the sum of two abundant numbers is less than this limit.
  * 
  * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
  */

object Problem23 {
	val limit:Int = 28123;
	var abundents:Array[Boolean] = Array.fromFunction((_) => false)(limit);
	def IsAbundent(n:Int) : Boolean = {
		
		var sum:Int = 0
		var i:Int = 1
		//println("d(" + n + ")")
		var c = 0;
		while(i < n && sum <= n){
			if(n % i == 0){
				//println(i + " is a proper divisor of " + n)
				sum += i
			}
			i += 1
		}
		//println("d:" + d)
		return sum > n
	}

	def IsSumOfAbundent(n:Int) : Boolean = {
		var i:Int = 1;
		while(i < n){
			if(abundents(i) && abundents(n - i)){
				return true;
			}
			i += 1;
		}
		//print("IsSumOfAbundent(" + n + ") == ")
		//println("False")
		return false;
	}

	def main(args : Array[String]) : Unit = {
		var i:Int = 1;
		var sum:Int = 0;
		while(i < limit){
			abundents(i) = IsAbundent(i)
			if(IsSumOfAbundent(i) == false)
				sum += i;
			i += 1;
		}
		//4179871
		println("Sum:" + sum)
	}
}
