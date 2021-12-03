package finalproject.stN991554423.org.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class HabitDrinking(var userId: Int, var drinkingDate: String, var drinkingFrequency: Int, var drinkingConsumption: Double): Serializable{

    constructor(): this(0,"", 0, 0.0)
}