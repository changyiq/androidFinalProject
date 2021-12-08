package finalproject.stN991554423.org.data

import java.io.Serializable

class HabitMeditation(
    var id: String,
    var meditationDate: String,
    var meditationTime: String,
    var meditationDuration: Double
) : Serializable {

    constructor() : this("", "", "", 0.0)
}