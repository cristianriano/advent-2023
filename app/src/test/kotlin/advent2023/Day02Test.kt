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
    val expectedSum = mockedDay.possibleGamesSum("Game 10: 1 red, 1 green, 1 blue")
    assertThat(expectedSum).isEqualTo(10)
  }

  @Test
  fun `it checks multiple draws of the same game`() {
    val expectedSum = mockedDay.possibleGamesSum("Game 1: 1 blue; 1 red; 1 green; 2 blue")
    assertThat(expectedSum).isEqualTo(0)
  }

  @Test
  fun `it returns 8 for example`() {
    val expectedSum = Day02().possibleGamesSum("day02.example")
    assertThat(expectedSum).isEqualTo(8)
  }

  @Test
  fun `it returns power of min cubes for a draw with all colors`() {
    val expectedSum = mockedDay.powerOfMinCubes("Game 1: 3 blue, 4 red, 1 green")
    assertThat(expectedSum).isEqualTo(12)
  }

  @Test
  fun `it returns power of min cubes for a draw with some colors`() {
    val expectedSum = mockedDay.powerOfMinCubes("Game 1: 3 blue")
    assertThat(expectedSum).isEqualTo(3)
  }

  @Test
  fun `it returns min cubes considering all draws`() {
    val expectedSum = mockedDay.powerOfMinCubes("Game 1: 10 blue, 10 red; 20 red, 10 green, 5 blue; 30 green")
    assertThat(expectedSum).isEqualTo(6000)
  }

  @Test
  fun `it returns 2286 for example B`() {
    val expectedSum = Day02().powerOfMinCubes("day02.example")
    assertThat(expectedSum).isEqualTo(2286)
  }
}