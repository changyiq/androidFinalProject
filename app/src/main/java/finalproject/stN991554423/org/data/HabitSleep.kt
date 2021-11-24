package finalproject.stN991554423.org.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class HabitSleep(var userId: Int, var sleepDate: String, var sleepTime: String, var sleepDuration: Double):
    Serializable {

    constructor(): this(0,"", "", 0.0)

    @RequiresApi(Build.VERSION_CODES.O)
    fun getSleepDate(): LocalDate {
        var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
        var date = LocalDate.parse(sleepDate, formatter)

        return date
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getSleepTime(): LocalTime {
        var formatter = DateTimeFormatter.ofPattern("hh:mm:ss")
        var time = LocalTime.parse(sleepTime, formatter)

        return  time
    }

    @JvmName("getSleepDuration1")
    fun getSleepDuration(): Double {
        var duration = sleepDuration

        return duration
    }
}