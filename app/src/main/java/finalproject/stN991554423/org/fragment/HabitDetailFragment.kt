package finalproject.stN991554423.org.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.FirebaseAuth
import finalproject.stN991554423.org.R
import finalproject.stN991554423.org.data.*
import finalproject.stN991554423.org.databinding.ActivityMainBinding.bind
import finalproject.stN991554423.org.databinding.FragmentHabitDetailBinding
import finalproject.stN991554423.org.viewmodel.FirestoreViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HabitDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HabitDetailFragment : Fragment() {

    //private val navigationArgs: HabitDetailFragmentArgs by navArgs()

    private var _binding: FragmentHabitDetailBinding? = null
    private val binding get() = _binding

    lateinit var habitDrikning: HabitDrinking
    lateinit var habitMeditation: HabitMeditation
    lateinit var habitReading: HabitReading
    lateinit var habitRun: HabitRun
    lateinit var habitSleep: HabitSleep
    lateinit var habitYoga: HabitYoga

    private val firestoreViewModel: FirestoreViewModel by activityViewModels()

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHabitDetailBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        return binding?.root
        //return inflater.inflate(R.layout.fragment_habit_detail, container, false)
    }






    //    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment HabitDetailFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            HabitDetailFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.detail_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                logout()
                true
            }
            // only for test
            R.id.action_list -> {
                checkList()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    fun logout() {

        val action = HabitListFragmentDirections.actionHabitListFragmentToMainFragment()

        this.findNavController().navigate(action)
        FirebaseAuth.getInstance().signOut()
    }

    fun checkList() {
        val action = HabitDetailFragmentDirections.actionHabitDetailFragmentToHabitListFragment()
        this.findNavController().navigate(action)
    }
}

