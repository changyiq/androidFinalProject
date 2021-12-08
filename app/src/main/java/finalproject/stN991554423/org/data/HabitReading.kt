/*
    Date: December 5th, 2021
    Name(s): Qingqing Wu(991500423), Yiqian Chang(991554674)
    Description:Data class to hold all fields for habit Reading
 */

package finalproject.stN991554423.org.data

import java.io.Serializable

class HabitReading(

    // field declaration
    var id: String,
    var readingDate: String,
    var readingTime: String,
    var readingDuration: Double
) :
    Serializable {

    // Constructor declaration with default value
    constructor() : this("", "", "", 0.0)
}