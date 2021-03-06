package kotassert.tests

import org.junit.Test
import kotassert.*

class PropertyTest() {

    data class DataClass(val id: Int, val text: String)

    class NormalClass(val id: Int, val text: String)

    @Test
    fun propertyTestForDataClass() {

        val dataClass1 = DataClass(1, "one")
        val dataClass2 = DataClass(2, "two")

        dataClass1.IsSamePropertyValueAs(DataClass(1, "one"))
        dataClass1.IsNotSamePropertyValueAs(dataClass2)

    }

    @Test
    fun propertyTestForNormalClass() {

        val notmalClass1 = NormalClass(1, "one")
        val normalClass2 = NormalClass(2, "two")

        notmalClass1.IsSamePropertyValueAs(NormalClass(1, "one"))
        notmalClass1.IsNotSamePropertyValueAs(normalClass2)

    }

}
