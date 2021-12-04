package finalproject.stN991554423.org.data

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.model.Document


class FirestoreRepository {
    val TAG = "FIREBASE_REPOSITORY"
    var firestoreDB = FirebaseFirestore.getInstance()
    var user = FirebaseAuth.getInstance().currentUser


    // save habitRun to firebase
    fun saveNewRun(eventHabitRun: HabitRun): Task<*> {

        var documentReference = firestoreDB.collection("HabitRun").add(eventHabitRun)
        return documentReference
    }

    fun updateRun(eventHabitRun: HabitRun): Task<*> {
        var documentReference = firestoreDB.collection("HabitRun")
            .document()
            .set(eventHabitRun)
        return documentReference
    }

    // save habitMeditation to firebase
    fun saveNewMeditation(eventHabitMeditation: HabitMeditation): Task<*> {
        //var
        var documentReference = firestoreDB.collection("HabitMeditation").add(eventHabitMeditation)
        return documentReference
    }

    // save habitDrinking to firebase
    fun saveNewDrinking(eventHabitDrinking: HabitDrinking): Task<*> {
        //var
        var documentReference = firestoreDB.collection("HabitDrinking").add(eventHabitDrinking)
        return documentReference
    }

    // save habitSleep to firebase
    fun saveNewSleep(eventHabitSleep: HabitSleep): Task<*> {
        //var
        var documentReference = firestoreDB.collection("HabitSleep").add(eventHabitSleep)
        return documentReference
    }

    // save habitYoga to firebase
    fun saveNewYoga(eventHabitYoga: HabitYoga): Task<*> {
        //var
        var documentReference = firestoreDB.collection("HabitYoga").add(eventHabitYoga)
        return documentReference
    }

    // save habitReading to firebase
    fun saveNewReading(eventHabitReading: HabitReading): Task<*> {
        //var
        var documentReference = firestoreDB.collection("HabitReading").add(eventHabitReading)
        return documentReference
    }

    // get saved habitRun from firebase
    fun getRunCollection(): CollectionReference {
        var collectionReference = firestoreDB.collection("HabitRun")
        return collectionReference
    }

    // get saved habitReading from firebase
    fun getReadingCollection(): CollectionReference {
        var collectionReference = firestoreDB.collection("HabitReading")
        return collectionReference
    }

    // get saved habitMeditation from firebase
    fun getMeditationCollection(): CollectionReference {
        var collectionReference = firestoreDB.collection("HabitMeditation")
        return collectionReference
    }

    // get saved habitYoga from firebase
    fun getYogaCollection(): CollectionReference {
        var collectionReference = firestoreDB.collection("HabitYoga")
        return collectionReference
    }

    // get saved habitDrinking from firebase
    fun getDrinkingCollection(): CollectionReference {
        var collectionReference = firestoreDB.collection("HabitDrinking")
        return collectionReference
    }

    // get saved habitSleep from firebase
    fun getSleepCollection(): CollectionReference {
        var collectionReference = firestoreDB.collection("HabitSleep")
        return collectionReference
    }

//    fun deleteRunHabit(docHabitRun: HabitRun): Task<Void> {
//        var documentReference =  firestoreDB.collection("HabitRun")
//            .document(addressItem.addressId)
//
//        return documentReference.delete()
//    }
}