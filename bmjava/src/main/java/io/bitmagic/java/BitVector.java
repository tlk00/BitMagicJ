package io.bitmagic.java;

import io.bitmagic.core.*;

import java.util.Iterator;

public final class BitVector extends AbstractBVector implements Iterable<Long> {
  public static long MAX_BITS = 0xFFFFFFFL;

  /**
   * BitMagic version
   * @return major.minor.patch
   */
  public static String getVersion() { return version0(); }

  /**
   * Copyright information
   * @return copyright string
   */
  public static String getCopyright() { return copyright0(); }

  /**
   * General constructor.
   * @param size maximum bit vector size. It is recommended to always set it to <code>MAX_BITS</code>.
   * @param stg memory management strategy. TODO: Elaborate
   * @param bits an array of bits to set.
   */
  public BitVector(long size, Strategy stg, long... bits) {
    super(stg, size, bits);
  }

  /**
   * Creates a bit vector with the maximum size (recommended).
   * @param stg - memory management strategy.
   * @param bits an array of bits to set.
   */
  public BitVector(Strategy stg, long... bits) {
    super(stg, MAX_BITS, bits);
  }

  /**
   * Creates a bit vector with the default strategy and maximum size.
   * @param bits an array of bits to set.
   */
  public BitVector(long... bits) {
    super(Strategy.BM_BIT, MAX_BITS, bits);
  }

  /**
   * Internal use only
   * @param bv pointer to the native structure.
   */
  private BitVector(long bv) { super(bv); }

  /**
   * Creates a copy of the bit vector.
   *
   * @return new <code>BitVector</code> object.
   */
  public BitVector copy() {
    long bv = copy0(getInternal());
    return new BitVector(bv);
  }

  /**
   * Bit vector size.
   *
   * @return size
   */
  public long getSize() {
    return getSize0(getInternal());
  }

  /**
   * Resizes the bit vector.
   *
   * @param size new requested size.
   */
  public void setSize(long size) {
    setSize0(getInternal(), size);
  }

  /**
   * Sets bit at the requested position.
   *
   * @param idx bit position.
   * @param v bit value.
   */
  public void set(long idx, boolean v) {
    set0(getInternal(), idx, v);
  }

  /**
   * Sets bit only if the previous value at this position equals <code>cond</code>
   *
   * @param idx bit position.
   * @param v bit value.
   * @param cond expected previous value.
   */
  public void setIf(long idx, boolean v, boolean cond) {
    setConditional0(getInternal(), idx, v, cond);
  }

  /**
   * Flips a bit.
   *
   * @param idx - bit position.
   */
  public void flip(long idx) {
    flip0(getInternal(), idx);
  }

  /**
   * Sets all bits in the vector to 1.
   */
  public void setAll() {
    setAll0(getInternal());
  }

  /**
   * Sets bits in the closed range <code>[left, right]</code>.
   * This method <b>does not</b> resize the vector.
   *
   * @param left start position.
   * @param right end position.
   * @param v bit value.
   */
  public void setRange(long left, long right, boolean v) {
    setRange0(getInternal(), left, right, v);
  }

  /**
   * Inverts all bits in the bit vector.
   */
  public void invert() {
    invert0(getInternal());
  }

  /**
   * Sets all bits in the vector to 0.
   *
   * @param freeMem flag to release unused memory.
   */
  public void clear(boolean freeMem) {
    clear0(getInternal(), freeMem ? 1 : 0);
  }

  /**
   * Sets all bits in the vector to 0. Releases unused memory by default.
   */
  public void clear() {
    clear0(getInternal(), 1);
  }

  /**
   * Finds the first non-zero bit from <code>idx</code> position and sets it to 0.
   *
   * @param idx start position.
   * @return postion of the next non-zero bit, -1 if no non-zero bits left.
   */
  public long extract(long idx) {
    return extract0(getInternal(), idx);
  }

  /**
   * Gets the bit value at specified position.
   *
   * @param idx bit position.
   * @return bit value.
   */
  public boolean get(long idx) {
    return get0(getInternal(), idx);
  }

  /**
   * Returns number of non-zero bits in the vector.
   * @return number of non-zero bits.
   */
  public long count() {
    return count0(getInternal());
  }

  /**
   * Returns number of non-zero bits in the closed interval <code>[left, right]</code>.
   *
   * @param left start position.
   * @param right end position.
   * @return number of non-zero bits in the range.
   */
  public long countInRange(long left, long right) {
    return countInRange0(getInternal(), left, right);
  }

  /**
   * Checks if there is at lease one non-zero bit in the vector.
   *
   * @return true if a non-zero bit if found.
   */
  public boolean nonEmpty() {
    return nonEmpty0(getInternal());
  }

  /**
   * Checks if all bits in the vector are zero.
   * @return true if all bits in the vector are zero.
   */
  public boolean isEmpty() {
    return !nonEmpty();
  }

  /**
   * Looks for the fisrt non-zero bit from the given position.
   *
   * @param start start position.
   * @return bit position or -1 if not found.
   */
  public long findFirst(long start) {
    return indexOf0(getInternal(), start);
  }

  /**
   * Looks for the first non-zero bit from the beginning of the vector.
   *
   * @return bit position or -1 if not found.
   */
  public long findFirst() {
    return indexOf0(getInternal(), 0);
  }

  /**
   * Compares a bit vector to this.
   * @param bv BitVector object.
   * @return -1 if this less than <code>bv</code>,
   * 0 if this equals to <code>bv</code>,
   * 1 if this greater than <code>bv</code>.
   */
  public int compare(BitVector bv) {
    return compare0(getInternal(), bv.getInternal());
  }

  /**
   * Performs bit vector memory optimization and returns post optimization statistics.
   * @param om OptMode value.
   * @return <code>BitVectorStat</code> object.
   */
  public BitVectorStat optimize(OptMode om) {
    return optimize0(getInternal(), om.ordinal());
  }

  /**
   * Calculates bit vector statistics.
   * @return <code>BitVectorStat</code> object.
   */
  public BitVectorStat calcStat() {
    return calcStat0(getInternal());
  }

  /**
   * Performs a logical operation with the specified bit vector.
   * @param bv BitVector object.
   * @param code <code>OpCode</code> operation.
   */
  public void op(BitVector bv, OpCode code) {
    operation0(getInternal(), bv.getInternal(), code.ordinal());
  }

  /**
   * Performs AND operation with the specified bit vector.
   * @param bv BitVector object.
   */
  public void and(BitVector bv) {
    and0(getInternal(), bv.getInternal());
  }

  /**
   * Performs OR operation with the specified bit vector.
   * @param bv BitVector object.
   */
  public void or(BitVector bv) {
    or0(getInternal(), bv.getInternal());
  }

  /**
   * Performs SUB operation with the specified bit vector.
   * @param bv BitVector object.
   */
  public void sub(BitVector bv) {
    sub0(getInternal(), bv.getInternal());
  }

  /**
   * Performs XOR operation with the specified bit vector.
   * @param bv BitVector object.
   */
  public void xor(BitVector bv) {
    xor0(getInternal(), bv.getInternal());
  }

  /**
   * Returns iterator over non-zero bits.
   * The iterator in non-reentrant, use from a single thread only.
   */
  @Override
  public Iterator<Long> iterator() {
    return new BVIterator(getInternal());
  }
}
