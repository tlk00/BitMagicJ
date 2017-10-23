
import io.bitmagic.java.BitVector
import org.scalatest.FunSuite

class BitVectorJavaTest extends FunSuite {

  test("BitMagic version") {
    val version = BitVector.getVersion
    println("Bitmagic version " + version)
  }

  test("BitVector size") {
    val bv = new BitVector()
    val sz = bv.getSize
    println(s"BitVector size: $sz")
  }

  test("Wrong index") {
    val bv = new BitVector(1,3,5)
    bv.get(-1)
  }
}
