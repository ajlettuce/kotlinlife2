class Life(var alive: MutableList<Pos>) {

    val nums = listOf(Pos(-1,-1),Pos(-1,0),Pos(-1,1),Pos(0,-1),Pos(0,1),Pos(1,-1),Pos(1,0),Pos(1,1))

    var state = mutableMapOf<Pos,Int>()
    var fstate = mutableMapOf<Pos,Int>()
    var falive = mutableListOf<Pos> ()
    init {
        for(i in alive)
            add2Neighbors(i,state)
    }

    private fun addToNeighbors(id : Pos, list : MutableMap<Pos,Int>) {
        for(i in nums) {
            val newPos = id + i
            list[newPos] = list[newPos]?.plus(1) ?: 1
        }
    }

    private fun add2Neighbors(id : Pos, list : MutableMap<Pos, Int>) {
        list[id + Pos(-1,-1)] = list[id + Pos(-1,-1)]?.plus(1) ?: 1
        list[id + Pos(-1,0)] = list[id + Pos(-1,0)]?.plus(1) ?: 1
        list[id + Pos(-1,1)] = list[id + Pos(-1,1)]?.plus(1) ?: 1
        list[id + Pos(0,-1)] = list[id + Pos(0,-1)]?.plus(1) ?: 1
        list[id + Pos(0,1)] = list[id + Pos(0,1)]?.plus(1) ?: 1
        list[id + Pos(1,-1)] = list[id + Pos(1,-1)]?.plus(1) ?: 1
        list[id + Pos(1,0)] = list[id + Pos(1,0)]?.plus(1) ?: 1
        list[id + Pos(1,1)] = list[id + Pos(1,1)]?.plus(1) ?: 1
    }

    fun nextGen() {
        for((k,v) in state) {
            if(v == 3){
                falive.add(k)
                add2Neighbors(k,fstate)
            } else if(alive.contains(k) && v == 2){
                falive.add(k)
                add2Neighbors(k,fstate)
            }
        }
        alive = falive.toMutableList()
        falive = mutableListOf()
        state = fstate.toMutableMap()
        fstate = mutableMapOf()
    }
}