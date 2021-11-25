package finalproject.stN991554423.org.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class HabitReading(var userId: Int, var readingDate: String, var readingTime: String, var readingDuration: Double):
    Serializable {

    constructor(): this(0,"", "", 0.0)

    @JvmName("getReadingDate1")
    fun getReadingDate(): String {
//        var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
//        var date = LocalDate.parse(readingDate, formatter)
        var date = readingDate

        return date
    }

    @JvmName("getReadingTime1")
    fun getReadingTime(): String {
//        var formatter = DateTimeFormatter.ofPattern("hh:mm:ss")
//        var time = LocalTime.parse(readingTime, formatter)
        var time = readingTime

        return  time
    }

    @JvmName("getReadingDuration1")
    fun getReadingDuration(): Double {
        var duration = readingDuration

        return duration
    }
}