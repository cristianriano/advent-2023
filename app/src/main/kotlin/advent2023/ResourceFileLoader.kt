package advent2023

import java.io.File
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path

interface FileLoader {
  fun <T> useLines(filePath: String, block: (String) -> T): List<T>

  fun readLines(filePath: String): List<String>
}

class ResourceFileLoader: FileLoader {

  override fun <T> useLines(filePath: String, block: (String) -> T): List<T> {
    val file = File(resourceUrlOf(filePath).toURI())
    return file.useLines { it.map(block).toList() }
  }

  override fun readLines(filePath: String): List<String> = File(resourceUrlOf(filePath).toURI()).readLines()

  fun readAsString(filePath: String): String {
    val resource: URL = resourceUrlOf(filePath)
    return Files.readString(Path.of(resource.path))
  }

  private fun resourceUrlOf(filePath: String) = this::class.java.classLoader.getResource(filePath)!!
}