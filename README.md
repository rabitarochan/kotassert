# kotassert
 
[![Build Status](https://travis-ci.org/rabitarochan/kotassert.svg?branch=master)](https://travis-ci.org/rabitarochan/kotassert)

`kotassert` is a provides JUnit assertion API for Kotlin.

# Description

`kotassert` provides a simple and readable Assertion API.

```kotlin
// assertThat(actual, `is`(expected))
actual.Is(expected)

// assertThat(actual, `is`(not(expected)))
actual.IsNot(expected)

// assertThat(true, `is`(true))
true.IsTrue(message = "assertion with message!")
```

Since the assertion method returns the actual value, you can chain the assertion.

```kotlin
actual.IsNotNull()
      .Is(/* ... */)
      .IsNot(/* ... */)
```

# Getting started

Gradle:

```groovy
dependencies {
    testCompile "com.github.rabitarochan:kotassert:0.1.0-SNAPSHOT"
}
```

Maven:

```xml
<dependency>
    <groupId>com.github.rabitarochan</groupId>
    <artifactId>kotassert</artifactId>
    <version>0.1.0-SNAPSHOT</version>
    <scope>test</scope>
</dependency>
```

# API Usage

See also [tests](https://github.com/rabitarochan/kotassert/tree/master/src/test/kotlin/kotassert/tests).

## Imports

```kotlin
import kotassert.* // import extension functions.
import org.junit.Test

class UnitTest() {

    @Test
    fun test() {
        val result = 1 + 1
        result.Is(2)
    }

}
```

## Value Assertion

### Is, IsNot

```kotlin
// plain kotlin: assertThat(actual, `is`(expected))
actual.Is(expected)
```

### Is, IsNot with lambda

```kotlin
"foobar".Is { it.startsWith("foo") && it.endsWith("bar") }

"foobar".IsNot { it.length <= 5 }
```

### IsTrue, IsFalse

```kotlin
// assertThat("foobar".startsWith("foo"), `is`(true))
"foobar".startsWith("foo").IsTrue()

// assertThat("foobar".startsWith("FOO"), `is`(false))
"foobar".startsWith("FOO").IsFalse()
```

### IsNull, IsNotNull

```kotlin
var actual: String? = null

// assertThat(actual, `is`(nullValue()))
actual.IsNull()

actual = "Hello kotassert"

// assertThat(actual, `is`(not(nullValue())))
actual.IsNotNull()
```

### IsSameInstance, IsNotSameInstance

```kotlin
val x = SingletonFactory.instance
val y = SingletonFactory.instance
val z = NormalFactory.createInstance()

// assertThat(x, `is`(sameInstance(y))
x.IsSameInstance(y)

// assertThat(x, `is`(not(sameInstance(y)))
x.IsNotSameInstance(z)
```

### IsInstanceOf, IsNotInstanceOf

```kotlin
interface A {}
interface B {}

class C() : A

val x = C()

// assertThat(x, `is`(instanceOf(A::class.java)))
x.IsInstanceOf(A::class)

// assertThat(x, `is`(not(instanceOf(B::class.java))))
x.IsNotInstanceOf(B::class)
```

### IsIn, IsNotIn

```kotlin
val xs = arrayOf(1, 2, 3, 4, 5) // or listOf(1, 2, 3, 4, 5)

// assertThat(1, isIn(xs))
1.IsIn(xs)

// assertThat(6, not(isIn(xs)))
6.IsNotIn(xs)
```

### IsOneOf, IsNotOneOf

```kotlin
// assertThat(1, isOneOf(1, 2, 3, 4, 5))
1.IsOneOf(1, 2, 3, 4, 5)

// assertThat(6, not(isOneOf(1, 2, 3, 4, 5)))
6.IsNotOneOf(1, 2, 3, 4, 5)
```

## Array and Collection Assertion

### IsContains, IsNotContains

```kotlin
val xs = arrayOf(1, 2, 3, 4, 5)

// assertThat(xs, `is`(arrayContaining(1, 2, 3, 4, 5))) or assertThat(xs, `is`(contains(1, 2, 3, 4, 5)))
xs.IsContains(1, 2, 3, 4, 5)

// assertThat(xs, `is`(not(arrayContaining(1, 2, 3, 4)))) or assertThat(xs, `is`(not(contains(1, 2, 3, 4))))
xs.IsNotContains(1, 2, 3, 4)
```

### IsContainsInAnyOrder, IsNotContainsInAnyOrder

```kotlin
val xs = arrayOf(1, 2, 3, 4, 5)

// assertThat(xs, `is`(arrayContainingInAnyOrder(4, 3, 5, 1, 2))) or assertThat(xs, `is`(containsInAnyOrder(4, 3, 5, 1, 2)))
xs.IsContainsInAnyOrder(4, 3, 5, 1, 2)

// assertThat(xs, `is`(not(arrayContainingInAnyOrder(1, 2, 4, 5)))) or assertThat(xs, `is`(not(containsInAnyOrder(1, 2, 4, 5))))
xs.IsNotContainsInAnyOrder(1, 2, 4, 5)
```

### IsEmpty, IsNotEmpty

```kotlin
val xs = mutableArrayOf<Int>()

// assertThat(xs, `is`(empty<Int>()))
xs.IsEmpty()

xs.add(1)

// assertThat(xs, `is`(not(empty<Int>())))
xs.IsNotEmpty()
```

### HasItem, HasNotItem

```kotlin
val xs = arrayOf(1, 2, 3, 4, 5) // or listOf(1, 2, 3, 4, 5)

// assertThat(xs, hasItem(1))
xs.HasItem(1)

// assertThat(xs, not(hasItem(6)))
xs.HasNotItem(6)
```

### HasItems, HasNotItems

```kotlin
val xs = arrayOf(1, 2, 3, 4, 5) // or listOf(1, 2, 3, 4, 5)

// assertThat(xs, hasItems(1, 3, 5))
xs.HasItems(1, 3, 5)

// assertThat(xs, not(hasItems(0, 6)))
xs.HasNotItems(0, 6)
```

## Map Assertion

### HasEntry, HasNotEntry

```kotlin
val map = mapOf(
  1 to "one",
  2 to "two",
  3 to "three",
  4 to "four",
  5 to "five"
)

// assertThat(map, hasEntry(1, "one"))
map.HasEntry(1, "one")

// assertThat(map, not(hasEntry(2, "TWO")))
map.HasEntry(2, "TWO")
```

### HasKey, HasNotKey

```kotlin
val map = mapOf(
  1 to "one",
  2 to "two",
  3 to "three",
  4 to "four",
  5 to "five"
)

// assertThat(map, hasKey(1))
map.HasKey(1)

// assertThat(map, not(hasKey(6)))
map.HasKey(6)
```

### HasValue, HasNotValue

```kotlin
val map = mapOf(
  1 to "one",
  2 to "two",
  3 to "three",
  4 to "four",
  5 to "five"
)

// assertThat(map, hasValue("two"))
map.HasValue("two")

// assertThat(map, not(hasValue("TWO")))
map.HasValue("TWO")
```

## Property Assertion

```kotlin
data class Person(val id: Int, val name: String)

val alice = Person(1, "alice")
val bob = Person(2, "bob")

// assertThat(alice, samePropertyValueAs(Person(1, "alice")))
alice.IsSamePropertyValueAs(Person(1, "alice"))

// assertThat(alice, not(samePropertyValueAs(bob)))
alice.IsNotSamePropertyValueAs(bob)
```

## Exception Assertion

```kotlin
KotAssert.throws<NotImplementedError> {
    TODO()
}

KotAssert.notThrow {
    1 + 1
}
```

# Inspired

* Chaining Assertion (https://github.com/neuecc/ChainingAssertion)

# License

The MIT License

Copyright (c) 2016 Kengo Asamizu
