package advent2023

import java.net.URL
import java.nio.file.Files
import java.nio.file.Path

object FileLoader {

  fun read(filePath: String): String {
    val resource: URL = this::class.java.classLoader.getResource(filePath)!!
    return Files.readString(Path.of(resource.path))
  }
}