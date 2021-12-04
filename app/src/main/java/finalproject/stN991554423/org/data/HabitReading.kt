package finalproject.stN991554423.org.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class HabitReading(var readingDate: String, var readingTime: String, var readingDuration: Double):
    Serializable {

    constructor(): this("", "", 0.0)
}