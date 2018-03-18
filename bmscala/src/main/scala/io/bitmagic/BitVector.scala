package io.bitmagic

import io.bitmagic.core.{AbstractBVector, Strategy}

import scala.io.StdIn

object BitVector {
  final val MAX_BITS = AbstractBVector.MAX_BITS

  def apply(strategy: Strategy, bits: Long*) = new BitVector(strategy, MAX_BITS, bits:_*)
  def apply(bits: Long*) = new BitVector(Strategy.BM_BIT, MAX_BITS, bits:_*)

//  loadjni()
//  init0(0)

  def main(args: Array[String]): Unit = {
    var bv1 = BitVector(1)
    println(bv1.version)
    println(bv1.copyright)
    bv1 = null
    System.runFinalization()

    System.gc()
    StdIn.readLine() // let it run until user presses return
  }

}

final class BitVector(strategy: Strategy, size: Long, bits: Long*) extends AbstractBVector(strategy, size, bits.toArray: _*) {

  def version: String = AbstractBVector.getVersion
  def copyright: String = AbstractBVector.getCopyright

}
