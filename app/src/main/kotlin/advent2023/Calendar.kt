package advent2023

class Calendar {
  fun run() {
    printDay(1, Day01("day01").getCalibrationSum())
  }

  private fun <T> printDay(day: Int, result: T) {
    println("Result day $day: $result")
  }
}

fun main() {
  Calendar().run()
}
