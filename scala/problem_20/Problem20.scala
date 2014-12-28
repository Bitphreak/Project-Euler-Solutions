/** Find the sum of the digits in the number 100!
 * 
 */

object Problem20 {
	def Factorial(n:Int): BigInt = { 
		if (n == 0)
			return 1; 
		else
			return Factorial(n - 1) * n;
		}
           
	def main(args : Array[String]) : Unit = {
		var f:BigInt = Factorial(100);
		var sum:BigInt = 0;
		println("100!:" + f);
		while(f > 0){
			var temp:BigInt = f;
			f /= 10;
			sum += temp - (f * 10);
		}
		println("Sum of digits:" + sum);
	}
}
