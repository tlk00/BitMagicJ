package io.bitmagic;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public abstract class AbstractBVector extends BVector0 {
  private static String LIB_NAME = "bmjni";

  static {
    String osLibName = System.mapLibraryName(LIB_NAME);
//    Path tmpDir = Paths.get(System.getProperty("java.io.tmpdir"));
//    String bmTmp = UUID.randomUUID().toString();
//    Path libDirPath = tmpDir.resolve(bmTmp);
//    Path libPath = libDirPath.resolve(osLibName);
    try(InputStream libIs = AbstractBVector.class.getResourceAsStream("/" + osLibName)) {
      Path libTmp = Files.createTempFile(null, null);
//      Files.createDirectory(libDirPath);
      Files.copy(libIs, libTmp, StandardCopyOption.REPLACE_EXISTING);
      System.load(libTmp.toString());
      init0(0);
    }
    catch (IOException e) {
      throw new RuntimeException("Library initialization problem.", e);
    }
  }

  protected long _bv = 0; // finalization runs in case of any exception

  public AbstractBVector(Strategy stg, long size, long... bits) {
    _bv = create0(stg.ordinal(), size);

    for(long b: bits) {
      set0(_bv, b, true);
    }
  }

  public AbstractBVector(long bv) {
    _bv = bv;
  }

  public static String getVersion() { return version0(); }
  public static String getCopyright() { return copyright0(); }

  @Override protected void finalize() {
    if (_bv != 0) dispose0(_bv);
  }
}
