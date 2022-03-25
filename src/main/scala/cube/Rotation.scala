package cube

object Rotation {
  def blueRotation: Pos => Pos = { p =>
    if (p.x == 1) {
      Pos(p.x, p.z, -1 * p.y)
    } else { p }
  }
  def greenRotation: Pos => Pos = { p =>
    if (p.x == -1) {
      Pos(p.x, -1 * p.z, p.y)
    } else { p }
  }
  def whiteRotation: Pos => Pos = { p =>
    if (p.y == 1) {
      Pos(-1 * p.z, p.y, p.x)
    } else { p }
  }
  def yellowRotation: Pos => Pos = { p =>
    if (p.y == -1) {
      Pos(p.z, p.y, -1 * p.x)
    } else { p }
  }
  def redRotation: Pos => Pos = { p =>
    if (p.z == 1) {
      Pos(p.y, -1 * p.x, p.z)
    } else { p }
  }
  def orangeRotation: Pos => Pos = { p =>
    if (p.z == -1) {
      Pos(-1 * p.y, p.x, p.z)
    } else { p }
  }

  val colorToRotationMap: Map[Color, Pos => Pos] = Map(
    Color.White -> whiteRotation,
    Color.Yellow -> yellowRotation,
    Color.Blue -> blueRotation,
    Color.Green -> greenRotation,
    Color.Red -> redRotation,
    Color.Orange -> orangeRotation
  )

}
