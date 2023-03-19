class Life(var alive: List<Pos>) {
    private var state = mapOf<Pos, Int>()
    private var fstate = mutableMapOf<Pos, Int>()
    private var falive = mutableListOf<Pos>()

    init {
        val s = mutableMapOf<Pos, Int>()
        for (i in alive)
            add2Neighbors(i, s)
        state = s
    }


    private fun add2Neighbors(id: Pos, list: MutableMap<Pos, Int>) { //way more efficient lol
        list[id + Pos(-1, -1)] = list[id + Pos(-1, -1)]?.plus(1) ?: 1
        list[id + Pos(-1, 0)] = list[id + Pos(-1, 0)]?.plus(1) ?: 1
        list[id + Pos(-1, 1)] = list[id + Pos(-1, 1)]?.plus(1) ?: 1
        list[id + Pos(0, -1)] = list[id + Pos(0, -1)]?.plus(1) ?: 1
        list[id + Pos(0, 1)] = list[id + Pos(0, 1)]?.plus(1) ?: 1
        list[id + Pos(1, -1)] = list[id + Pos(1, -1)]?.plus(1) ?: 1
        list[id + Pos(1, 0)] = list[id + Pos(1, 0)]?.plus(1) ?: 1
        list[id + Pos(1, 1)] = list[id + Pos(1, 1)]?.plus(1) ?: 1
    }

    fun nextGen() {
        for ((k, v) in state) {
            if (v == 3) {
                falive.add(k)
                add2Neighbors(k, fstate)
            } else if (v == 2 && alive.contains(k)) {
                falive.add(k)
                add2Neighbors(k, fstate)
            }
        }
        //tested, this is the most efficient:
        alive = falive
        falive = mutableListOf()
        state = fstate
        fstate = mutableMapOf()
    }
}