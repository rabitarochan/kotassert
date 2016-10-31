package kotassert.tests

import kotassert.*
import org.junit.Test

class MapTest() {

    val actual: Map<Int, String> = mapOf(
            1 to "one",
            2 to "two",
            3 to "three",
            4 to "four",
            5 to "five"
    )

    @Test
    fun hasEntryTest() {

        actual.HasEntry(1, "one")
        actual.HasNotEntry(6, "six")
        actual.HasNotEntry(2, "three")

    }

    @Test
    fun hasKeyTest() {

        actual.HasKey(1)
        actual.HasNotKey(0)

    }

    @Test
    fun hasValueTest() {

        actual.HasValue("four")
        actual.HasNotValue("zero")

    }

}
