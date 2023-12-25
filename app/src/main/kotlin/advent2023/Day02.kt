package advent2023

/*
The Elf would first like to know which games would have been possible if the bag contained only 12 red cubes, 13 green cubes, and 14 blue cubes?

Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green

If you add up the IDs of the games that would have been possible, you get 8.

In each game you played, what is the fewest number of cubes of each color that could have been in the bag to make the game possible?
The power of a set of cubes is equal to the numbers of red, green, and blue cubes multiplied together.
The power of the minimum set of cubes in game 1 is 48. In games 2-5 it was 12, 1560, 630, and 36, respectively. Adding up these five powers produces the sum 2286.
 */
class Day02(
  private val fileLoader: FileLoader = ResourceFileLoader(),
  private val maxRed: Int = 12,
  private val maxGreen: Int = 13,
  private val maxBlue: Int = 14
) {

  fun possibleGamesSum(filePath: String): Int {
    return fileLoader.useLines(filePath) { processLine(it) }.sum()
  }

  fun powerOfMinCubes(filePath: String): Int {
    return fileLoader.useLines(filePath) { powerOf(it) }.sum()
  }

  private fun powerOf(line: String): Int {
    val draws = line.split(";")

    val maxGreen = draws.maxOf { extractNum(it, GREEN_REGEX, 1) }
    val maxRed = draws.maxOf { extractNum(it, RED_REGEX, 1) }
    val maxBlue = draws.maxOf { extractNum(it, BLUE_REGEX, 1) }

    return maxGreen * maxRed * maxBlue
  }

  private fun processLine(line: String): Int {
    val isInvalidGame = line.split(";").any { isInvalidDraw(it) }
    return if (isInvalidGame) 0 else extractNum(line, GAME_REGEX)
  }

  private fun isInvalidDraw(draw: String): Boolean {
    val drawnBlue = extractNum(draw, BLUE_REGEX)
    val drawnRed = extractNum(draw, RED_REGEX)
    val drawnGreen = extractNum(draw, GREEN_REGEX)

    return drawnBlue > maxBlue || drawnRed > maxRed || drawnGreen > maxGreen
  }

  private fun extractNum(line: String, regex: Regex, default: Int = 0) = runCatching {
    regex.find(line)!!.groups.last()!!.value.toInt()
  }.getOrElse { default }

  private companion object {
    val GAME_REGEX = Regex("Game (\\d+):")

    val BLUE_REGEX = Regex("(\\d+) blue")
    val RED_REGEX = Regex("(\\d+) red")
    val GREEN_REGEX = Regex("(\\d+) green")
  }
}