package iv_properties

import util.*
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class LazyPropertyUsingDelegates(val initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
}

class Delegate {


    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return 0
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {

    }
}


fun todoTask34(): Lazy<Int> = TODO(
    """
        Task 34.
        Read about delegated properties and make the property lazy by using delegates.
    """,
    documentation = doc34()
)
