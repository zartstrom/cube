package cube

sealed trait Piece
case class CornerPiece(color1: Color, color2: Color, color3: Color) extends Piece
case class EdgePiece(color1: Color, color2: Color) extends Piece

case class CornerPosition(xColor: Color, yColor: Color, zColor: Color)
// case class CornerState(piece: CornerPiece, position: CornerPosition, xColor: Color, yColor: Color, zColor: Color)
// Maybe do not need corner piece..
case class CornerState(position: CornerPosition, xColor: Color, yColor: Color, zColor: Color)

case class EdgePosition(color1: Color, color2: Color)
case class EdgeState(position: EdgePosition, color1: Color, color2: Color)
