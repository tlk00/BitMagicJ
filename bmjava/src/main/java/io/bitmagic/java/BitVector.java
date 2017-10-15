package io.bitmagic.java;

import io.bitmagic.AbstractBVector;
import io.bitmagic.Strategy;

public final class BitVector extends AbstractBVector {

  public BitVector(Strategy stg, long size, long... bits) {
    super(stg, size, bits);
  }

  public BitVector(long... bits) {
    super(Strategy.BM_BIT, MAX_BITS, bits);
  }

  public static String getVersion() { return version0(); }
  public static String getCopyright() { return copyright0(); }
}
