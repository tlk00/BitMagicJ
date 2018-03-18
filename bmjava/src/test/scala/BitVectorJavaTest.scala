
import io.bitmagic.core.Strategy
import io.bitmagic.core.{OptMode, Strategy}
import io.bitmagic.java.BitVector
import org.scalactic.source.Position
import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, FunSuite}

import scala.collection.JavaConverters._

class BitVectorJavaTest extends FunSuite with BeforeAndAfterAll {

  override def beforeAll(): Unit = {
//    import java.io.BufferedReader
//    import java.io.InputStreamReader
//    val br = new BufferedReader(new InputStreamReader(System.in))
//    System.out.print("Enter:")
//    val s = br.readLine
  }


  test("BitMagic version") {
    val version = BitVector.getVersion
    println("Bitmagic version " + version)
  }

  test("BitVector size") {
    val bSize = 10000
    val bSize2 = 13445
    val bv = new BitVector(bSize, Strategy.BM_BIT)
    val sz = bv.getSize
    println(s"BitVector size: $sz")
    assert(sz == bSize)
    bv.setSize(bSize2)
    assert(bv.getSize == bSize2)
  }

  test("Set and retrieval") {
    val bv = new BitVector(1,3,5)
    assert(bv.get(1))
    assert(!bv.get(2))
    bv.set(2, true)
    assert(bv.get(2))
  }

  test("Optimize") {
    val bv = new BitVector(Strategy.BM_BIT, 1,3,5, 560, 2346, 5876, 8458, 1234567, 2345678)

    println("Bit count: " + bv.count())
    var stat = bv.calcStat()
    println(stat)
    stat = bv.optimize(OptMode.FREE_EMPTY_BLOCKS)
    println(stat)
  }

  test("Iterator") {
    val bv = new BitVector(Strategy.BM_BIT, 1,3,5, 560, 2346, 5876, 8458, 1234567, 2345678)

    for(i <- bv.iterator().asScala) {
      print(i)
      print(" ")
    }
    println()
  }

  test("Serialization") {
    var bv = new BitVector()
    var bit = true
    val limit: Long = 100000000
//    val limit: Long = Integer.MAX_VALUE.asInstanceOf[Long] << 1
    var idx = 0L
    while(idx < limit) {
      bit = !bit
      bv.set(idx, bit)
      idx += 1
    }
    println("Bit count1: " + bv.count)
    val serialized = bv.toArray
    println("Serialized length:" + serialized.length)
    val bv2 = new BitVector(serialized)
    println("Bit count2: " + bv2.count)
    assert(bv.count == bv2.count)
  }

//  test("Jni memory allocation") {
//    println("Starting jni memory allocation test")
//    var bv = new BitVector()
//    var bit = true
////    val limit: Long = 100000000
//    val limit: Long = 65537
//    var idx = 0L
//    while(idx < limit) {
//      if (idx > 65535)
//        println("Bit " + idx)
//      bit = !bit
//      bv.set(idx, bit)
//      idx += 1
//    }
//    println("Bit count1: " + bv.count)
//    bv = null
//    System.runFinalization()
//    System.gc()
//    Thread.sleep(10000)
//  }
}
