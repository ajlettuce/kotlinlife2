import java.util.concurrent.ConcurrentHashMap

class Life(alive: List<Pos>) {
    var currentState = mutableSetOf<Pos>()
    var lastState = setOf<Pos>()

    init {
        lastState = alive.toSet()
    }

    fun nextGen() {
        currentState.clear()

        val neighbors = ConcurrentHashMap<Pos, Int>()
        lastState.forEach { pos ->
            for (x in -1..1) {
                for (y in -1..1) {
                    if (x == 0 && y == 0) continue
                    val neighbor = pos + Pos(x, y)
                    neighbors[neighbor] = neighbors.getOrDefault(neighbor, 0) + 1
                }
            }
        }

        for ((pos, num) in  neighbors) {
            if (num == 3 || (num == 2 && lastState.contains(pos)))
                currentState.add(pos)
        }

        lastState = currentState.toSet()
    }
}