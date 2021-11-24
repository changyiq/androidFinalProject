package finalproject.stN991554423.org.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.*
import java.time.format.DateTimeFormatter

class HabitRun(var userId: Int, var runDate: String, var runTime: String, var runDistance: Double): Serializable {

    constructor(): this(0,"", "", 0.0)

    @RequiresApi(Build.VERSION_CODES.O)
    fun getRunDate(): LocalDate {
        var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
        var date = LocalDate.parse(runDate, formatter)

        return date
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getRunTime(): LocalTime {
        var formatter = DateTimeFormatter.ofPattern("hh:mm:ss")
        var time = LocalTime.parse(runTime, formatter)

        return  time
    }

    @JvmName("getRunDistance1")
    fun getRunDistance(): Double {
        var distance = runDistance

        return distance
    }
}