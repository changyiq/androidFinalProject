package finalproject.stN991554423.org.data

import java.io.Serializable


class HabitDrinking(
    var id: String,
    var drinkingDate: String,
    var drinkingFrequency: Int,
    var drinkingConsumption: Double
) : Serializable {

    constructor() : this("", "", 0, 0.0)
}