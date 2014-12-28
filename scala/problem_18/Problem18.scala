import scala.io.Source

case class Bool(b: Boolean) {
  def ?[X](t: => X) = new {
    def |(f: => X) = if(b) t else f
  }
}

object Bool {
  implicit def BooleanBool(b: Boolean) = Bool(b)
}

object Problem18 {
	def main(args : Array[String]) : Unit = {
		var fileName = "src/data.txt";
		val lines:Array[String] = Source.fromFile(fileName).getLines.toArray;
		var row:Array[Int] = Array.fromFunction((_) => 0)(100);
		for(line <- lines.reverse){
			var n:Int = -1;
			var p:Int = -1;
			var i:Int = 0;
			var j:Int = 0;
			for(number <- line.split(" ")){
				n = p;
				p = number.toInt + row(j);
				if(n > -1){
					var l:Int = 0;
					if(n > p) l = n else l = p;
					row(i) = l;
					println("n:" + n + " p:" + p + " i:" + i + " j:" + j + "row(" + i + ") == " + row(i));
					i += 1;
				}
				j += 1;
			}
			if(i > 0)
				row(i) = 0;
			else
				row(i) = p;
			println(row(0) + ":" + row(1) + ":" + row(2) + ":" + row(3));
		}
		println("Largest Path: " + row(0));
		exit;
	}
}
