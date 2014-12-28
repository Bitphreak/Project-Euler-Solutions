import scala.math.{ceil, log10, pow}

/** What is the first term in the Fibonacci sequence to contain 1000 digits?
  */

object Problem25 {
	val limit:BigInt = BigInt(10).pow(999)

	def digits(value:BigInt) : BigInt = {
		var d = ceil(log10(value.toDouble));
		return d.toInt;
	}

	def main(args : Array[String]) : Unit = {
		var n0:BigInt = 0;
		var n1:BigInt = 1;
		var naux:BigInt = 0;
		var i = 0;
		var term = 0;
		//println("limit:" + limit)
		//println("digits:" + digits(limit))
		while(n1 < limit){
			naux = n1;
			n1 = n0 + n1;
			n0 = naux;
			i += 1;
			term = i + 1;

		}
		println("Term:" + term)
	}
}
