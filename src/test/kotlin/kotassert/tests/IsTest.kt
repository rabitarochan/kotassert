package kotassert.tests

import kotassert.*
import org.junit.Test

class IsTest() {

    interface NormalInterface {
        val id: Int
    }

    data class DataClass(override val id: Int, val text: String) : NormalInterface

    class NormalClass(override val id: Int, val text: String) : NormalInterface {

        companion object : NormalInterface {

            override val id: Int = 12345

            val text: String = "Hello world"

        }

    }

    object NormalObject : NormalInterface {

        override val id: Int = 12345

        val text: String = "Hello world"

    }

    enum class Gender {
        Male, Female, Other;

        companion object {
            val simpleValues: Array<Gender> = arrayOf(Male, Female)
        }

    }

    class ComparableClass(val id: Int, val text: String): Comparable<ComparableClass> {

        override fun compareTo(other: ComparableClass): Int {
            id.compareTo(other.id).let {
                if (it != 0) return it
            }

            return text.compareTo(other.text)
        }

    }

    @Test
    fun simpleValueTest() {

        Math.pow(5.toDouble(), 2.toDouble()).Is(25.toDouble())

        Math.PI.IsNot((3.14).toDouble())

        "foobar".Is { s -> s.startsWith("foo") && s.endsWith("bar") }

        "12345".IsNot(String::isEmpty)

        IntRange(1, 5).toList().IsContains(1, 2, 3, 4, 5)

        IntRange(1, 5).reversed().toList().IsNotContains(1, 2, 3, 4, 5)

    }

    @Test
    fun nullTest() {

        val notNullableValue: String = "Not Null"
        val nullableValue: String? = "Not Null"
        val nullValue: String? = null

        notNullableValue.IsNotNull()
        nullableValue.IsNotNull()
        nullValue.IsNull()

    }

    @Test
    fun instanceTest() {

        val dataClass1 = DataClass(1, "DataClass1")
        val dataClass2 = DataClass(2, "DataClass2")

        val normalClass1 = NormalClass(1, "NormalClass1")
        val normalClass2 = NormalClass(2, "NormalClass2")

        val companionObject = NormalClass
        val normalObject = NormalObject

        dataClass1.IsSameInstance(dataClass1)
        dataClass1.IsNotSameInstance(dataClass2)

        normalClass1.IsSameInstance(normalClass1)
        normalClass1.IsNotSameInstance(normalClass2)

        companionObject.IsSameInstance(NormalClass)

        normalObject.IsSameInstance(NormalObject)

    }

    @Test
    fun instanceOfTest() {

        val dataClass1 = DataClass(1, "DataClass1")

        val normalClass1 = NormalClass(1, "NormalClass1")

        val companionObject = NormalClass
        val normalObject = NormalObject

        dataClass1.IsInstanceOf(DataClass::class)
        dataClass1.IsNotInstanceOf(NormalClass::class)
        dataClass1.IsInstanceOf(NormalInterface::class)

        normalClass1.IsInstanceOf(NormalClass::class)
        normalClass1.IsNotInstanceOf(DataClass::class)
        normalClass1.IsInstanceOf(NormalInterface::class)

        companionObject.IsInstanceOf(NormalClass.Companion::class)
        companionObject.IsNotInstanceOf(NormalObject::class)
        companionObject.IsInstanceOf(NormalInterface::class)

        normalObject.IsInstanceOf(NormalObject::class)
        normalObject.IsNotInstanceOf(NormalClass.Companion::class)
        normalObject.IsInstanceOf(NormalInterface::class)

    }

    @Test
    fun isInTest() {

        val valueArray = arrayOf(Gender.Male, Gender.Female, Gender.Other)
        val simpleValueArray = arrayOf(Gender.Male, Gender.Female)

        val valueList = listOf(Gender.Male, Gender.Female, Gender.Other)
        val simpleValueList = listOf(Gender.Male, Gender.Female)

        Gender.Male.IsIn(valueArray)
        Gender.Other.IsNotIn(simpleValueArray)

        Gender.Female.IsIn(valueList)
        Gender.Other.IsNotIn(simpleValueList)

        Gender.Male.IsOneOf(Gender.Male, Gender.Female, Gender.Other)
        Gender.Other.IsNotOneOf(Gender.Male, Gender.Female)

    }

    @Test
    fun copareToTest() {

        val x1 = ComparableClass(1, "foo")
        val x2 = ComparableClass(2, "bar")
        val x3 = ComparableClass(1, "foo")

        x1.IsCompareTo(x3)
        x1.IsNotCompareTo(x2)

    }


}
