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

    @RequiresApi(Build.VERSION_CODES.O)
    fun getReadingDate(): LocalDate {
        var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
        var date = LocalDate.parse(readingDate, formatter)

        return date
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getReadingTime(): LocalTime {
        var formatter = DateTimeFormatter.ofPattern("hh:mm:ss")
        var time = LocalTime.parse(readingTime, formatter)

        return  time
    }

    @JvmName("getReadingDuration1")
    fun getReadingDuration(): Double {
        var duration = readingDuration

        return duration
    }
}