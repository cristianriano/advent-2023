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

  fun getCalibrationSumWithSpells(calibrationPath: String) =
      fileLoader.useLines(calibrationPath) { processLine(it) }.sum()

  private fun processLine(line: String) = when (val finds = SPELLED_DIGIT_REGEX.findAll(line).toList()) {
    emptyList<MatchResult>() -> calibrationValueOf(line)
    else -> calibrationValueWithSpellsOf(finds, line)
  }

  private fun calibrationValueOf(line: String): Int {
    val matches = DIGIT_REGEX.findAll(line).toList()
    return (matches.first().value.toInt() * 10) + matches.last().value.toInt()
  }

  private fun calibrationValueWithSpellsOf(spellMatches: List<MatchResult>, line: String): Int {
    val digitMatches = DIGIT_REGEX.findAll(line).toList()

    val tens = when {
      digitMatches.isEmpty() -> spellMatches.first().groups.last()!!.value.toSpelledDigit()
      spellMatches.first().range.first < digitMatches.first().range.first -> spellMatches.first().groups.last()!!.value.toSpelledDigit()
      else -> digitMatches.first().value.toInt()
    }

    val units = when {
      digitMatches.isEmpty() -> spellMatches.last().groups.last()!!.value.toSpelledDigit()
      spellMatches.last().range.last >= digitMatches.last().range.last -> spellMatches.last().groups.last()!!.value.toSpelledDigit()
      else -> digitMatches.last().value.toInt()
    }

    return (tens * 10) + units
  }

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
    val DIGIT_REGEX = Regex("[1-9]")
    val SPELLED_DIGIT_REGEX = Regex("(?=(one|two|three|four|five|six|seven|eight|nine))")
  }
}
