package androidsamples.java.whatday

import android.util.Log
import java.util.*

/**
 * Represents the date to be set, whether it is a valid date, and the message with error status or the day of the week.
 */
object DateModel {
    /**
     * Initializes the [DateModel] with the given year, month, and date.
     * If the date is not valid, it sets the appropriate error message.
     * If it is valid, it sets the appropriate day of the week message.
     *
     * @param yearStr  a `String` representing the year, e.g., "1947"
     * @param monthStr a `String` representing the month, e.g., "8"
     * @param dateStr  a `String` representing the date, e.g., "15"
     */
    @JvmStatic
    fun initialize(yearStr: String?, monthStr: String?, dateStr: String?) {
        if (yearStr == null || yearStr == "" || monthStr == null || monthStr == "" || dateStr == null || dateStr == "") {
            message = "Please fill all values."
            return
        }
        if (yearStr.length > 4 || yearStr.toIntOrNull() == null) {
            message = "Invalid year"
            return
        }
        if (monthStr.length > 2 || monthStr.toIntOrNull() == null || monthStr.toInt() > 12) {
            message = "Invalid month"
            return
        }
        if (dateStr.length > 2 || dateStr.toIntOrNull() == null || dateStr.toInt() > 31) {
            message = "Invalid date"
            return
        }
        val calendar: Calendar = Calendar.getInstance(TimeZone.getDefault())
        calendar.set(yearStr.toInt(), monthStr.toInt() - 1, dateStr.toInt())
        message = when (calendar.get(Calendar.DAY_OF_WEEK)) {
            2 -> "Monday"
            3 -> "Tuesday"
            4 -> "Wednesday"
            5 -> "Thursday"
            6 -> "Friday"
            7 -> "Saturday"
            1 -> "Sunday"
            else -> ""
        }
        Log.d("INITIALISE", "initialize: $message")
    }

    /**
     * Retrieves the message from the [DateModel].
     * It can be an error message like "February of 2019 does not have 29 days"
     * or a success message like "Friday".
     *
     * @return the message from the model
     */
    @JvmStatic
    var message: String = ""
        get() = field
}