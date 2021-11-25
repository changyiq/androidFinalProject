package finalproject.stN991554423.org.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.*
import java.time.format.DateTimeFormatter

class HabitRun(var userId: Int, var runDate: String, var runTime: String, var runDistance: Double): Serializable {

    constructor(): this(0,"", "", 0.0)

    @JvmName("getRunDate1")
    fun getRunDate(): String {
//        var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
//        var date = LocalDate.parse(runDate, formatter)

        var date = runDate

        return date
    }

    @JvmName("getRunTime1")
    fun getRunTime(): String {
//        var formatter = DateTimeFormatter.ofPattern("hh:mm:ss")
//        var time = LocalTime.parse(runTime, formatter)
        var time = runTime

        return  time
    }

    @JvmName("getRunDistance1")
    fun getRunDistance(): Double {
        var distance = runDistance

        return distance
    }
}