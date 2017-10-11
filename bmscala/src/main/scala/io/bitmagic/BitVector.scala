package io.bitmagic

import java.nio.file.{Files, Paths, StandardCopyOption}
import java.util.UUID

import scala.io.StdIn

object BitVector extends BVector0 {
  final val MaxBits: Long = 0xFFFFFFFL
  final val LibName = "bmjni"

  private def loadjni(): Unit = {
    val osLibName = System.mapLibraryName(LibName)
    val libIs = this.getClass.getResourceAsStream("/" + osLibName)
    val tmpDir = Paths.get(System.getProperty("java.io.tmpdir"))
    val bmTmp = UUID.randomUUID().toString
    val libDirPath = tmpDir.resolve(bmTmp)
    Files.createDirectory(libDirPath)
    val libPath = libDirPath.resolve(osLibName)
    Files.copy(libIs, libPath, StandardCopyOption.REPLACE_EXISTING)
    Runtime.getRuntime.load(libPath.toString)
  }

  def apply(strategy: Strategy, bits: Long*) = new BitVector(strategy, MaxBits, bits:_*)
  def apply(bits: Long*) = new BitVector(Strategy.BM_BIT, MaxBits, bits:_*)

  loadjni()
  init0(0)

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

final class BitVector(strategy: Strategy, size: Long, bits: Long*) extends BVector0 {

  private var _bv: Long = 0 // finalization runs in case of any exception
  _bv = create0(strategy.ordinal(), size)

  bits.foreach(set0(_bv, _, true))

  def version: String = version0
  def copyright: String = copyright0

  override protected def finalize(): Unit = {
    println(s"Finalizing ${_bv}")
    if (_bv != 0) dispose0(_bv)
  }
}
