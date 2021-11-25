package finalproject.stN991554423.org.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.QuerySnapshot
import finalproject.stN991554423.org.data.FirestoreRepository
import finalproject.stN991554423.org.data.HabitRun

class FirestoreViewModel : ViewModel() {

    val TAG = "FIRESTORE_VIEW_MODEL"
    var firebaseRepository = FirestoreRepository()
    var savedHabitRun : MutableList<HabitRun>? = null

//    // save address to firebase
//    fun saveAddressToFirebase(addressItem: HabitRun){
//        firebaseRepository.savedHabitRun(addressItem).addOnFailureListener {
//            Log.e(TAG,"Failed to save Address!")
//        }
//    }

    // get realtime updates from firebase regarding saved addresses
    fun getAllHabitRun(): MutableList<HabitRun>? {
        firebaseRepository.getRunCollection().addSnapshotListener(EventListener<QuerySnapshot> { value, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
//                savedHabitRun.value = null
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
}