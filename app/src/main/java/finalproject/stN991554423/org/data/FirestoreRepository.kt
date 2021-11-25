package finalproject.stN991554423.org.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class FirestoreRepository {
    val TAG = "FIREBASE_REPOSITORY"
    var firestoreDB = FirebaseFirestore.getInstance()
    var user = FirebaseAuth.getInstance().currentUser


//    // save habitRun to firebase
//    fun saveRun(eventHabitRun: HabitRun): Task<Void> {
//        //var
//        var documentReference = firestoreDB.collection("HabitRun").document(user!!.email.toString())
//            .collection("saved_addresses").document(eventHabitRun.addressId)
//        return documentReference.set(HabitRun)
//    }

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