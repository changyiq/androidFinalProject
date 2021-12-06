package finalproject.stN991554423.org.data

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore


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
    fun getDrinkingCollection(): CollectionReference {
        return firestoreDB.collection("HabitDrinking")
    }

    // get saved habitMeditation from firebase
    fun getMeditationCollection(): CollectionReference {
        return firestoreDB.collection("HabitMeditation")
    }

    // get saved habitReading from firebase
    fun getReadingCollection(): CollectionReference {
        return firestoreDB.collection("HabitReading")
    }

    // // get saved habitRun from firebase
    fun getRunCollection(): CollectionReference {
        return firestoreDB.collection("HabitRun")
    }

    // get saved habitSleep from firebase
    fun getSleepCollection(): CollectionReference {
        return firestoreDB.collection("HabitSleep")
    }

    // get saved habitYoga from firebase
    fun getYogaCollection(): CollectionReference {
        return firestoreDB.collection("HabitYoga")
    }

    //----------------------------retrieve document---------------------------------------------//
    // get one habitDrinking document from firebase

//    fun getDrinkingDoc(habitId: String): DocumentReference {
//        return firestoreDB.collection("HabitDrinking").document(habitId)
//    }

    fun getDrinkingDoc(habitId: String): Task<*> {
        return firestoreDB.collection("HabitRun").document(habitId).get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }

    // get one habitMeditation document from firebase
    fun getMeditationDocument(habitId: HabitMeditation): Task<DocumentSnapshot> {
        return firestoreDB.collection("HabitMeditation").document("$habitId").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }

    // get one habitReading document from firebase
    fun getReadingDocument(habitId: HabitReading): Task<DocumentSnapshot> {
        return firestoreDB.collection("HabitReading").document("$habitId").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }

    // get one habitRun document from firebase
    fun getRunDocument(habitId: HabitRun): Task<DocumentSnapshot> {
        return firestoreDB.collection("HabitRun").document("$habitId").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }

    // get one habitSleep document from firebase
    fun getSleepDocument(habitId: HabitSleep): Task<DocumentSnapshot> {
        return firestoreDB.collection("HabitSleep").document("$habitId").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }

    // get one habitYoga document from firebase
    fun getYogaDocument(habitId: HabitYoga): Task<DocumentSnapshot> {
        return firestoreDB.collection("HabitYoga").document("$habitId").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }

    //----------------------------update document----------------------------------------------//
    fun updateHabitDrinking(habitId: String, eventHabitDrinking: HabitDrinking): Task<*> {
        return firestoreDB.collection("HabitDrinking").document(habitId)
            //.update(eventHabitDrinking.drinkingDate,eventHabitDrinking.drinkingFrequency,eventHabitDrinking.drinkingConsumption)
            .set(eventHabitDrinking)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }



    // update habitMeditation
    fun updateHabitMeditation(habitId: String, eventHabitMeditation: HabitMeditation): Task<*> {
        return firestoreDB.collection("HabitMeditation").document(habitId)
            .update(habitId, eventHabitMeditation)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }

    // update habitReading
    fun updateHabitReading(habitId: String, eventHabitReading: HabitReading): Task<*> {
        return firestoreDB.collection("HabitReading").document(habitId)
            .update(habitId, eventHabitReading)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }

    // update habitRun
    fun updateHabitRun(habitId: String, eventHabitRun: HabitRun): Task<*> {
        return firestoreDB.collection("HabitRun").document(habitId)
            .update(habitId, eventHabitRun)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }

    // update habitSleep
    fun updateHabitSleep(habitId: String, eventHabitSleep: HabitSleep): Task<*> {
        return firestoreDB.collection("HabitSleep").document(habitId)
            .update(habitId, eventHabitSleep)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }

    // update habitHabitYoga
    fun updateHabitYoga(habitId: String, eventHabitYoga: HabitYoga): Task<*> {
        return firestoreDB.collection("HabitYoga").document(habitId)
            .update(eventHabitYoga.yogaDate, eventHabitYoga.yogaTime, eventHabitYoga.yogaDuration)
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