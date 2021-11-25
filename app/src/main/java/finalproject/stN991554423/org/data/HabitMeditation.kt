package finalproject.stN991554423.org.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class HabitMeditation(var userId: Int, var meditationDate: String, var meditationTime: String, var meditationDuration: Double): Serializable {

    constructor(): this(0,"", "", 0.0)

    @JvmName("getMeditationDate1")
    fun getMeditationDate(): String {
//        var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
//        var date = LocalDate.parse(meditationDate, formatter)
        var date = meditationDate

        return date
    }

    @JvmName("getMeditationTime1")
    fun getMeditationTime(): String {
//        var formatter = DateTimeFormatter.ofPattern("hh:mm:ss")
//        var time = LocalTime.parse(meditationTime, formatter)
        var time = meditationTime

        return  time
    }

    @JvmName("getMeditationDuration1")
    fun getMeditationDuration(): Double {
        var duration = meditationDuration

        return duration
    }
}