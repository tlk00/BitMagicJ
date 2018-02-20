package io.bitmagic.core;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public abstract class AbstractBVector extends BVector0 implements AutoCloseable {
  private static String CPUID_LIB_NAME = "bmcpuid";
  private static String LIB_NAME = "bmjni";
  public static long MAX_BITS = 0xFFFFFFFFL;


  static {
    // Get the library name based on the current instruction set
    String osCpuidLibName = System.mapLibraryName(CPUID_LIB_NAME);
    String libName = LIB_NAME;
    try(InputStream libIs = AbstractBVector.class.getResourceAsStream("/" + osCpuidLibName)) {
      Path libTmp = Files.createTempFile(null, null);
      Files.copy(libIs, libTmp, StandardCopyOption.REPLACE_EXISTING);
      System.load(libTmp.toString());
      libName = SimdUtil0.getLibName0();
    }
    catch (IOException e) {
      throw new RuntimeException("CPUID library initialization problem.", e);
    }
    System.out.println("Current library name: " + libName);
    String osLibName = System.mapLibraryName(LIB_NAME);
    try(InputStream libIs = AbstractBVector.class.getResourceAsStream("/" + osLibName)) {
      Path libTmp = Files.createTempFile(null, null);
      Files.copy(libIs, libTmp, StandardCopyOption.REPLACE_EXISTING);
      System.load(libTmp.toString());
      init0(0);
    }
    catch (IOException e) {
      throw new RuntimeException("Library initialization problem.", e);
    }
  }

  private long _bv = 0; // finalization runs in case of any exception

  protected long getInternal() { return _bv; }

  public AbstractBVector(Strategy stg, long size, long... bits) {
    _bv = create0(stg.ordinal(), size);

    for(long b: bits) {
      set0(_bv, b, true);
    }
  }

  public AbstractBVector(byte[] buf) {
    _bv = create0(0, MAX_BITS);
    deserialize0(_bv, buf);
  }

  public AbstractBVector(long bv) {
    _bv = bv;
  }

  public static String getVersion() { return version0(); }
  public static String getCopyright() { return copyright0(); }


  @Override
  public void close() {
    if (_bv != 0)
      synchronized (this) {
        dispose0(_bv);
        _bv = 0;
      }
  }

  @Override
  protected void finalize() {
    close();
  }
}
