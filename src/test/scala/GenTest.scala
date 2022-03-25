import org.scalacheck.Gen
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

import cube.CubeState
import cube.CubeState._
import cube.T

class GenTest extends AnyFlatSpec with Matchers with ScalaCheckDrivenPropertyChecks {
  val genTransformation =
    Gen.containerOf[List, T](
      Gen.oneOf(
        rotateWhiteSide,
        rotateYellowSide,
        rotateBlueSide,
        rotateGreenSide,
        rotateRedSide,
        rotateOrangeSide
      )
    )

  "Reversing one blue rotation" should "yield the original cube" in {
    perfectCube
      .transform(rotateBlueSide)
      .transform(antiClockwise(rotateBlueSide)) shouldEqual perfectCube
  }

  "Reversing one white rotation" should "yield the original cube" in {
    perfectCube
      .transform(rotateWhiteSide)
      .transform(antiClockwise(rotateWhiteSide)) shouldEqual perfectCube
  }

  "Reversing one orange rotation" should "yield the original cube" in {
    perfectCube
      .transform(rotateOrangeSide)
      .transform(antiClockwise(rotateOrangeSide)) shouldEqual perfectCube
  }

  "Reversing any rotations" should "yield the original cube" in {

    forAll(genTransformation) { ls =>
      {
        val reversed: List[T] = ls ::: ls.reverse.map(antiClockwise(_))
        // println(reversed)
        val transformed = perfectCube.transform(Function.chain(reversed))
        transformed shouldEqual perfectCube
      }
    }
  }
}
