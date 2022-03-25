package cube

object Side {

  def paint(positions: Seq[Pos], color: Color): Map[Pos, Color] =
    positions.map(p => (p, color)).toMap

  def fromString(color: Color, colorString: String): Side = {
    require(colorString.length == 8)

    Pos.whitePositions

    Side(color, paint(Pos.yellowPositions, Color.Yellow))
  }

  def perfectSide(color: Color): Side = {
    Side(color, paint(Pos.colorToPositionsMap(color), color))
  }

  val perfectYellowSide =
    Side(
      Color.Yellow,
      paint(Pos.yellowPositions, Color.Yellow)
    )
  val perfectWhiteSide =
    Side(
      Color.White,
      paint(Pos.whitePositions, Color.White)
    )
  val perfectBlueSide =
    Side(
      Color.Blue,
      paint(Pos.bluePositions, Color.Blue)
    )
  val perfectGreenSide =
    Side(
      Color.Green,
      paint(Pos.greenPositions, Color.Green)
    )
  val perfectRedSide =
    Side(
      Color.Red,
      paint(Pos.redPositions, Color.Red)
    )
  val perfectOrangeSide =
    Side(
      Color.Orange,
      paint(Pos.orangePositions, Color.Orange)
    )
  /*
  def all(color: Color): Side =
    Side(color, color, color, color, color, color, color, color)

  def fromArray(a: Array[Color]): Side = {
    Side(a(0), a(1), a(2), a(3), a(4), a(5), a(6), a(7))
  }
   */
}

// case class Side(c0: Color, c1: Color, c2: Color, c3: Color, c4: Color, c5: Color, c6: Color, c7: Color) {
case class Side(
  color: Color,
  colors: Map[Pos, Color]
) {

  lazy val positions: Seq[Pos] = Pos.colorToPositionsMap(color)
  lazy val clockwiseRotation: Pos => Pos = Rotation.colorToRotationMap(color)

  def antiClockwiseRotation: Pos => Pos =
    Function.chain(Seq(clockwiseRotation, clockwiseRotation, clockwiseRotation))

  /*
+ --- + --- + --- +
|  c7 |  c0 +  c1 |
+ --- + --- + --- +
|  c6 | mid +  c2 |
+ --- + --- + --- +
|  c5 |  c4 +  c3 |
+ --- + --- + --- +

   */
  def rotate: Side = {
    val positionsMap: Map[Pos, Pos] = positions.map(p => (clockwiseRotation(p), p)).toMap
    val newColors: Map[Pos, Color] = positions.map(p => (p, colors(positionsMap(p)))).toMap

    this.copy(colors = newColors)
  }

  def edgeRotate(rotationSide: Side, fromSide: Side): Side = {
    val intersect: Seq[Pos] = rotationSide.positions.intersect(this.positions)
    val newPieces =
      fromSide.positions.filter(p => intersect.contains(rotationSide.clockwiseRotation(p)))
    val newColors: Map[Pos, Color] =
      newPieces.map(p => (rotationSide.clockwiseRotation(p), fromSide.colors(p))).toMap

    this.copy(colors = this.colors.++(newColors))

  }

  override def toString: String = {
    s"""
    ${this.color}
    ${this.colors}
    """

  }
}
