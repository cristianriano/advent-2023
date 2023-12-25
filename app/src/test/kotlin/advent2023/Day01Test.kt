package advent2023

import advent2023.support.TestFileLoader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day01Test {

  private val mockedDay01 = Day01(TestFileLoader())
  private val instance = Day01()

  @Test
  fun `returns zero for empty`() {
    val calibrationSum = mockedDay01.getCalibrationSum("")
    assertThat(calibrationSum).isEqualTo(0)
  }

  @Test
  fun `returns 61 for oneLiner`() {
    val calibrationSum = mockedDay01.getCalibrationSum("aw611")
    assertThat(calibrationSum).isEqualTo(61)
  }

  @Test
  fun `returns value of example`() {
    val calibrationSum = instance.getCalibrationSum("day01.example")
    assertThat(calibrationSum).isEqualTo(142)
  }
}