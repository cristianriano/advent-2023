package advent2023

class Calendar {
  fun run() {
    val day01 = Day01()
    printDay("1a", day01.getCalibrationSum("day01"))
    printDay("1b", day01.getCalibrationSumWithSpells("day01"))

    val day02 = Day02()
    printDay("2a", day02.possibleGamesSum("day02"))
    printDay("2b", day02.powerOfMinCubes("day02"))
  }

  private fun <T> printDay(day: String, result: T) {
    println("Result day $day: $result")
  }
}

fun main() {
  Calendar().run()
}
