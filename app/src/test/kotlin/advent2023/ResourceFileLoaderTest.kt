package advent2023

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResourceFileLoaderTest {

  private val fileLoader = ResourceFileLoader()

  @Test
  fun `it returns doc text`() {
    val result = fileLoader.readAsString(FILE_NAME)

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
    val results = fileLoader.useLines(FILE_NAME) { it.first() }

    assertThat(results).containsExactly(
        '1', 'p', 'a', 't'
    )
  }

  private companion object {
    const val FILE_NAME = "day01.example"
  }
}