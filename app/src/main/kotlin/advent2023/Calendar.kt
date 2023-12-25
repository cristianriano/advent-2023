package advent2023

class Calendar {
  fun run() {
    val day01 = Day01()
    printDay(1, day01.getCalibrationSum("day01"))
    printDay(1, day01.getCalibrationSumWithSpells("day01"))
  }

  private fun <T> printDay(day: Int, result: T) {
    println("Result day $day: $result")
  }
}

fun main() {
  Calendar().run()
}
