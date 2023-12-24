package advent2023

import java.io.File
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path

object FileLoader {

  fun readAsString(filePath: String): String {
    val resource: URL = resourceUrlOf(filePath)
    return Files.readString(Path.of(resource.path))
  }

  fun <T> readLines(filePath: String, block: (String) -> T): List<T> {
    val file = File(resourceUrlOf(filePath).toURI())
    return file.useLines { it.map(block).toList() }
  }

  private fun resourceUrlOf(filePath: String) = this::class.java.classLoader.getResource(filePath)!!
}