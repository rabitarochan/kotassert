package kotassert.tests

import kotassert.KotAssert
import kotassert.Is

import org.junit.Test

class ExceptionTest() {

    @Test
    fun throwsTest() {

        KotAssert.throws<NotImplementedError> {
            TODO()
        }

        KotAssert.throws<Throwable> {
            throw RuntimeException("foobar")
        }.let {
            it.message!!.Is { it.startsWith("foo") && it.endsWith("bar") }
        }

        KotAssert.throws<AssertionError> {
            KotAssert.throws<NotImplementedError> {
                // not thrown
                1 + 1
            }
        }

    }

    @Test
    fun notThrowTest() {

        KotAssert.notThrow {
            // not throw
            1 + 1
        }

        KotAssert.throws<AssertionError> {
            KotAssert.notThrow {
                TODO()
            }
        }

    }

}
