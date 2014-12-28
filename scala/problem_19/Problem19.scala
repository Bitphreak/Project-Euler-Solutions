/**You are given the following information, but you may prefer to do some research for yourself.
  *
  * - 1 Jan 1900 was a Monday.
  * - Thirty days has September,
  * - April, June and November.
  * - All the rest have thirty-one,
  * - Saving February alone,
  * - Which has twenty-eight, rain or shine.
  * - And on leap years, twenty-nine.
  * - A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
  *
  * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
  */

import java.util.{Calendar, GregorianCalendar};

object Problem19 {
  def main(args : Array[String]) : Unit = {}
  var day = new GregorianCalendar(1900,Calendar.JANUARY,7);
  val start = new GregorianCalendar(1901,Calendar.JANUARY,1);
  val end = new GregorianCalendar(2000,Calendar.DECEMBER,31);
  var count:Int = 0;
  while(day.getTimeInMillis() < end.getTimeInMillis()){
  	//int dow = cal.get(Calendar.DAY_OF_WEEK);
  	if(day.getTimeInMillis() >= start.getTimeInMillis() && day.get(Calendar.DATE) == 1){
  		count += 1;
  	}
  	day.add(Calendar.DATE, 7);
  }
  println("Sundays: " + count);
}
