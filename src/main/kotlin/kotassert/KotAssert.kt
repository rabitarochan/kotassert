package kotassert

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import org.junit.Assert

import kotlin.reflect.KClass

object KotAssert {

    inline fun <reified T : Throwable> throws(message: String = "", block: () -> Unit): T {
        var exception: Throwable? = null
        try {
            block()
        } catch (e: Throwable) {
            exception = e
        }

        if (exception == null) {
            Assert.fail("No exception was thrown. ${message}".trim())
        }

        assertThat(exception, `is`(instanceOf(T::class.java)))

        return exception as T
    }

    fun notThrow(message: String = "", block: () -> Unit) {
        try {
            block()
        } catch (e: Throwable) {
            Assert.fail("Failed notThrow. Catched:${e.javaClass.name} - ${e.message} ${message}".trim())
        }
    }


}

/** This same as : `assertThat(actual, is(expected))` */
fun <T> T.Is(expected: T, message: String = ""): T {
    assertThat(message, this, `is`(expected))
    return this
}

/** This same as : `assertThat(predicate(actual), is(true))` */
fun <T> T.Is(message: String = "", predicate: (T) -> Boolean): T {
    assertThat(message, predicate(this), `is`(true))
    return this
}

/** This same as : `assertThat(actual, is(not(expected)))` */
fun <T> T.IsNot(expected: T, message: String = ""): T {
    assertThat(message, this, `is`(not(expected)))
    return this
}

/** This same as : `assertThat(predicate(actual) is(false))` */
fun <T> T.IsNot(message: String = "", predicate: (T) -> Boolean): T {
    assertThat(message, predicate(this), `is`(false))
    return this
}

/** This same as : `assertThat(actual, `is`(true))` */
fun Boolean.IsTrue(message: String = ""): Boolean {
    assertThat(message, this, `is`(true))
    return this
}

/** This same as : `assertThat(actual, `is`(false))` */
fun Boolean.IsFalse(message: String = ""): Boolean {
    assertThat(message, this, `is`(false))
    return this
}

/** This same as : `assertThat(actual, is(nullValue()))` */
fun <T> T.IsNull(message: String = ""): T {
    assertThat(message, this, `is`(nullValue()))
    return this
}

/** This same as : `assertThat(actual, is(not(nullValue())))` */
fun <T> T.IsNotNull(message: String = ""): T {
    assertThat(message, this, `is`(not(nullValue())))
    return this
}

/** This same as : `assertThat(actual, `is`(comparesEqualTo(expected)))` */
fun <T : Comparable<T>> T.IsCompareTo(expected: T, message: String = ""): T {
    assertThat(message, this, `is`(comparesEqualTo(expected)))
    return this
}

/** This same as : `assertThat(actual, `is`(not(comparesEqualTo(expected))))` */
fun <T : Comparable<T>> T.IsNotCompareTo(expected: T, message: String = ""): T {
    assertThat(message, this, `is`(not(comparesEqualTo(expected))))
    return this
}

/** This same as : `assertThat(actual, is(sameInstance(expected)))` */
fun <T> T.IsSameInstance(expected: T, message: String = ""): T {
    assertThat(message, this, `is`(sameInstance(expected)))
    return this
}

/** This same as : `assertThat(actual, is(not(sameInstance(expected))))` */
fun <T> T.IsNotSameInstance(expected: T, message: String = ""): T {
    assertThat(message, this, `is`(not(sameInstance(expected))))
    return this
}

/** This same as : `assertThat(actual, is(instanceOf(Foo::class.java)))` */
fun <T> T.IsInstanceOf(kclass: KClass<*>, message: String = ""): T {
    assertThat(message, this, `is`(instanceOf(kclass.java)))
    return this
}

/** This same as : `assertThat(actual, is(not(instanceOf(Foo::class.java))))` */
fun <T> T.IsNotInstanceOf(kclass: KClass<*>, message: String = ""): T {
    assertThat(message, this, `is`(not(instanceOf(kclass.java))))
    return this
}

/** This same as : `assertThat(actual, isIn(items))` */
fun <T> T.IsIn(items: Array<T>, message: String = ""): T {
    assertThat(message, this, isIn(items))
    return this
}

/** This same as : `assertThat(actual, not(isIn(items)))` */
fun <T> T.IsNotIn(items: Array<T>, message: String = ""): T {
    assertThat(message, this, not(isIn(items)))
    return this
}

/** This same as : `assertThat(actual, isIn(items))` */
fun <T> T.IsIn(items: Collection<T>, message: String = ""): T {
    assertThat(message, this, isIn(items))
    return this
}

/** This same as : `assertThat(actual, not(isIn(items)))` */
fun <T> T.IsNotIn(items: Collection<T>, message: String = ""): T {
    assertThat(message, this, not(isIn(items)))
    return this
}

/** This same as : `assertThat(actual, isOneOf(*items))` */
fun <T> T.IsOneOf(vararg items: T, message: String = ""): T {
    assertThat(message, this, isOneOf(*items))
    return this
}

/** This same as : `assertThat(actual, not(isOneOf(*items)))` */
fun <T> T.IsNotOneOf(vararg items: T, message: String = ""): T {
    assertThat(message, this, not(isOneOf(*items)))
    return this
}


// kotlin.Array

/** This same as : `assertThat(actual, is(arrayContaining(*expected)))` */
fun <T> Array<T>.IsContains(vararg expected: T, message: String = ""): Array<T> {
    assertThat(message, this, `is`(arrayContaining(*expected)))
    return this
}

/** This same as : `assertThat(actual, is(not(arrayContaining(*expected))))` */
fun <T> Array<T>.IsNotContains(vararg expected: T, message: String = ""): Array<T> {
    assertThat(message, this, `is`(not(arrayContaining(*expected))))
    return this
}

/** This same as : `assertThat(actual, is(arrayContainingInAnyOrder(*expected)))` */
fun <T> Array<T>.IsContainsInAnyOrder(vararg expected: T, message: String = ""): Array<T> {
    assertThat(message, this, `is`(arrayContainingInAnyOrder(*expected)))
    return this
}

/** This same as : `assertThat(actual, is(not(arrayContainingInAnyOrder(*expected))))` */
fun <T> Array<T>.IsNotContainsInAnyOrder(vararg expected: T, message: String = ""): Array<T> {
    assertThat(message, this, `is`(not(arrayContainingInAnyOrder(*expected))))
    return this
}

/** This same as : `assertThat(actual, is(emptyArray())` */
fun <T> Array<T>.IsEmpty(message: String = ""): Array<T> {
    assertThat(message, this, `is`(emptyArray()))
    return this
}

/** This same as : `assertThat(actual, is(not(emptyArray()))` */
fun <T> Array<T>.IsNotEmpty(message: String = ""): Array<T> {
    assertThat(message, this, `is`(not(emptyArray())))
    return this
}

/** This same as : `assertThat(actual, hasItemInArray(item))` */
fun <T> Array<T>.HasItem(item: T, message: String = ""): Array<T> {
    assertThat(message, this, hasItemInArray(item))
    return this
}

/** This same as : `assertThat(actual, not(hasItemInArray(item)))` */
fun <T> Array<T>.HasNotItem(item: T, message: String = ""): Array<T> {
    assertThat(message, this, not(hasItemInArray(item)))
    return this
}

/** This same as : `items.forEach { item -> assertThat(actual, hasItemInArray(item)) }` */
fun <T> Array<T>.HasItems(vararg items: T, message: String = ""): Array<T> {
    items.forEach { item -> assertThat(message, this, hasItemInArray(item)) }
    return this
}

/** This same as : `items.forEach { item -> assertThat(actual, not(hasItemInArray(item))) }` */
fun <T> Array<T>.HasNotItems(vararg items: T, message: String = ""): Array<T> {
    items.forEach { item -> assertThat(message, this, not(hasItemInArray(item))) }
    return this
}


// kotlin.collections.Collection

/** This same as : `assertThat(actual, is(contains(*expected)))` */
fun <T, C : Collection<T>> C.IsContains(vararg expected: T, message: String = ""): C {
    assertThat(message, this, `is`(contains(*expected)))
    return this
}

/** This same as : `assertThat(actual, is(not(contains(*expected))))` */
fun <T, C : Collection<T>> C.IsNotContains(vararg expected: T, message: String = ""): C {
    assertThat(message, this, `is`(not(contains(*expected))))
    return this
}

/** This same as : `assertThat(actual, is(containsInAnyOrder(*expected)))` */
fun <T, C : Collection<T>> C.IsContainsInAnyOrder(vararg expected: T, message: String = ""): C {
    assertThat(message, this, `is`(containsInAnyOrder(*expected)))
    return this
}

/** This same as : `assertThat(actual, is(not(containsInAnyOrder(*expected))))` */
fun <T, C : Collection<T>> C.IsNotContainsInAnyOrder(vararg expected: T, message: String = ""): C {
    assertThat(message, this, `is`(not(containsInAnyOrder(*expected))))
    return this
}

/** This same as : `assertThat(actual, is(empty<T>()))` */
fun <T, C : Collection<T>> C.IsEmpty(message: String = ""): C {
    assertThat(message, this, `is`(empty<T>()))
    return this
}

/** This same as : `assertThat(actual, is(not(empty<T>())))` */
fun <T, C : Collection<T>> C.IsNotEmpty(message: String = ""): C {
    assertThat(message, this, `is`(not(empty<T>())))
    return this
}

/** This same as : `assertThat(actual, hasItem(item))` */
fun <T, C : Collection<T>> C.HasItem(item: T, message: String = ""): C {
    assertThat(message, this, hasItem(item))
    return this
}

/** This same as : `assertThat(actual, not(hasItem(item)))` */
fun <T, C : Collection<T>> C.HasNotItem(item: T, message: String = ""): C {
    assertThat(message, this, not(hasItem(item)))
    return this
}

/** This same as : `assertThat(actual, hasItems(items))` */
fun <T, C : Collection<T>> C.HasItems(vararg items: T, message: String = ""): C {
    assertThat(message, this, hasItems(*items))
    return this
}

/** This same as : `assertThat(actual, not(hasItems(items)))` */
fun <T, C : Collection<T>> C.HasNotItems(vararg items: T, message: String = ""): C {
    assertThat(message, this, not(hasItems(*items)))
    return this
}


// kotlin.collections.Map

/** This same as : `assertThat(actual, hasEntry(key, value))` */
fun <K, V> Map<K, V>.HasEntry(key: K, value: V, message: String = ""): Map<K, V> {
    assertThat(message, this, hasEntry(key, value))
    return this
}

/** This same as : `assertThat(actual, hasEntry(key, value))` */
fun <K, V> Map<K, V>.HasNotEntry(key: K, value: V, message: String = ""): Map<K, V> {
    assertThat(message, this, not(hasEntry(key, value)))
    return this
}

/** This same as : `assertThat(actual, hasKey(key))` */
fun <K, V> Map<K, V>.HasKey(key: K, message: String = ""): Map<K, V> {
    assertThat(message, this, hasKey(key))
    return this
}

/** This same as : `assertThat(actual, not(hasKey(key)))` */
fun <K, V> Map<K, V>.HasNotKey(key: K, message: String = ""): Map<K, V> {
    assertThat(message, this, not(hasKey(key)))
    return this
}

/** This same as : `assertThat(actual, hasValue(value))` */
fun <K, V> Map<K, V>.HasValue(value: V, message: String = ""): Map<K, V> {
    assertThat(message, this, hasValue(value))
    return this
}

/** This same as : `assertThat(actual, not(hasValue(value)))` */
fun <K, V> Map<K, V>.HasNotValue(value: V, message: String = ""): Map<K, V> {
    assertThat(message, this, not(hasValue(value)))
    return this
}


// property

/** This same as : `assertThat(actual, samePropertyValuesAs(expected))` */
fun <T> T.IsSamePropertyValueAs(expected: T, message: String = ""): T {
    assertThat(message, this, samePropertyValuesAs(expected))
    return this
}

/** This same as : `assertThat(actual, not(samePropertyValuesAs(expected)))` */
fun <T> T.IsNotSamePropertyValueAs(expected: T, message: String = ""): T {
    assertThat(message, this, not(samePropertyValuesAs(expected)))
    return this
}
