package finalproject.stN991554423.org.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class HabitYoga(var id: String, var yogaDate: String, var yogaTime: String, var yogaDuration: Double):
    Serializable {

    constructor(): this("","", "", 0.0)
}