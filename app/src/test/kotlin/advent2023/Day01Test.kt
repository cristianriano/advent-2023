package advent2023

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day01Test {

  @Test
  fun `returns cero for empty`() {
    val calibrationSum = Day01("empty.example").getCalibrationSum()
    assertThat(calibrationSum).isEqualTo(0)
  }

  @Test
  fun `returns 12 for oneLiner`() {
    val calibrationSum = Day01("oneLine.example").getCalibrationSum()
    assertThat(calibrationSum).isEqualTo(12)
  }

  @Test
  fun `returns value of example`() {
    val calibrationSum = Day01("day01.example").getCalibrationSum()
    assertThat(calibrationSum).isEqualTo(142)
  }
}