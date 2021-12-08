package finalproject.stN991554423.org.data

import java.io.Serializable

class HabitRun(var id: String, var runDate: String, var runTime: String, var runDistance: Double) :
    Serializable {

    constructor() : this("", "", "", 0.0)
}