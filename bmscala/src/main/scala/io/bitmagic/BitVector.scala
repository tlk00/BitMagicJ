package io.bitmagic

import java.nio.file.{Files, Paths, StandardCopyOption}
import java.util.UUID

import scala.io.StdIn

object BitVector {
//  final val LibName = "bmjni"
//
//  private def loadjni(): Unit = {
//    val osLibName = System.mapLibraryName(LibName)
//    val libIs = this.getClass.getResourceAsStream("/" + osLibName)
//    val tmpDir = Paths.get(System.getProperty("java.io.tmpdir"))
//    val bmTmp = UUID.randomUUID().toString
//    val libDirPath = tmpDir.resolve(bmTmp)
//    Files.createDirectory(libDirPath)
//    val libPath = libDirPath.resolve(osLibName)
//    Files.copy(libIs, libPath, StandardCopyOption.REPLACE_EXISTING)
//    Runtime.getRuntime.load(libPath.toString)
//  }

  def apply(strategy: Strategy, bits: Long*) = new BitVector(strategy, BVector0.MAX_BITS, bits:_*)
  def apply(bits: Long*) = new BitVector(Strategy.BM_BIT, BVector0.MAX_BITS, bits:_*)

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
