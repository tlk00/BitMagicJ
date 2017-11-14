package io.bitmagic.core;

import java.util.Iterator;

/**
 * Iterates through non-zero bits. Non-reentrant, non-reuseable.
 */
public final class BVIterator extends BVIterator0 implements Iterator<Long> {
  private long _bvi = 0;
  private boolean _nonEmpty;
  private boolean _nextCalled = false;

  public BVIterator(long bvPtr) {
    _bvi = create0(bvPtr);
    _nonEmpty = isValid0(_bvi);
  }

  @Override
  public boolean hasNext() {
    if (_nextCalled) {
      // Advance to next bit
      _nonEmpty = next0(_bvi);
      _nextCalled = false;
    }
    return _nonEmpty;
  }

  @Override
  public Long next() {
    _nextCalled = true;
    return get0(_bvi);
  }

  @Override
  protected void finalize() {
    if (_bvi != 0) dispose0(_bvi);
  }
}
