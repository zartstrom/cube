package cube

case class Pos(x: Int, y: Int, z: Int)

object Pos {

  val RUF = Pos(1, 1, 1)
  val LUF = Pos(-1, 1, 1)
  val LUB = Pos(-1, 1, -1)
  val RUB = Pos(1, 1, -1)
  val RDB = Pos(1, -1, -1)
  val RDF = Pos(1, -1, 1)
  val LDF = Pos(-1, -1, 1)
  val LDB = Pos(-1, -1, -1)

  val E__UF = Pos(0, 1, 1)
  val E_LU_ = Pos(-1, 1, 0)
  val E__UB = Pos(0, 1, -1)
  val E_RU_ = Pos(1, 1, 0)

  val E__DF = Pos(0, -1, 1)
  val E_LD_ = Pos(-1, -1, 0)
  val E__DB = Pos(0, -1, -1)
  val E_RD_ = Pos(1, -1, 0)

  val E_R_F = Pos(1, 0, 1)
  val E_L_F = Pos(-1, 0, 1)
  val E_L_B = Pos(-1, 0, -1)
  val E_R_B = Pos(1, 0, -1)

  val whitePositions: Seq[Pos] = Seq(RUF, LUF, LUB, RUB, E__UF, E_LU_, E__UB, E_RU_)
  val yellowPositions: Seq[Pos] = Seq(RDF, LDF, LDB, RDB, E__DF, E_LD_, E__DB, E_RD_)
  val bluePositions: Seq[Pos] = Seq(RUF, E_RU_, RUB, E_R_B, RDB, E_RD_, RDF, E_R_F)
  val greenPositions: Seq[Pos] = Seq(LUF, E_LU_, LUB, E_L_B, LDB, E_LD_, LDF, E_L_F)
  val redPositions: Seq[Pos] = Seq(RUF, LUF, RDF, LDF, E_R_F, E_L_F, E__UF, E__DF)
  val orangePositions: Seq[Pos] = Seq(RUB, LUB, RDB, LDB, E_R_B, E_L_B, E__UB, E__DB)

  val colorToPositionsMap: Map[Color, Seq[Pos]] = Map(
    Color.White -> whitePositions,
    Color.Yellow -> yellowPositions,
    Color.Blue -> bluePositions,
    Color.Green -> greenPositions,
    Color.Red -> redPositions,
    Color.Orange -> orangePositions
  )
}
