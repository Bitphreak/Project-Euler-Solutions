/** If the numbers 1 to 5 are written out in words: one, two, three, four, five,
  * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
  *
  * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
  * in words, how many letters would be used?
  *
  * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
  */ 

import scala.math.ceil;
import scala.math.log10;

object Problem17 {
	def digits(value:Double) : Int = {
		var d = ceil(log10(value));
		return d.toInt;
	}

	def digit(value:Int, place:Int) : Int = {
			var temp:Int = value;
			var i = 0;
			while(i < place){
				temp /= 10; //get rid of the preceding digits
				i += 1;
			}
			return temp % 10; //now ignore all of the following ones
	}
	
	def main(args : Array[String]) : Unit = {
		val singles:Array[Int] = Array(0, 3, 3, 5, 4, 4, 3, 5, 5, 4); /* (ZERO), ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE */
		val teens:Array[Int] = Array(3, 6, 6, 8, 8, 7, 7, 9, 9, 8); /* TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN, SEVENTEEN, EIGHTTEEN, NINETEEN */
		val tens:Array[Int] = Array(0, 0, 6, 6, 5, 6, 5, 5, 7, 6, 6); /* TWENTY, THIRTY, FORTY, FIFTY, SIXTY, SEVENTY, EIGHTY, NINETY */
		val hundred:Int = 7;/* HUNDRED */
		val hundredand:Int = 10;
		val thousand:Int = 11;
		var total:Int = 0;
		var hTotal:Int = 0;
		var sTotal:Int = 0;
		val limit = 100;
		var i = 0;
		while(i < limit){
			if(i < 10){
				hTotal += singles(i);
				sTotal += singles(i);
			}else if(i < 20){
				hTotal += teens(i-10);
			}else if(i < 100){
				hTotal += tens(digit(i,1)) + singles(digit(i,0));
			}
			i += 1;
		}
		total = hTotal * 10; //0-99 for 0, 100...900
		total += hundred * 9 + sTotal; //100, 200, 300, 400, 500, 600, 700, 800, 900
		total += sTotal * 99; // singles for 101..199, 201..299, 301..399, 401..499, 501..599, 601..699, 701..799, 801..899, 901..999
		total += hundredand * 890 + thousand; // Why not 891
		
		println("Total: " + total);
		println("sTotal: " + sTotal);
		println("diff: " + (21124 - total));
	}
}
