package finalproject.stN991554423.org.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class HabitDrinking(var drinkingId: Int, var drinkingDate: String, var drinkingFrequency: Int, var drinkingConsumption: Double): Serializable{

    constructor(): this(0,"", 0, 0.0)

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDrinkingDate(): LocalDate {
        var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
        var date = LocalDate.parse(drinkingDate, formatter)

        return date
    }

    @JvmName("getDrinkingFrequency1")
    fun getDrinkingFrequency(): Int {
        var frequency = drinkingFrequency

        return  frequency
    }

    @JvmName("getDrinkingConsumption1")
    fun getDrinkingConsumption(): Double {
        var consumption = drinkingConsumption

        return consumption
    }
}