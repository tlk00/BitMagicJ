package io.bitmagic.core;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public abstract class AbstractBVector extends BVector0 {
  private static String LIB_NAME = "bmjni";

  static {
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
    _bv = create0(0, buf.length);
    deserialize0(_bv, buf);
  }

  public AbstractBVector(long bv) {
    _bv = bv;
  }

  public static String getVersion() { return version0(); }
  public static String getCopyright() { return copyright0(); }

  @Override
  protected void finalize() {
    if (_bv != 0) dispose0(_bv);
  }
}
