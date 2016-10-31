package kotassert.tests

import kotassert.*
import org.junit.Test

class CollectionTest() {

    @Test
    fun isContainsTest() {

        val x1 = listOf(1, 2, 3, 4, 5)

        x1.IsContains(1, 2, 3, 4, 5)
        x1.IsNotContains(1, 2, 3, 4)

        x1.IsContainsInAnyOrder(5, 4, 3, 2, 1)
        x1.IsNotContainsInAnyOrder(4, 3, 2, 1)

    }

    @Test
    fun isEmptyTest() {

        val x1 = listOf<Int>()
        val x2 = listOf(1, 2, 3, 4, 5)

        x1.IsEmpty()
        x2.IsNotEmpty()

        x1.isEmpty().IsTrue()
        x2.isNotEmpty().IsTrue()

    }

    @Test
    fun hasItemTest() {

        val x1 = listOf(1, 2, 3, 4, 5)

        x1.HasItem(2)
        x1.HasNotItem(6)

    }

    @Test
    fun hasItemsTest() {

        val x1 = listOf(1, 2, 3, 4, 5)

        x1.HasItems(1, 3, 5)
        x1.HasNotItems(0, 6, 10)

    }

}
