/*
    Date: December 5th, 2021
    Name(s): Qingqing Wu(991500423), Yiqian Chang(991554674)
    Description:Data class to hold all fields for habit Meditation
 */

package finalproject.stN991554423.org.data

import java.io.Serializable

class HabitMeditation(
    var id: String,
    var meditationDate: String,
    var meditationTime: String,
    var meditationDuration: Double
) : Serializable {

    // Constructor declaration with default value
    constructor() : this("", "", "", 0.0)
}