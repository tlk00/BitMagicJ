package io.bitmagic

class BVector0 {

  @native protected def init0(ptr: Long)
  @native protected def create0(strategy: Int, size: Long): Long
  @native protected def clone0(ptr: Long): Long
  @native protected def dispose0(ptr: Long)

  @native protected def version0: String
  @native protected def copyright0: String

  @native protected def set0(ptr: Long, idx: Long, bit: Boolean)
  @native protected def get0(ptr: Long, idx: Long): Boolean

//  @native def equals0(ptr: Long)
//  @native def compare0(ptr: Long)
//
//  @native def or0(ptr: Long)
//  @native def and0(ptr: Long)
//  @native def xor0(ptr: Long)
//  @native def sub0(ptr: Long)

}