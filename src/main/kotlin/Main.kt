import Life
import Pos
import kotlin.system.measureTimeMillis

fun main() {
//    var alive = mutableListOf(Pos(-1,0),Pos(0,0),Pos(1,0),Pos(1,1),Pos(0,2))
    var alive = mutableListOf(Pos(0,0),Pos(1,0),Pos(1,2),Pos(3,1),Pos(4,0),Pos(5,0),Pos(6,0))
    var game = Life(alive)
    println(game.alive)
    var t1 = System.currentTimeMillis()
    for(i in 0..5206) {
        println("gen $i")
        game.nextGen()
    }
    println("Completed in ${(System.currentTimeMillis() - t1)/1000f} seconds")
    println("population ${game.getPopulation()}")
} 