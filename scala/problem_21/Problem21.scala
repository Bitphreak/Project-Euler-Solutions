/** Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
  * If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and each of a and b are called amicable numbers.
  * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper
  * divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
  *
  * Evaluate the sum of all the amicable numbers under 10000.
  */

// Stop testing once sum of test case is > d(n)

object Problem21 {
	def d(n:Int) : Int = {
		
		var d:Int = 0
		var i:Int = 1
		//println("d(" + n + ")")
		while(i < n){
			if(n % i == 0){
				//println(i + " is a proper divisor of " + n)
				d += i
			}
			i += 1
		}
		//println("d:" + d)
		return d
	}

	def main(args : Array[String]) : Unit = {
		val limit = 10000;
		var dns:Array[Int] = Array.fromFunction((_) => -1)(limit);
		var i:Int = 2;
		var sum:Int = 0;
		while(i < limit){
			if(dns(i) == -1){
				var n:Int = d(i);
				if(n < limit && dns(n) == -1){
					dns(i) = n;
					//println("n:" + n);
					var p:Int = d(n);
					//println("p:" + p);
					if(p < limit)
						dns(n) = p;
					// i = 220, d(i) == n == 284
					// n = 284, d(n) == p == 220
					if(p == i && i != n){
						println("d(" + i + ") == " + n + " and d(" + n + ") == " + p);
						sum += n + p;
					}
				}
			}
			i += 1;
		}
		println("Sum:" + sum);
	}
}
