package finalproject.stN991554423.org.data

import java.io.Serializable

class HabitYoga(
    var id: String,
    var yogaDate: String,
    var yogaTime: String,
    var yogaDuration: Double
) :
    Serializable {

    constructor() : this("", "", "", 0.0)
}