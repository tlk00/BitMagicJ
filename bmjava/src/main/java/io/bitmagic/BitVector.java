package io.bitmagic;

public final class BitVector extends AbstractBVector {

  public BitVector(Strategy stg, long size, long... bits) {
    super(stg, size, bits);
  }

  public BitVector(long... bits) {
    super(Strategy.BM_BIT, MAX_BITS, bits);
  }

}
