package io.bitmagic.core;

public class BitVectorStat {
  private long _bitBlocks;
  private long _gapBlocks;
  private long _maxSerializeMem;
  private long _memoryUsed;

  public BitVectorStat(long bb, long gb, long msm, long mu) {
    _bitBlocks = bb;
    _gapBlocks = gb;
    _maxSerializeMem = msm;
    _memoryUsed = mu;
  }

  public long getBitBlocks() { return _bitBlocks; }
  public long getGapBlocks() { return _gapBlocks; }
  public long getMaxSerializeMem() { return _maxSerializeMem; }
  public long getMemoryUsed() { return _memoryUsed; }

  @Override
  public String toString() {
    return "Bit blocks: " + _bitBlocks + ", gap blocks: " + _gapBlocks + ", max serialize mem: " + _maxSerializeMem
        + ", memory used: " + _memoryUsed;
  }
}
