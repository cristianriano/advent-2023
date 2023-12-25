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
}