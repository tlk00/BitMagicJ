package io.bitmagic.core;

public abstract class BVIterator0 {
  public native static long create0(long bvPtr);
  public native static void dispose0(long ptr);

  public native static boolean isValid0(long ptr);
  public native static long get0(long ptr);
  public native static boolean next0(long ptr);
}
