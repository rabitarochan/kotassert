package kotassert

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import org.junit.Assert

import kotlin.reflect.KClass

object KotAssert {

    inline fun <reified T : Throwable> throws(block: () -> Unit): T {
        var exception: Throwable? = null
        try {
            block()
        } catch (e: Throwable) {
            exception = e
        }

        if (exception == null) {
            Assert.fail("No exception was thrown.")
        }

        assertThat(exception, `is`(instanceOf(T::class.java)))

        return exception as T
    }

    fun notThrow(block: () -> Unit) {
        try {
            block()
        } catch (e: Throwable) {
            Assert.fail("Failed notThrow. Catched:${e.javaClass.name} - ${e.message}")
        }
    }


}

/** This same as : `assertThat(actual, is(expected))` */
fun <T> T.Is(expected: T): T {
    assertThat(this, `is`(expected))
    return this
}

/** This same as : `assertThat(predicate(actual), is(true))` */
fun <T> T.Is(predicate: (T) -> Boolean): T {
    assertThat(predicate(this), `is`(true))
    return this
}

/** This same as : `assertThat(actual, is(not(expected)))` */
fun <T> T.IsNot(expected: T): T {
    assertThat(this, `is`(not(expected)))
    return this
}

/** This same as : `assertThat(predicate(actual) is(false))` */
fun <T> T.IsNot(predicate: (T) -> Boolean): T {
    assertThat(predicate(this), `is`(false))
    return this
}

/** This same as : `assertThat(actual, `is`(true))` */
fun Boolean.IsTrue(): Boolean {
    assertThat(this, `is`(true))
    return this
}

/** This same as : `assertThat(actual, `is`(false))` */
fun Boolean.IsFalse(): Boolean {
    assertThat(this, `is`(false))
    return this
}

/** This same as : `assertThat(actual, is(nullValue()))` */
fun <T> T.IsNull(): T {
    assertThat(this, `is`(nullValue()))
    return this
}

/** This same as : `assertThat(actual, is(not(nullValue())))` */
fun <T> T.IsNotNull(): T {
    assertThat(this, `is`(not(nullValue())))
    return this
}

/** This same as : `assertThat(actual, `is`(comparesEqualTo(expected)))` */
fun <T : Comparable<T>> T.IsCompareTo(expected: T): T {
    assertThat(this, `is`(comparesEqualTo(expected)))
    return this
}

/** This same as : `assertThat(actual, `is`(not(comparesEqualTo(expected))))` */
fun <T : Comparable<T>> T.IsNotCompareTo(expected: T): T {
    assertThat(this, `is`(not(comparesEqualTo(expected))))
    return this
}

/** This same as : `assertThat(actual, is(sameInstance(expected)))` */
fun <T> T.IsSameInstance(expected: T): T {
    assertThat(this, `is`(sameInstance(expected)))
    return this
}

/** This same as : `assertThat(actual, is(not(sameInstance(expected))))` */
fun <T> T.IsNotSameInstance(expected: T): T {
    assertThat(this, `is`(not(sameInstance(expected))))
    return this
}

/** This same as : `assertThat(actual, is(instanceOf(Foo::class.java)))` */
fun <T> T.IsInstanceOf(kclass: KClass<*>): T {
    assertThat(this, `is`(instanceOf(kclass.java)))
    return this
}

/** This same as : `assertThat(actual, is(not(instanceOf(Foo::class.java))))` */
fun <T> T.IsNotInstanceOf(kclass: KClass<*>): T {
    assertThat(this, `is`(not(instanceOf(kclass.java))))
    return this
}

/** This same as : `assertThat(actual, isIn(items))` */
fun <T> T.IsIn(items: Array<T>): T {
    assertThat(this, isIn(items))
    return this
}

/** This same as : `assertThat(actual, not(isIn(items)))` */
fun <T> T.IsNotIn(items: Array<T>): T {
    assertThat(this, not(isIn(items)))
    return this
}

/** This same as : `assertThat(actual, isIn(items))` */
fun <T> T.IsIn(items: Collection<T>): T {
    assertThat(this, isIn(items))
    return this
}

/** This same as : `assertThat(actual, not(isIn(items)))` */
fun <T> T.IsNotIn(items: Collection<T>): T {
    assertThat(this, not(isIn(items)))
    return this
}

/** This same as : `assertThat(actual, isOneOf(*items))` */
fun <T> T.IsOneOf(vararg items: T): T {
    assertThat(this, isOneOf(*items))
    return this
}

/** This same as : `assertThat(actual, not(isOneOf(*items)))` */
fun <T> T.IsNotOneOf(vararg items: T): T {
    assertThat(this, not(isOneOf(*items)))
    return this
}


// kotlin.Array

/** This same as : `assertThat(actual, is(arrayContaining(*expected)))` */
fun <T> Array<T>.IsContains(vararg expected: T): Array<T> {
    assertThat(this, `is`(arrayContaining(*expected)))
    return this
}

/** This same as : `assertThat(actual, is(not(arrayContaining(*expected))))` */
fun <T> Array<T>.IsNotContains(vararg expected: T): Array<T> {
    assertThat(this, `is`(not(arrayContaining(*expected))))
    return this
}

/** This same as : `assertThat(actual, is(arrayContainingInAnyOrder(*expected)))` */
fun <T> Array<T>.IsContainsInAnyOrder(vararg expected: T): Array<T> {
    assertThat(this, `is`(arrayContainingInAnyOrder(*expected)))
    return this
}

/** This same as : `assertThat(actual, is(not(arrayContainingInAnyOrder(*expected))))` */
fun <T> Array<T>.IsNotContainsInAnyOrder(vararg expected: T): Array<T> {
    assertThat(this, `is`(not(arrayContainingInAnyOrder(*expected))))
    return this
}

/** This same as : `assertThat(actual, is(emptyArray())` */
fun <T> Array<T>.IsEmpty(): Array<T> {
    assertThat(this, `is`(emptyArray()))
    return this
}

/** This same as : `assertThat(actual, is(not(emptyArray()))` */
fun <T> Array<T>.IsNotEmpty(): Array<T> {
    assertThat(this, `is`(not(emptyArray())))
    return this
}

/** This same as : `assertThat(actual, hasItemInArray(item))` */
fun <T> Array<T>.HasItem(item: T): Array<T> {
    assertThat(this, hasItemInArray(item))
    return this
}

/** This same as : `assertThat(actual, not(hasItemInArray(item)))` */
fun <T> Array<T>.HasNotItem(item: T): Array<T> {
    assertThat(this, not(hasItemInArray(item)))
    return this
}

/** This same as : `items.forEach { item -> assertThat(actual, hasItemInArray(item)) }` */
fun <T> Array<T>.HasItems(vararg items: T): Array<T> {
    items.forEach { item -> assertThat(this, hasItemInArray(item)) }
    return this
}

/** This same as : `items.forEach { item -> assertThat(actual, not(hasItemInArray(item))) }` */
fun <T> Array<T>.HasNotItems(vararg items: T): Array<T> {
    items.forEach { item -> assertThat(this, not(hasItemInArray(item))) }
    return this
}


// kotlin.collections.Collection

/** This same as : `assertThat(actual, is(contains(*expected)))` */
fun <T, C : Collection<T>> C.IsContains(vararg expected: T): C {
    assertThat(this, `is`(contains(*expected)))
    return this
}

/** This same as : `assertThat(actual, is(not(contains(*expected))))` */
fun <T, C : Collection<T>> C.IsNotContains(vararg expected: T): C {
    assertThat(this, `is`(not(contains(*expected))))
    return this
}

/** This same as : `assertThat(actual, is(containsInAnyOrder(*expected)))` */
fun <T, C : Collection<T>> C.IsContainsInAnyOrder(vararg expected: T): C {
    assertThat(this, `is`(containsInAnyOrder(*expected)))
    return this
}

/** This same as : `assertThat(actual, is(not(containsInAnyOrder(*expected))))` */
fun <T, C : Collection<T>> C.IsNotContainsInAnyOrder(vararg expected: T): C {
    assertThat(this, `is`(not(containsInAnyOrder(*expected))))
    return this
}

/** This same as : `assertThat(actual, is(empty<T>()))` */
fun <T, C : Collection<T>> C.IsEmpty(): C {
    assertThat(this, `is`(empty<T>()))
    return this
}

/** This same as : `assertThat(actual, is(not(empty<T>())))` */
fun <T, C : Collection<T>> C.IsNotEmpty(): C {
    assertThat(this, `is`(not(empty<T>())))
    return this
}

/** This same as : `assertThat(actual, hasItem(item))` */
fun <T, C : Collection<T>> C.HasItem(item: T): C {
    assertThat(this, hasItem(item))
    return this
}

/** This same as : `assertThat(actual, not(hasItem(item)))` */
fun <T, C : Collection<T>> C.HasNotItem(item: T): C {
    assertThat(this, not(hasItem(item)))
    return this
}

/** This same as : `assertThat(actual, hasItems(items))` */
fun <T, C : Collection<T>> C.HasItems(vararg items: T): C {
    assertThat(this, hasItems(*items))
    return this
}

/** This same as : `assertThat(actual, not(hasItems(items)))` */
fun <T, C : Collection<T>> C.HasNotItems(vararg items: T): C {
    assertThat(this, not(hasItems(*items)))
    return this
}


// kotlin.collections.Map

/** This same as : `assertThat(actual, hasEntry(key, value))` */
fun <K, V> Map<K, V>.HasEntry(key: K, value: V): Map<K, V> {
    assertThat(this, hasEntry(key, value))
    return this
}

/** This same as : `assertThat(actual, hasEntry(key, value))` */
fun <K, V> Map<K, V>.HasNotEntry(key: K, value: V): Map<K, V> {
    assertThat(this, not(hasEntry(key, value)))
    return this
}

/** This same as : `assertThat(actual, hasKey(key))` */
fun <K, V> Map<K, V>.HasKey(key: K): Map<K, V> {
    assertThat(this, hasKey(key))
    return this
}

/** This same as : `assertThat(actual, not(hasKey(key)))` */
fun <K, V> Map<K, V>.HasNotKey(key: K): Map<K, V> {
    assertThat(this, not(hasKey(key)))
    return this
}

/** This same as : `assertThat(actual, hasValue(value))` */
fun <K, V> Map<K, V>.HasValue(value: V): Map<K, V> {
    assertThat(this, hasValue(value))
    return this
}

/** This same as : `assertThat(actual, not(hasValue(value)))` */
fun <K, V> Map<K, V>.HasNotValue(value: V): Map<K, V> {
    assertThat(this, not(hasValue(value)))
    return this
}


// property

/** This same as : `assertThat(actual, samePropertyValuesAs(expected))` */
fun <T> T.IsSamePropertiesAs(expected: T): T {
    assertThat(this, samePropertyValuesAs(expected))
    return this
}

/** This same as : `assertThat(actual, not(samePropertyValuesAs(expected)))` */
fun <T> T.IsNotSamePropertiesAs(expected: T): T {
    assertThat(this, not(samePropertyValuesAs(expected)))
    return this
}
