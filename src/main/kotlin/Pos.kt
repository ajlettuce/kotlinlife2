
data class Pos(val x: Int, val y: Int) {
    operator fun plus(other: Pos) = Pos(this.x + other.x, this.y + other.y)
    override fun toString() = "[${this.x},${this.y}]"
}