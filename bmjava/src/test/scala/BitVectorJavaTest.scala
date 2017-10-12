
import io.bitmagic.java.BitVector
import org.scalatest.FunSuite

class BitVectorJavaTest extends FunSuite {

  test("BitMagic version") {
    val version = BitVector.getVersion
    println("Bitmagic version " + version)

  }
}
