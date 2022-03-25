package cube

case class CubeState(
  whiteSide: Side,
  yellowSide: Side,
  blueSide: Side,
  greenSide: Side,
  redSide: Side,
  orangeSide: Side
) {

  def transform(transformation: CubeState => CubeState): CubeState = transformation(this)

  override def toString: String = {
    println("--------------------------")
    println
    s"""
    Blue side:
    ${blueSide.toString}
    -
    White side:
    ${whiteSide.toString}
    -
    Orange side:
    ${orangeSide.toString}
    """
  }
  def show(): Unit = println(toString)
}

object CubeState {
  val perfectCube: CubeState =
    CubeState(
      whiteSide = Side.perfectWhiteSide,
      yellowSide = Side.perfectYellowSide,
      blueSide = Side.perfectBlueSide,
      greenSide = Side.perfectGreenSide,
      redSide = Side.perfectRedSide,
      orangeSide = Side.perfectOrangeSide
    )

  def rotateBlueSide: T = T(
    "rotateBlueSide",
    { cs =>
      CubeState(
        whiteSide = cs.whiteSide.edgeRotate(cs.blueSide, cs.redSide),
        yellowSide = cs.yellowSide.edgeRotate(cs.blueSide, cs.orangeSide),
        blueSide = cs.blueSide.rotate,
        greenSide = cs.greenSide,
        redSide = cs.redSide.edgeRotate(cs.blueSide, cs.yellowSide),
        orangeSide = cs.orangeSide.edgeRotate(cs.blueSide, cs.whiteSide)
      )
    }
  )

  def rotateWhiteSide: T = T(
    "rotateWhiteSide",
    { cs =>
      CubeState(
        whiteSide = cs.whiteSide,
        yellowSide = cs.yellowSide.rotate,
        blueSide = cs.blueSide.edgeRotate(cs.whiteSide, cs.orangeSide),
        orangeSide = cs.orangeSide.edgeRotate(cs.whiteSide, cs.greenSide),
        greenSide = cs.greenSide.edgeRotate(cs.whiteSide, cs.redSide),
        redSide = cs.redSide.edgeRotate(cs.whiteSide, cs.blueSide)
      )
    }
  )

  def rotateRedSide: T = T(
    "rotateRedSide",
    { cs =>
      CubeState(
        whiteSide = cs.whiteSide.edgeRotate(cs.redSide, cs.greenSide),
        blueSide = cs.blueSide.edgeRotate(cs.redSide, cs.whiteSide),
        yellowSide = cs.yellowSide.edgeRotate(cs.redSide, cs.blueSide),
        greenSide = cs.greenSide.edgeRotate(cs.redSide, cs.yellowSide),
        redSide = cs.redSide.rotate,
        orangeSide = cs.orangeSide
      )
    }
  )

  def rotateOrangeSide: T = T(
    "rotateOrangeSide",
    { cs =>
      CubeState(
        whiteSide = cs.whiteSide.edgeRotate(cs.orangeSide, cs.blueSide),
        yellowSide = cs.yellowSide.edgeRotate(cs.orangeSide, cs.greenSide),
        blueSide = cs.blueSide.edgeRotate(cs.orangeSide, cs.yellowSide),
        greenSide = cs.greenSide.edgeRotate(cs.orangeSide, cs.whiteSide),
        redSide = cs.redSide,
        orangeSide = cs.orangeSide.rotate
      )
    }
  )

  def rotateGreenSide: T = T(
    "rotateGreenSide",
    { cs =>
      CubeState(
        whiteSide = cs.whiteSide.edgeRotate(cs.greenSide, cs.orangeSide),
        yellowSide = cs.yellowSide.edgeRotate(cs.greenSide, cs.redSide),
        blueSide = cs.blueSide,
        greenSide = cs.greenSide.rotate,
        redSide = cs.redSide.edgeRotate(cs.greenSide, cs.whiteSide),
        orangeSide = cs.orangeSide.edgeRotate(cs.greenSide, cs.yellowSide)
      )
    }
  )

  def rotateYellowSide: T = T(
    "rotateYellowSide",
    { cs =>
      CubeState(
        whiteSide = cs.whiteSide,
        yellowSide = cs.yellowSide.rotate,
        blueSide = cs.blueSide.edgeRotate(cs.yellowSide, cs.redSide),
        orangeSide = cs.orangeSide.edgeRotate(cs.yellowSide, cs.blueSide),
        greenSide = cs.greenSide.edgeRotate(cs.yellowSide, cs.orangeSide),
        redSide = cs.redSide.edgeRotate(cs.yellowSide, cs.greenSide)
      )
    }
  )

  /*
   * Turning a side anti-clockwise is the same as turning it three time clockwise
   */
  def antiClockwise(singleRotation: T): T = T(
    s"anti ${singleRotation.name}", {
      Function.chain(List(singleRotation, singleRotation, singleRotation))
    }
  )

}
