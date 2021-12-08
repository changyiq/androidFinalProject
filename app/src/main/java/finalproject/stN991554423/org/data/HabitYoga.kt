/*
    Date: December 5th, 2021
    Name(s): Qingqing Wu(991500423), Yiqian Chang(991554674)
    Description:Data class to hold all fields for habit Yoga
 */

package finalproject.stN991554423.org.data

import java.io.Serializable

class HabitYoga(
    var id: String,
    var yogaDate: String,
    var yogaTime: String,
    var yogaDuration: Double
) :
    Serializable {

    // Constructor declaration with default value
    constructor() : this("", "", "", 0.0)
}