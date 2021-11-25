package finalproject.stN991554423.org.viewmodel

import android.content.Context
import android.preference.PreferenceManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import finalproject.stN991554423.org.R
import finalproject.stN991554423.org.data.FirebaseUserLiveData
import kotlin.random.Random

class LoginViewModel : ViewModel() {

    companion object {
        val encouragementQuotes = arrayOf(
            "Everything you need to accomplish your goals is already in you.",
            "Keep going, we're going to get through this together.",
            "Be gentle with yourself. You’re doing the best you can!",
            "I’m so proud of you. I just wanted to tell you in case no one has.",
            "There’s something in you that the world needs."
        )

    }

    enum class AuthenticationState {
        AUTHENTICATED, UNAUTHENTICATED, INVALID_AUTHENTICATION
    }

    val authenticationState = FirebaseUserLiveData().map { user ->
        if (user != null) {
            AuthenticationState.AUTHENTICATED
        } else {
            AuthenticationState.UNAUTHENTICATED
        }
    }

    fun getQuotesToDisplay(context: Context): String {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val quoteTypePreferenceKey = context.getString(R.string.preference_quotes_key)
        val defaultQuoteType = context.resources.getStringArray(R.array.quotes_type)[0]
        val quotesType = sharedPreferences.getString(quoteTypePreferenceKey, defaultQuoteType)

        return encouragementQuotes[Random.nextInt(0, encouragementQuotes.size)]
    }
}