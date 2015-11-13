package iii_conventions

import java.util.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if(this.year != other.year) return this.year - other.year
        else if(this.month != other.month) return  this.month - other.month
        else return this.dayOfMonth - other.dayOfMonth
    }
}

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this,other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

// copy from resolution
class DateIterator(val dateRange: DateRange) : Iterator<MyDate> {
    var current: MyDate = dateRange.start
    override fun next(): MyDate {
        val result = current
        current = current.addTimeIntervals(TimeInterval.DAY, 1)
        return result
    }
    override fun hasNext(): Boolean = current <= dateRange.end
}

class DateRange(public override val start: MyDate, public override val end: MyDate): Iterable<MyDate>, Range<MyDate> {
    override fun iterator(): Iterator<MyDate> = DateIterator(this)

    var current = start.dayOfMonth

    override fun contains(item: MyDate): Boolean {
        return  start <= item && item <= end
    }
}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

operator fun MyDate.plus(time: TimeInterval) = addTimeIntervals(time, 1)
operator fun MyDate.plus(repeat: RepeatedTimeInterval) = addTimeIntervals(repeat.timeInterval, repeat.number)
operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)
