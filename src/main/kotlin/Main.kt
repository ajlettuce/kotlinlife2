fun main() {
    val alive = mutableListOf(Pos(0, 0), Pos(1, 0), Pos(1, 2), Pos(3, 1), Pos(4, 0), Pos(5, 0), Pos(6, 0))
    val game = Life(alive)
    val t1 = System.currentTimeMillis()
    for (i in 0..5206) {
        game.nextGen()
    }
    println("Completed in ${(System.currentTimeMillis() - t1) / 1000f} seconds")
    println("population ${game.nextState.size}")
} 