package finalproject.stN991554423.org.data

import java.io.Serializable

class HabitReading(
    var id: String,
    var readingDate: String,
    var readingTime: String,
    var readingDuration: Double
) :
    Serializable {

    constructor() : this("", "", "", 0.0)
}