package cube

enum Color:
  case Red, Green, Blue, Orange, White, Yellow

object Color:
  val charToColorMap: Map[Char, Color] = Map(
    'W' -> Color.White,
    'Y' -> Color.Yellow,
    'B' -> Color.Blue,
    'G' -> Color.Green,
    'R' -> Color.Red,
    'O' -> Color.Orange
  )
