package advent2023

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileLoaderTest {

  @Test
  fun `it returns doc text`() {
    val result = FileLoader.readAsString(FILE_NAME)

    val expected = """
      1abc2
      pqr3stu8vwx
      a1b2c3d4e5f
      treb7uchet
    """.trimIndent()

    assertThat(result).isEqualTo(expected)
  }

  @Test
  fun `it operates on each line`() {
    val results = FileLoader.readLines(FILE_NAME) { it.first() }

    assertThat(results).containsExactly(
        '1', 'p', 'a', 't'
    )
  }

  private companion object {
    const val FILE_NAME = "day01.example"
  }
}