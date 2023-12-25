package advent2023

/*
On each line, the calibration value can be found by combining the first digit and the last digit (in that order) to form a single two-digit number.

For example:

1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet
In this example, the calibration values of these four lines are 12, 38, 15, and 77. Adding these together produces 142.

Consider your entire calibration document. What is the sum of all the calibration values?
 */
class Day01(private val fileLoader: FileLoader = ResourceFileLoader()) {

  fun getCalibrationSum(calibrationPath: String) = fileLoader.useLines(calibrationPath) { calibrationValueOf(it) }.sum()

  fun getFixedSum(calibrationPath: String) : Int {
    val line = fileLoader.readLines(calibrationPath).first()

    TODO()
  }

  private fun calibrationValueOf(line: String): Int {
    val tens = line.first { it.isDigit() }.digitToInt()
    val units = line.last { it.isDigit() }.digitToInt()
    return (tens * 10) + units
  }

  private companion object {
    val SPELLED_DIGIT_REGEX = Regex("one|two|three|four|five|six|seven|eight|nine")
  }
}