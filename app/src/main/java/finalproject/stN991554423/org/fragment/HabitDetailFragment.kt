package finalproject.stN991554423.org.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import finalproject.stN991554423.org.R
import finalproject.stN991554423.org.data.*
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

    private val firestoreViewModel: FirestoreViewModel by activityViewModels()

    private val navigationArgs: HabitDetailFragmentArgs by navArgs()

    private var _binding: FragmentHabitDetailBinding? = null
    private val binding get() = _binding!!

    var id = ""

    // this is only for test because the getDocument methods doesn't work
    var habitDrikning: HabitDrinking? = null
    //var habitDrikning: HabitDrinking = firestoreViewModel.getHabitDrinkingDoc()

    lateinit var habitMeditation: HabitMeditation
    lateinit var habitReading: HabitReading
    lateinit var habitRun: HabitRun
    lateinit var habitSleep: HabitSleep
    lateinit var habitYoga: HabitYoga

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHabitDetailBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun habitDrinkingBind() {
        binding.apply {
            imageView.setImageResource(R.drawable.water)
            habitName.text = "Drink Water"
            habitAttr1Label.text = "Date:"
            habitAttr1.text = navigationArgs.habitField1
            habitAttr2Label.text = "Frequency:"
            habitAttr2.text = navigationArgs.habitField2
            habitAttr3Label.text = "Consumption:"
            habitAttr3.text = navigationArgs.habitField3

            deleteHabit.setOnClickListener { showConfirmationDialog() }
            editHabit.setOnClickListener { editHabitDrinkingItem() }
        }
    }

    private fun habitSleepBind() {
        binding.apply {
            imageView.setImageResource(R.drawable.waking_up)
            habitName.text = "Sleep"
            habitAttr1Label.text = "Date:"
            habitAttr1.text = navigationArgs.habitField1
            habitAttr2Label.text = "Time:"
            habitAttr2.text = navigationArgs.habitField2
            habitAttr3Label.text = "Duration:"
            habitAttr3.text = navigationArgs.habitField3

            deleteHabit.setOnClickListener { showConfirmationDialog() }
            editHabit.setOnClickListener { editHabitDrinkingItem() }
        }
    }

    private fun habitRunBind() {
        binding.apply {
            imageView.setImageResource(R.drawable.running)
            habitName.text = "Running"
            habitAttr1Label.text = "Date:"
            habitAttr1.text = navigationArgs.habitField1
            habitAttr2Label.text = "Time:"
            habitAttr2.text = navigationArgs.habitField2
            habitAttr3Label.text = "Distance:"
            habitAttr3.text = navigationArgs.habitField3

            deleteHabit.setOnClickListener { showConfirmationDialog() }
            editHabit.setOnClickListener { editHabitDrinkingItem() }
        }
    }

    private fun habitYogaBind() {
        binding.apply {
            imageView.setImageResource(R.drawable.yoga)
            habitName.text = "Yoga"
            habitAttr1Label.text = "Date:"
            habitAttr1.text = navigationArgs.habitField1
            habitAttr2Label.text = "Time:"
            habitAttr2.text = navigationArgs.habitField2
            habitAttr3Label.text = "Duration:"
            habitAttr3.text = navigationArgs.habitField3

            deleteHabit.setOnClickListener { showConfirmationDialog() }
            editHabit.setOnClickListener { editHabitDrinkingItem() }
        }
    }

    private fun habitReadingBind() {
        binding.apply {
            imageView.setImageResource(R.drawable.book)
            habitName.text = "Reading"
            habitAttr1Label.text = "Date:"
            habitAttr1.text = navigationArgs.habitField1
            habitAttr2Label.text = "Time:"
            habitAttr2.text = navigationArgs.habitField2
            habitAttr3Label.text = "Duration:"
            habitAttr3.text = navigationArgs.habitField3

            deleteHabit.setOnClickListener { showConfirmationDialog() }
            editHabit.setOnClickListener { editHabitDrinkingItem() }
        }
    }

    private fun habitMeditationBind() {
        binding.apply {
            imageView.setImageResource(R.drawable.meditation)
            habitName.text = "Meditation"
            habitAttr1Label.text = "Date:"
            habitAttr1.text = navigationArgs.habitField1
            habitAttr2Label.text = "Time:"
            habitAttr2.text = navigationArgs.habitField2
            habitAttr3Label.text = "Duration:"
            habitAttr3.text = navigationArgs.habitField3

            deleteHabit.setOnClickListener { showConfirmationDialog() }
            editHabit.setOnClickListener { editHabitDrinkingItem() }
        }
    }

    private fun editHabitDrinkingItem() {
        val action = HabitDetailFragmentDirections.actionHabitDetailFragmentToAddHabitFragment(
            //habitDrikning.id
        )
        this.findNavController().navigate(action)
    }

    private fun deleteHabitItem() {
        Log.e("ID:", navigationArgs.habitId)
        firestoreViewModel.deleteHabitDoc(habitId = navigationArgs.habitId)
        val action = HabitDetailFragmentDirections.actionHabitDetailFragmentToHabitListFragment()
        this.findNavController().navigate(action)
    }

    private fun showConfirmationDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(android.R.string.dialog_alert_title))
            .setMessage(getString(R.string.delete_question))
            .setCancelable(false)
            .setNegativeButton(getString(R.string.no)) { _, _ -> }
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                deleteHabitItem()
            }
            .show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        id = navigationArgs.habitId

        if (id.toLong() in 0..10000000) {
            habitRunBind()
        }

        if (id.toLong() in 10000001..20000000) {
            habitMeditationBind()
        }

        if (id.toLong() in 20000001..30000000) {
            habitReadingBind()
        }

        if (id.toLong() in 30000001..40000000) {
            habitSleepBind()
        }

        if (id.toLong() in 40000001..50000000) {
            habitDrinkingBind()
        }

        if (id.toLong() in 50000001..60000000) {
            habitYogaBind()
        }

    }


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
//            R.id.action_list -> {
//                checkList()
//                true
//            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    fun logout() {

        val action = HabitListFragmentDirections.actionHabitListFragmentToMainFragment()

        this.findNavController().navigate(action)
        FirebaseAuth.getInstance().signOut()
    }

//    fun checkList() {
//        val action = HabitDetailFragmentDirections.actionHabitDetailFragmentToHabitListFragment()
//        this.findNavController().navigate(action)
//    }
}

