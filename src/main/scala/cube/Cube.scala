package cube

object Cube extends App {
  println("Hello Cube!")

  /*
  val cs0: CubeState = CubeState.perfectCube

  cs0.show()

  val cs1 = cs0.transform(CubeState.rotateOrangeSide)
  cs1.show()
   */
  println(Pos.orangePositions)

  Pos.orangePositions.map(p => s"${p} -> ${Rotation.orangeRotation(p)}").foreach(println)

  /*
  val cs2 = cs1.transform(CubeState.rotateWhiteSide)
  cs2.show()

  val cs3 = cs2.transform(CubeState.antiClockwise(CubeState.rotateWhiteSide))
  cs3.show()

  val cs4 = cs3.transform(CubeState.antiClockwise(CubeState.rotateBlueSide))
  cs4.show()
   */

  // val cs2 = CubeState.rotateBlueSide(cs1)
  val fullCircle: CubeState => CubeState = Function.chain(
    List(
      CubeState.rotateBlueSide,
      CubeState.rotateBlueSide,
      CubeState.rotateBlueSide,
      CubeState.rotateBlueSide
    )
  )

  // cs2.show()

  /*
  val YBR = CornerPosition(Color.Yellow, Color.Blue, Color.Red)
  val YRG = CornerPosition(Color.Yellow, Color.Red, Color.Green)
  val YGO = CornerPosition(Color.Yellow, Color.Green, Color.Orange)
  val YOB = CornerPosition(Color.Yellow, Color.Orange, Color.Blue)
  val WBR = CornerPosition(Color.White, Color.Blue, Color.Red)
  val WRG = CornerPosition(Color.White, Color.Red, Color.Green)
  val WGO = CornerPosition(Color.White, Color.Green, Color.Orange)
  val WOB = CornerPosition(Color.White, Color.Orange, Color.Blue)

  val WO = EdgePosition(Color.White, Color.Orange)
  val WG = EdgePosition(Color.White, Color.Orange)
  val WR = EdgePosition(Color.White, Color.Orange)
  val WB = EdgePosition(Color.White, Color.Orange)
  val YO = EdgePosition(Color.Yellow, Color.Orange)
  val YG = EdgePosition(Color.Yellow, Color.Orange)
  val YR = EdgePosition(Color.Yellow, Color.Orange)
  val YB = EdgePosition(Color.Yellow, Color.Orange)
  val OB = EdgePosition(Color.Orange, Color.Blue)
  val BR = EdgePosition(Color.Blue, Color.Red)
  val RG = EdgePosition(Color.Red, Color.Green)
  val GO = EdgePosition(Color.Green, Color.Orange)

  val defaultYellowSide: Side = Side.all(Color.Yellow)
  val defaultWhiteSide: Side = Side.all(Color.White)
  val defaultRedSide: Side = Side.all(Color.Red)
  val defaultOrangeSide: Side = Side.all(Color.Orange)
  val defaultBlueSide: Side = Side.all(Color.Blue)
  val defaultGreenSide: Side = Side.all(Color.Green)
   */

}
