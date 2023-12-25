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

PART 2
It looks like some of the digits are actually spelled out with letters: one, two, three, four, five, six, seven, eight, and nine also count as valid "digits".
For example:

two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen

In this example, the calibration values are 29, 83, 13, 24, 42, 14, and 76. Adding these together produces 281.
 */
class Day01(private val fileLoader: FileLoader = ResourceFileLoader()) {

  fun getCalibrationSum(calibrationPath: String) = fileLoader.useLines(calibrationPath) { calibrationValueOf(it) }.sum()

  fun getCalibrationSumWithSpells(calibrationPath: String) : Int {
    val line = fileLoader.readLines(calibrationPath).first()

    return when (val finds = SPELLED_DIGIT_REGEX.find(line)) {
      null -> calibrationValueOf(line)
      else -> calibrationValueWithSpellsOf(finds, line)
    }
  }

  private fun calibrationValueOf(line: String) = (firstDigitMatch(line).value.toInt() * 10) + lastDigitMatch(line).value.toInt()

  private fun calibrationValueWithSpellsOf(finds: MatchResult, line: String): Int {
    val firstMatchGroup = finds.groups.first()!!
    val firstDigitMatch = firstDigitMatch(line)

    val units = if (firstMatchGroup.range.first < firstDigitMatch.range.first()) {
      firstMatchGroup.value.toSpelledDigit()
    } else {
      firstDigitMatch.value.toInt()
    }

    return (units * 10) + lastDigitMatch(line).value.toInt()
  }

  private fun firstDigitMatch(line: String) = DIGIT_REGEX.find(line)!!.groups.first()!!

  private fun lastDigitMatch(line: String) = DIGIT_REGEX.findAll(line).toList().last()

  private fun String.toSpelledDigit() = when(this) {
    "one" -> 1
    "two" -> 2
    "three" -> 3
    "four" -> 4
    "five" -> 5
    "six" -> 6
    "seven" -> 7
    "eight" -> 8
    "nine" -> 9
    else -> throw NoSuchElementException("$this is not a valid digit")
  }

  private companion object {
    val DIGIT_REGEX = Regex("\\d")
    val SPELLED_DIGIT_REGEX = Regex("one|two|three|four|five|six|seven|eight|nine")
  }
}
