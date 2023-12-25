package advent2023.support

import advent2023.FileLoader

class TestFileLoader: FileLoader {
  override fun <T> useLines(filePath: String, block: (String) -> T) = readLines(filePath).map(block)

  override fun readLines(filePath: String) = when {
    filePath.isBlank() -> emptyList()
    else -> filePath.split("\n")
  }
}