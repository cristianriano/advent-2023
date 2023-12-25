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

  @Test
  fun `when it starts with a spelled number`() {
    val calibrationSum = mockedDay01.getCalibrationSumWithSpells("two65eightbkgqcsn91qxkfvg")
    assertThat(calibrationSum).isEqualTo(21)
  }

  @Test
  fun `when it has a spelled number but a number first`() {
    val calibrationSum = mockedDay01.getCalibrationSumWithSpells("65twosn91qxk")
    assertThat(calibrationSum).isEqualTo(61)
  }

  @Test
  fun `when it has a spelled number last`() {
    val calibrationSum = mockedDay01.getCalibrationSumWithSpells("65twosn91four")
    assertThat(calibrationSum).isEqualTo(64)
  }

  @Test
  fun `when it has both spelled`() {
    val calibrationSum = mockedDay01.getCalibrationSumWithSpells("awfive678ninep")
    assertThat(calibrationSum).isEqualTo(59)
  }

  @Test
  fun `when it has both spelled and no digits`() {
    val calibrationSum = mockedDay01.getCalibrationSumWithSpells("aweightthreep")
    assertThat(calibrationSum).isEqualTo(83)
  }

  @Test
  fun `when it has only digits`() {
    val calibrationSum = mockedDay01.getCalibrationSumWithSpells("43asdew")
    assertThat(calibrationSum).isEqualTo(43)
  }

  @Test
  fun `it calculates example with spells`() {
    val calibrationSum = instance.getCalibrationSumWithSpells("day01.2.example")
    assertThat(calibrationSum).isEqualTo(281)
  }

  @Test
  fun `when spelling overlaps`() {
    val calibrationSum = mockedDay01.getCalibrationSumWithSpells("oneight")
    assertThat(calibrationSum).isEqualTo(18)
  }
}