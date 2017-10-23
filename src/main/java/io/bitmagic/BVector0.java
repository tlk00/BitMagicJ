package io.bitmagic;

abstract class BVector0 {
  public static long MAX_BITS = 0xFFFFFFFL;

  public native static void init0(long ptr);
  public native static long create0(int strategy, long size);
  public native static long copy0(long ptr);
  public native static void dispose0(long ptr);

  public native static String version0();
  public native static String copyright0();

  public native static void set0(long ptr, long idx, boolean bit);
  public native static boolean get0(long ptr, long idx);

  public native static long getSize0(long ptr);
  public native static void setSize0(long ptr, long size);

//  @native def equals0(ptr: Long)
//  @native def compare0(ptr: Long)
//
//  @native def or0(ptr: Long)
//  @native def and0(ptr: Long)
//  @native def xor0(ptr: Long)
//  @native def sub0(ptr: Long)

}