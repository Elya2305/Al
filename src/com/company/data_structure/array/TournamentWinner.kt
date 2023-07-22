package com.company.data_structure.array



fun main() {
    val competitions = listOf(
        listOf("HTML", "C#"),
//        listOf("C#", "Python"),
//        listOf("Python", "HTML")
    )

    val results = listOf(0)

    println("Winner:")
    println(tournamentWinner(competitions, results))
}

// time O(n)
// space O(k)
// n: number of competitions, k: number of teams
fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    val teamScore = HashMap<String, Int>()
    competitions.forEachIndexed { index, round ->
        run {
            val winner = if (results[index] == 1) {
                round[0]
            } else {
                round[1]
            }
            teamScore[winner] = teamScore.getOrDefault(winner, 0) + 3
        }
    }

    var winner = ""
    var maxScore = 0
    teamScore.forEach { (team, score) ->
        run {
            if (score > maxScore) {
                winner = team
                maxScore = score
            }
        }
    }
    return winner
}

