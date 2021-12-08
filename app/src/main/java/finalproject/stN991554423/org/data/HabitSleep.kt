package finalproject.stN991554423.org.data

import java.io.Serializable

class HabitSleep(
    var id: String,
    var sleepDate: String,
    var sleepTime: String,
    var sleepDuration: Double
) :
    Serializable {

    constructor() : this("", "", "", 0.0)
}