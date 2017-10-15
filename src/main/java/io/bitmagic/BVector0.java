package io.bitmagic;

class BVector0 {
  public static long MAX_BITS = 0xFFFFFFFL;

  native protected static long init0(long ptr);
  native protected static long create0(int strategy, long size);
  native protected static long clone0(long ptr);
  native protected static void dispose0(long ptr);

  native protected static String version0();
  native protected static String copyright0();

  native protected static void set0(long ptr, long idx, boolean bit);
  native protected static boolean get0(long ptr, long idx);

//  @native def equals0(ptr: Long)
//  @native def compare0(ptr: Long)
//
//  @native def or0(ptr: Long)
//  @native def and0(ptr: Long)
//  @native def xor0(ptr: Long)
//  @native def sub0(ptr: Long)

}