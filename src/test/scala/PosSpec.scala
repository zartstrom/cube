import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import cube.CubeState
import cube.CubeState._
import cube.Pos

class PosSpec extends AnyFlatSpec with Matchers {
  "White positions" should "have y-value == 1" in {
    Pos.whitePositions.size shouldEqual 8
    Pos.whitePositions.filter(_.y == 1).size shouldEqual 8
  }
  "Yellow positions" should "have y-value == -1" in {
    Pos.yellowPositions.size shouldEqual 8
    Pos.yellowPositions.filter(_.y == -1).size shouldEqual 8
  }
  "Blue positions" should "have x-value == 1" in {
    Pos.bluePositions.size shouldEqual 8
    Pos.bluePositions.filter(_.x == 1).size shouldEqual 8
  }
  "Green positions" should "have x-value == -1" in {
    Pos.greenPositions.size shouldEqual 8
    Pos.greenPositions.filter(_.x == -1).size shouldEqual 8
  }
  "Red positions" should "have z-value == 1" in {
    Pos.redPositions.size shouldEqual 8
    Pos.redPositions.filter(_.z == 1).size shouldEqual 8
  }
  "Orange positions" should "have z-value == -1" in {
    Pos.orangePositions.size shouldEqual 8
    Pos.orangePositions.filter(_.z == -1).size shouldEqual 8
  }

}
