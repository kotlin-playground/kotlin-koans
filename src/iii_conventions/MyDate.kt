package iii_conventions

import java.util.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return  Date(this.year, this.month, this.dayOfMonth).compareTo(Date(other.year, other.month, other.dayOfMonth))
    }

}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(public val start: MyDate, public val end: MyDate): Iterator<MyDate> {
    var current = start.dayOfMonth

    override fun hasNext(): Boolean {
        return current <= end.dayOfMonth
    }

    override fun next(): MyDate {
        return MyDate(start.year, start.month, current++)
    }
}
