/*
    Date: December 5th, 2021
    Name(s): Qingqing Wu(991500423), Yiqian Chang(991554674)
    Description:FirestoreRepository is the class that performs all CRUD method interacted with firestore
                database, and can be used in android.
 */

package finalproject.stN991554423.org.data

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query


class FirestoreRepository {
    val TAG = "FIREBASE_REPOSITORY"
    var firestoreDB = FirebaseFirestore.getInstance()
    var user = FirebaseAuth.getInstance().currentUser

    //----------------------------add to collection----------------------------------------------//
    // save habitDrinking to firebase
    fun saveNewDrinking(eventHabitDrinking: HabitDrinking): Task<*> {
        //var
        return firestoreDB.collection("HabitDrinking")
            .document("${eventHabitDrinking.id}")
            .set(eventHabitDrinking)
    }

    // save habitMeditation to firebase
    fun saveNewMeditation(eventHabitMeditation: HabitMeditation): Task<*> {
        //var
        return firestoreDB.collection("HabitMeditation")
            .document("${eventHabitMeditation.id}")
            .set(eventHabitMeditation)
    }

    // save habitReading to firebase
    fun saveNewReading(eventHabitReading: HabitReading): Task<*> {
        //var
        return firestoreDB.collection("HabitReading")
            .document("${eventHabitReading.id}")
            .set(eventHabitReading)
    }

    // save habitRun to firebase
    fun saveNewRun(eventHabitRun: HabitRun): Task<*> {
        return firestoreDB.collection("HabitRun")
            .document("${eventHabitRun.id}")
            .set(eventHabitRun)
    }

    // save habitSleep to firebase
    fun saveNewSleep(eventHabitSleep: HabitSleep): Task<*> {
        //var
        return firestoreDB.collection("HabitSleep")
            .document("${eventHabitSleep.id}")
            .set(eventHabitSleep)
    }

    // save habitYoga to firebase
    fun saveNewYoga(eventHabitYoga: HabitYoga): Task<*> {
        //var
        return firestoreDB.collection("HabitYoga")
            .document("${eventHabitYoga.id}")
            .set(eventHabitYoga)
    }

    //----------------------------retrieve collection--------------------------------------------//
    // get saved habitDrinking from firebase
    fun getDrinkingCollection(): Query {
        return firestoreDB.collection("HabitDrinking")
            .orderBy("drinkingDate", Query.Direction.DESCENDING)
            .orderBy("drinkingDate", Query.Direction.DESCENDING)
            .orderBy("drinkingFrequency", Query.Direction.DESCENDING)
    }

    // get saved habitMeditation from firebase
    fun getMeditationCollection(): Query {
        return firestoreDB.collection("HabitMeditation")
            .orderBy("meditationDate", Query.Direction.DESCENDING)
            .orderBy("meditationTime", Query.Direction.DESCENDING)
            .orderBy("meditationDuration", Query.Direction.DESCENDING)
    }

    // get saved habitReading from firebase
    fun getReadingCollection(): Query {
        return firestoreDB.collection("HabitReading")
            .orderBy("readingDate", Query.Direction.DESCENDING)
            .orderBy("readingTime", Query.Direction.DESCENDING)
            .orderBy("readingDuration", Query.Direction.DESCENDING)
    }

    // // get saved habitRun from firebase
    fun getRunCollection(): Query {
        return firestoreDB.collection("HabitRun")
            .orderBy("runDate", Query.Direction.DESCENDING)
            .orderBy("runTime", Query.Direction.DESCENDING)
            .orderBy("runDistance", Query.Direction.DESCENDING)
    }

    // get saved habitSleep from firebase
    fun getSleepCollection(): Query {
        return firestoreDB.collection("HabitSleep")
            .orderBy("sleepDate", Query.Direction.DESCENDING)
            .orderBy("sleepTime", Query.Direction.DESCENDING)
            .orderBy("sleepDuration", Query.Direction.DESCENDING)
    }

    // get saved habitYoga from firebase
    fun getYogaCollection(): Query {
        return firestoreDB.collection("HabitYoga")
            .orderBy("yogaDate", Query.Direction.DESCENDING)
            .orderBy("yogaTime", Query.Direction.DESCENDING)
            .orderBy("yogaDuration", Query.Direction.DESCENDING)
    }

    //----------------------------update document----------------------------------------------//
    // update run
    fun updateHabitRun(habitId: String, habit: HabitRun): Task<*> {
        return firestoreDB.collection("HabitRun").document(habitId)
            .set(habit)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }

    // update habitMeditation
    fun updateHabitMeditation(habitId: String, habit: HabitMeditation): Task<*> {
        return firestoreDB.collection("HabitMeditation").document(habitId)
            .set(habit)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }

    // update habitReading
    fun updateHabitReading(habitId: String, habit: HabitReading): Task<*> {
        return firestoreDB.collection("HabitReading").document(habitId)
            .set(habit)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }

    // update habitDrinking
    fun updateHabitDrinking(habitId: String, habit: HabitDrinking): Task<*> {
        return firestoreDB.collection("HabitDrinking").document(habitId)
            .set(habit)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }

    // update habitSleep
    fun updateHabitSleep(habitId: String, habit: HabitSleep): Task<*> {
        return firestoreDB.collection("HabitSleep").document(habitId)
            .set(habit)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }

    // update habitHabitYoga
    fun updateHabitYoga(habitId: String, habit: HabitYoga): Task<*> {
        return firestoreDB.collection("HabitYoga").document(habitId)
            .set(habit)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }

    //----------------------------delete document----------------------------------------------//
    fun deleteDrinking(habitId: String): Task<*> {
        return firestoreDB.collection("HabitDrinking").document(habitId)
            .delete()
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) }
    }

    // delete habitMeditation
    fun deleteMeditation(habitId: String): Task<*> {
        return firestoreDB.collection("HabitMeditation").document(habitId)
            .delete()
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) }
    }

    // delete habitReading
    fun deleteReading(habitId: String): Task<*> {
        return firestoreDB.collection("HabitReading").document(habitId)
            .delete()
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) }
    }

    // delete habitRun
    fun deleteRun(habitId: String): Task<*> {
        return firestoreDB.collection("HabitRun").document(habitId)
            .delete()
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) }
    }

    // delete habitSleep
    fun deleteSleep(habitId: String): Task<*> {
        return firestoreDB.collection("HabitSleep").document(habitId)
            .delete()
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) }
    }

    // delete habitYoga
    fun deleteYoga(habitId: String): Task<*> {
        return firestoreDB.collection("HabitYoga").document(habitId)
            .delete()
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) }
    }


}