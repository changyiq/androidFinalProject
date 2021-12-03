package finalproject.stN991554423.org.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.QuerySnapshot
import finalproject.stN991554423.org.data.*

class FirestoreViewModel : ViewModel() {

    val TAG = "FIRESTORE_VIEW_MODEL"
    var firebaseRepository = FirestoreRepository()
    var savedHabitRun : MutableList<HabitRun>? = null
    var savedHabitDrinking : MutableList<HabitDrinking>? = null
    var savedHabitReading : MutableList<HabitReading>? = null
    var savedHabitSleep : MutableList<HabitSleep>? = null
    var savedHabitMeditation : MutableList<HabitMeditation>? = null
    var savedHabitYoga : MutableList<HabitYoga>? = null

    // save run habit to firebase
    fun saveRunToFirebase(runItem: HabitRun){
        firebaseRepository.saveNewRun(runItem)
    }

    // save Meditation habit to firebase
    fun saveMeditationToFirebase(meditationItem: HabitMeditation){
        firebaseRepository.saveNewMeditation(meditationItem)
    }

    // save sleep habit to firebase
    fun saveSleepToFirebase(sleepItem: HabitSleep){
        firebaseRepository.saveNewSleep(sleepItem)
    }

    // save reading habit to firebase
    fun saveReadingToFirebase(readingItem: HabitReading){
        firebaseRepository.saveNewReading(readingItem)
    }

    // save Yoga habit to firebase
    fun saveYogaToFirebase(yogaItem: HabitYoga){
        firebaseRepository.saveNewYoga(yogaItem)
    }

    // save drinking habit to firebase
    fun saveDrinkingToFirebase(drinkingItem: HabitDrinking){
        firebaseRepository.saveNewDrinking(drinkingItem)
    }

    // get realtime updates from firebase regarding saved habits
    fun getAllHabitRun(): MutableList<HabitRun>? {
        firebaseRepository.getRunCollection().addSnapshotListener(EventListener<QuerySnapshot> { value, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                savedHabitRun.isNullOrEmpty()
                return@EventListener
            }

            val savedHabitRunList : MutableList<HabitRun> = mutableListOf()
            for (doc in value!!) {
                val habitRun = doc.toObject(HabitRun::class.java)
                Log.e("Check---", habitRun.getRunDate() + habitRun.getRunTime() + habitRun.getRunDistance())
                savedHabitRunList.add(habitRun)
            }
            savedHabitRun = savedHabitRunList
        })
        return savedHabitRun
    }

    fun getAllHabitDrinking(): MutableList<HabitDrinking>? {
        firebaseRepository.getDrinkingCollection().addSnapshotListener(EventListener<QuerySnapshot> { value, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                savedHabitDrinking.isNullOrEmpty()
                return@EventListener
            }

            val savedHabitDrinkingList : MutableList<HabitDrinking> = mutableListOf()
            for (doc in value!!) {
                val habitDrinking = doc.toObject(HabitDrinking::class.java)
//                Log.e("Check---", habitDrinking.getDrinkingDate() + habitDrinking.getDrinkingFrequency() + habitDrinking.getDrinkingConsumption())
                savedHabitDrinkingList.add(habitDrinking)
            }
            savedHabitDrinking = savedHabitDrinkingList
        })
        return savedHabitDrinking
    }

    fun getAllHabitSleep(): MutableList<HabitSleep>? {
        firebaseRepository.getSleepCollection().addSnapshotListener(EventListener<QuerySnapshot> { value, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                savedHabitSleep.isNullOrEmpty()
                return@EventListener
            }

            val savedHabitSleepList : MutableList<HabitSleep> = mutableListOf()
            for (doc in value!!) {
                val habitSleep = doc.toObject(HabitSleep::class.java)
                Log.e("Check---", habitSleep.getSleepDate() + habitSleep.getSleepTime() + habitSleep.getSleepDuration())
                savedHabitSleepList.add(habitSleep)
            }
            savedHabitSleep = savedHabitSleepList
        })
        return savedHabitSleep
    }

    fun getAllHabitMeditation(): MutableList<HabitMeditation>? {
        firebaseRepository.getMeditationCollection().addSnapshotListener(EventListener<QuerySnapshot> { value, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                savedHabitMeditation.isNullOrEmpty()
                return@EventListener
            }

            val savedHabitMeditationList : MutableList<HabitMeditation> = mutableListOf()
            for (doc in value!!) {
                val habitMeditation = doc.toObject(HabitMeditation::class.java)
                Log.e("Check---", habitMeditation.getMeditationDate() + habitMeditation.getMeditationTime() + habitMeditation.getMeditationDuration())
                savedHabitMeditationList.add(habitMeditation)
            }
            savedHabitMeditation = savedHabitMeditationList
        })
        return savedHabitMeditation
    }

    fun getAllHabitYoga(): MutableList<HabitYoga>? {
        firebaseRepository.getYogaCollection().addSnapshotListener(EventListener<QuerySnapshot> { value, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                savedHabitYoga.isNullOrEmpty()
                return@EventListener
            }

            val savedHabitYogaList : MutableList<HabitYoga> = mutableListOf()
            for (doc in value!!) {
                val habitYoga = doc.toObject(HabitYoga::class.java)
                Log.e("Check---", habitYoga.getYogaDate() + habitYoga.getYogaTime() + habitYoga.getYogaDuration())
                savedHabitYogaList.add(habitYoga)
            }
            savedHabitYoga = savedHabitYogaList
        })
        return savedHabitYoga
    }

    fun getAllHabitReading(): MutableList<HabitReading>? {
        firebaseRepository.getReadingCollection().addSnapshotListener(EventListener<QuerySnapshot> { value, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                savedHabitReading.isNullOrEmpty()
                return@EventListener
            }

            val savedHabitReadingList : MutableList<HabitReading> = mutableListOf()
            for (doc in value!!) {
                val habitReading = doc.toObject(HabitReading::class.java)
                Log.e("Check---", habitReading.getReadingDate() + habitReading.getReadingTime() + habitReading.getReadingDuration())
                savedHabitReadingList.add(habitReading)
            }
            savedHabitReading = savedHabitReadingList
        })
        return savedHabitReading
    }
}