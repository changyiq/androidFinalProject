package finalproject.stN991554423.org.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import finalproject.stN991554423.org.R
import finalproject.stN991554423.org.data.FirestoreRepository
import finalproject.stN991554423.org.data.HabitRun
import finalproject.stN991554423.org.databinding.HabitListFragmentBinding
import finalproject.stN991554423.org.recyclerView.HabitRunRecyclerView
import finalproject.stN991554423.org.viewmodel.FirestoreViewModel
import finalproject.stN991554423.org.viewmodel.HabitListViewModel

const val TAG = "FIRESTORE"

class HabitListFragment : Fragment() {

    companion object {
        fun newInstance() = HabitListFragment()
    }

    // properties
    private var _binding: HabitListFragmentBinding? = null
    private lateinit var viewModel: HabitListViewModel
//    private var firestoreRepository: FirestoreRepository? = null

    //    val firestoreViewModel = ViewModelProviders.of(this)[FirestoreViewModel::class.java]
    private val firestoreViewModel: FirestoreViewModel by activityViewModels()


    // with the backing property of the kotlin we extract
    // the non null value of the _binding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HabitListFragmentBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = firestoreViewModel.getAllHabitRun()?.let { it ->
            HabitRunRecyclerView(it)
        }


        // button click event to trigger database data fetching
        binding.btnRun.setOnClickListener {
            var list = firestoreViewModel.getAllHabitRun()
//            firestoreRepository!!.getRunCollection()
//                .get()
//                .addOnCompleteListener {
//                    //val result: StringBuffer = StringBuffer()
//                    if (it.isSuccessful) {
//                        for (document in it.result!!) {
//                            val item = HabitRun(
//                                document.data.getValue("userId") as Int,
//                                document.data.getValue("runDate") as String,
//                                document.data.getValue("runTime") as String,
//                                document.data.getValue("runDistance") as Double)
//                            list += item
//                        }
//                        binding.recyclerView.adapter = HabitRunRecyclerView(list)
//                    }
//                }
            binding.recyclerView.adapter = list?.let { it1 -> HabitRunRecyclerView(it1) }
        }

        binding.btnDrinking.setOnClickListener {

        }

        binding.btnMeditation.setOnClickListener {

        }

        binding.btnReading.setOnClickListener {

        }

        binding.btnSleep.setOnClickListener {

        }

        binding.btnYoga.setOnClickListener {

        }

        binding.floatingActionButton.setOnClickListener {
            val action = HabitListFragmentDirections.actionHabitListFragmentToAddHabitFragment(
            )
            this.findNavController().navigate(action)
        }
    }


//    // repeat the rows and get the list
//    private fun generateDummyList(size: Int): List<HabitRun> {
//        val list = ArrayList<HabitRun>()
//        for (i in 0 until size) {
//            val drawable = when (i % 3) {
//                0 -> R.drawable.ic_android
//                1 -> R.drawable.ic_launcher_background
//                else -> R.drawable.ic_launcher_foreground
//            }
//            val item = HabitRun(drawable, "Item $i", "Line 2")
//            list += item
//        }
//        return list
//    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HabitListViewModel::class.java)

    }

    fun logout() {

        val action = HabitListFragmentDirections.actionHabitListFragmentToMainFragment()

        this.findNavController().navigate(action)
        FirebaseAuth.getInstance().signOut()
    }
}







