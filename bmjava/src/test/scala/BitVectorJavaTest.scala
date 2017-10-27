
import io.bitmagic.{OptMode, Strategy}
import io.bitmagic.java.BitVector
import org.scalatest.FunSuite

class BitVectorJavaTest extends FunSuite {

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

    var stat = bv.calcStat()
    println("Bit count: " + bv.count())
    println(stat)
    stat = bv.optimize(OptMode.FREE_EMPTY_BLOCKS)
    println(stat)
  }
}
