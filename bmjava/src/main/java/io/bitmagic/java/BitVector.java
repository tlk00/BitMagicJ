package io.bitmagic.java;

import io.bitmagic.AbstractBVector;
import io.bitmagic.Strategy;

public final class BitVector extends AbstractBVector {

  public static String getVersion() { return version0(); }
  public static String getCopyright() { return copyright0(); }

  public BitVector(Strategy stg, long size, long... bits) {
    super(stg, size, bits);
  }

  public BitVector(long... bits) {
    super(Strategy.BM_BIT, MAX_BITS, bits);
  }

  private BitVector(long bv) { super(bv); }

  public BitVector copy() {
    long bv = copy0(_bv);
    return new BitVector(bv);
  }

  public long getSize() {
    return getSize0(_bv);
  }

  public void setSize(long size) {
    setSize0(_bv, size);
  }

  public boolean get(long idx) {
    return get0(_bv, idx);
  }

  public void set(long idx, boolean v) {
    set0(_bv, idx, v);
  }
}
