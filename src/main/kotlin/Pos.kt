@JvmInline
value class Pos(val pos: Long) {
    constructor(x: Int, y: Int) : this((x.toLong() shl 32) or (y.toLong() and 0xffffffffL))

    private val x: Int
        get() = (pos shr 32).toInt()
    private val y: Int
        get() = pos.toInt()

    operator fun plus(other: Pos) = Pos(this.x + other.x, this.y + other.y)
    override fun toString() = "[${this.x},${this.y}]"
}