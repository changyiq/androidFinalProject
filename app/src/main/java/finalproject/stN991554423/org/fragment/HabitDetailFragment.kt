/*
    Date: December 5th, 2021
    Name(s): Qingqing Wu(991500423), Yiqian Chang(991554674)
    Description:HabitDetailFragment fragment is to show user the detail info about their habit after they
                click on one the the habit item. on the page, we also offer user edit and delete functions
 */

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
import finalproject.stN991554423.org.databinding.FragmentHabitDetailBinding
import finalproject.stN991554423.org.viewmodel.FirestoreViewModel

class HabitDetailFragment : Fragment() {

    private val firestoreViewModel: FirestoreViewModel by activityViewModels()

    private val navigationArgs: HabitDetailFragmentArgs by navArgs()

    private var _binding: FragmentHabitDetailBinding? = null
    private val binding get() = _binding!!

    var id = ""

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

    //------------------binding properties, display different images and data fields----------------//
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
            editHabit.setOnClickListener { editHabitItem() }
        }
    }

    private fun habitSleepBind() {
        binding.apply {
            imageView.setImageResource(R.drawable.waking_up)
            habitName.text = "Sleep Early"
            habitAttr1Label.text = "Date:"
            habitAttr1.text = navigationArgs.habitField1
            habitAttr2Label.text = "Time:"
            habitAttr2.text = navigationArgs.habitField2
            habitAttr3Label.text = "Duration:"
            habitAttr3.text = navigationArgs.habitField3

            deleteHabit.setOnClickListener { showConfirmationDialog() }
            editHabit.setOnClickListener { editHabitItem() }
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
            editHabit.setOnClickListener { editHabitItem() }
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
            editHabit.setOnClickListener { editHabitItem() }
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
            editHabit.setOnClickListener { editHabitItem() }
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
            editHabit.setOnClickListener { editHabitItem() }
        }
    }

    // edit habit
    private fun editHabitItem() {
        Log.e("ID:", navigationArgs.habitId)
        val action = HabitDetailFragmentDirections.actionHabitDetailFragmentToEditHabitFragment(
            navigationArgs.habitId,
            navigationArgs.habitField1,
            navigationArgs.habitField2,
            navigationArgs.habitField3
        )
        this.findNavController().navigate(action)
    }

    // delete habit
    private fun deleteHabitItem() {
        Log.e("ID:", navigationArgs.habitId)
        firestoreViewModel.deleteHabitDoc(habitId = navigationArgs.habitId)
        val action = HabitDetailFragmentDirections.actionHabitDetailFragmentToHabitListFragment()
        this.findNavController().navigate(action)
    }

    // show confirmation dialog when click delete button
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

    // use to retrieve detail data from user click based on the item id
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
        inflater.inflate(R.menu.habit_menu, menu)
    }

    // menu options
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_help -> {
                displayUserGuide()
                true
            }

            R.id.action_about -> {
                displayAboutUs()
                true
            }

            R.id.action_logout -> {
                logout()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    // navigation to HelpFragment
    private fun displayUserGuide() {
        val action = HabitDetailFragmentDirections.actionHabitDetailFragmentToHelpFragment()
        this.findNavController().navigate(action)
    }

    // navigation to AboutFragment
    private fun displayAboutUs() {
        val action = HabitDetailFragmentDirections.actionHabitDetailFragmentToAboutFragment()
        this.findNavController().navigate(action)
    }

    // sign out from the app
    private fun logout() {
        val action = HabitDetailFragmentDirections.actionHabitDetailFragmentToMainFragment()
        this.findNavController().navigate(action)
        FirebaseAuth.getInstance().signOut()
    }
}

