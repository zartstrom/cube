package cube

final case class T(name: String, transformation: CubeState => CubeState)
    extends (CubeState => CubeState) {
  def apply(cubeState: CubeState): CubeState = transformation(cubeState)

  override def toString: String = this.name
}
