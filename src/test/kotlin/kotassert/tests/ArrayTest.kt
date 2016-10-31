package kotassert.tests

import kotassert.*
import org.junit.Test

class ArrayTest() {

    @Test
    fun isContainsTest() {

        val x1 = arrayOf(1, 2, 3, 4, 5)
        val x2 = arrayOf(1, 2, 3, 4)
        val x3 = arrayOf(5, 4, 3, 2, 1)

        x1.IsContains(*(x3.reversedArray()))
        x1.IsNotContains(*x2)

        x1.IsContainsInAnyOrder(*x3)
        x1.IsNotContainsInAnyOrder(*x2)

    }

    @Test
    fun isEmptyTest() {

        val x1 = arrayOf<Int>()
        val x2 = arrayOf(1, 2, 3, 4, 5)

        x1.IsEmpty()
        x2.IsNotEmpty()

        x1.isEmpty().IsTrue()
        x2.isNotEmpty().IsTrue()

    }

    @Test
    fun hasItemTest() {

        val x1 = arrayOf(1, 2, 3, 4, 5)

        x1.HasItem(2)
        x1.HasNotItem(6)

    }

    @Test
    fun hasItemsTest() {

        val x1 = arrayOf(1, 2, 3, 4, 5)

        x1.HasItems(1, 3, 5)
        x1.HasNotItems(0, 6, 10)

    }

}
