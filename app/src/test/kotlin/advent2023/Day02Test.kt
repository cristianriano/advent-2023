package advent2023

import advent2023.support.TestFileLoader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day02Test {

  private val mockedDay = Day02(TestFileLoader(), 1, 1, 1)

  @Test
  fun `it doesn't count impossible game with a single draw of blue`() {
    val expectedSum = mockedDay.possibleGamesSum("Game 1: 2 blue")
    assertThat(expectedSum).isEqualTo(0)
  }

  @Test
  fun `it doesn't count impossible game with a single draw of red`() {
    val expectedSum = mockedDay.possibleGamesSum("Game 1: 2 red")
    assertThat(expectedSum).isEqualTo(0)
  }

  @Test
  fun `it doesn't count impossible game with a single draw of green`() {
    val expectedSum = mockedDay.possibleGamesSum("Game 1: 2 green")
    assertThat(expectedSum).isEqualTo(0)
  }

  @Test
  fun `it returns game num for valid game with all colors`() {
    val expectedSum = mockedDay.possibleGamesSum("Game 3: 1 red, 1 green, 1 blue")
    assertThat(expectedSum).isEqualTo(3)
  }

  @Test
  fun `it checks multiple draws of the same game`() {
    val expectedSum = mockedDay.possibleGamesSum("Game 1: 1 blue; 1 red; 1 green; 2 blue")
    assertThat(expectedSum).isEqualTo(0)
  }
}