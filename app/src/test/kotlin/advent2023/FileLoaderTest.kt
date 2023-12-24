package advent2023

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileLoaderTest {

  @Test
  fun `it returns doc text`() {
    val result = FileLoader.read("day01.example")

    val expected = """
      1abc2
      pqr3stu8vwx
      a1b2c3d4e5f
      treb7uchet
    """.trimIndent()

    assertThat(result).isEqualTo(expected)
  }
}