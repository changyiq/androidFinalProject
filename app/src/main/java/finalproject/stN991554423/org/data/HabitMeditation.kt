package finalproject.stN991554423.org.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class HabitMeditation(var userId: Int, var meditationDate: String, var meditationTime: String, var meditationDuration: Double): Serializable {

    constructor(): this(0,"", "", 0.0)
}