class Life(alive: List<Pos>) {
    private var state = setOf<Pos>()
    var nextState = mutableSetOf<Pos>()

    init {
        state = alive.toSet()
    }

    fun nextGen() {
        nextState = mutableSetOf()
        val neighbors = mutableMapOf<Pos, Int>()

        state.forEach { pos ->
            for (x in -1..1) {
                for (y in -1..1) {
                    if (x == 0 && y == 0) continue
                    val neighbor = pos + Pos(x, y)
                    neighbors[neighbor] = neighbors.getOrDefault(neighbor, 0) + 1
                }
            }
        }

        for ((pos, num) in  neighbors) {
            if (num == 3 || (num == 2 && state.contains(pos)))
                nextState.add(pos)
        }
        state = nextState
    }
}