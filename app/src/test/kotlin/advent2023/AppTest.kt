package advent2023

import kotlin.test.Test
import kotlin.test.assertNotNull

class AppTest {
  @Test
  fun appHasAGreeting() {
    val classUnderTest = App()
    assertNotNull(classUnderTest.greeting, "app should have a greeting")
  }
}