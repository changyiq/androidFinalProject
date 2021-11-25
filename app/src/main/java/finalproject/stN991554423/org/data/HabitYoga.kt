package finalproject.stN991554423.org.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class HabitYoga(var userId: Int, var yogaDate: String, var yogaTime: String, var yogaDuration: Double):
    Serializable {

    constructor(): this(0,"", "", 0.0)

    @JvmName("getYogaDate1")
    fun getYogaDate(): String {
//        var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
//        var date = LocalDate.parse(yogaDate, formatter)
        var date = yogaDate

        return date
    }

    @JvmName("getYogaTime1")
    fun getYogaTime(): String {
//        var formatter = DateTimeFormatter.ofPattern("hh:mm:ss")
//        var time = LocalTime.parse(yogaTime, formatter)
        var time = yogaTime

        return  time
    }

    @JvmName("getYogaDuration1")
    fun getYogaDuration(): Double {
        var duration = yogaDuration

        return duration
    }
}