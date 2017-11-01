package io.bitmagic.core;

import java.util.Iterator;

public final class BVIterator extends BVIterator0 implements Iterator<Long> {
  private long _bvi = 0;
  private boolean _first = true;

  public BVIterator(long bvPtr) {
    _bvi = create0(bvPtr);
  }

  @Override
  public boolean hasNext() {
    return isValid0(_bvi);
  }

  @Override
  public Long next() {
    if (_first) {
      _first = false;
      return get0(_bvi);
    }
    else
      return next0(_bvi);
  }

  @Override
  protected void finalize() {
    if (_bvi != 0) dispose0(_bvi);
  }
}
