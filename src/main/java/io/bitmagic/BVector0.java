package io.bitmagic;

class BVector0 {

  native protected long init0(long ptr);
  native protected long create0(int strategy, long size);
  native protected long clone0(long ptr);
  native protected void dispose0(long ptr);

  native protected String version0();
  native protected String copyright0();

  native protected void set0(long ptr, long idx, boolean bit);
  native protected boolean get0(long ptr, long idx);

//  @native def equals0(ptr: Long)
//  @native def compare0(ptr: Long)
//
//  @native def or0(ptr: Long)
//  @native def and0(ptr: Long)
//  @native def xor0(ptr: Long)
//  @native def sub0(ptr: Long)

}