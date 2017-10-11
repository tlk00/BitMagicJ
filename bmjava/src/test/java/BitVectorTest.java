
import io.bitmagic.BitVector;
import org.junit.Test;

public class BitVectorTest {

  @Test
  public void testVersion() {
    String version = BitVector.getVersion();
    System.out.println("Bitmagic version " + version);
  }
}