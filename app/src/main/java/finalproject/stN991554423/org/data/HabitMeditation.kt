package finalproject.stN991554423.org.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class HabitMeditation(var userId: Int, var meditationDate: String, var meditationTime: String, var meditationDuration: Double): Serializable {

    constructor(): this(0,"", "", 0.0)

    @RequiresApi(Build.VERSION_CODES.O)
    fun getMeditationDate(): LocalDate {
        var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
        var date = LocalDate.parse(meditationDate, formatter)

        return date
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getMeditationTime(): LocalTime {
        var formatter = DateTimeFormatter.ofPattern("hh:mm:ss")
        var time = LocalTime.parse(meditationTime, formatter)

        return  time
    }

    @JvmName("getMeditationDuration1")
    fun getMeditationDuration(): Double {
        var duration = meditationDuration

        return duration
    }
}