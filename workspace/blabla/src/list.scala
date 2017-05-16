

object list extends App {
      var r0=0
      var r1=1
      var r2=2
      var r3=3
      var r4=4
      var t=r1::r2::r3::List(r4)
      for(i<-0 to t.length-2)
      {
        print(t(i)+" : ")
      }
      println(t.last)
}