package finalproject.stN991554423.org.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.*
import java.time.format.DateTimeFormatter

class HabitRun(var userId: Int, var runDate: String, var runTime: String, var runDistance: Double): Serializable {

    constructor(): this(0,"", "", 0.0)
}