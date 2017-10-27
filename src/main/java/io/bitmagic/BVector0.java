package io.bitmagic;

abstract class BVector0 {

  public native static void init0(long ptr);
  public native static long create0(int strategy, long size);
  public native static long copy0(long ptr);
  public native static void dispose0(long ptr);

  public native static String version0();
  public native static String copyright0();

  public native static long getSize0(long ptr);
  public native static void setSize0(long ptr, long size);

  public native static void set0(long ptr, long idx, boolean bit);
  public native static boolean setConditional0(long ptr, long idx, boolean bit, boolean condition);
  public native static void flip0(long ptr, long idx);
  public native static void setAll0(long ptr);
  public native static void setRange0(long ptr, long left, long right, boolean bit);
  public native static void invert0(long ptr);
  public native static void clear0(long ptr, int free_mem_flag);
  public native static long extract0(long ptr, long start);

  public native static boolean get0(long ptr, long idx);
  public native static long count0(long ptr);
  public native static long countInRange0(long ptr, long left, long right);
  public native static boolean nonEmpty0(long ptr);
  public native static long indexOf0(long ptr, long start);

  public native static int compare0(long ptr1, long ptr2);
  public native static BitVectorStat optimize0(long ptr, int opt_mode);
  public native static BitVectorStat calcStat0(long ptr);

  public native static void operation0(long dst, long src, int op_code);

  public native static void and0(long dst, long src);
  public native static void or0(long dst, long src);
  public native static void sub0(long dst, long src);
  public native static void xor0(long dst, long src);

}