/*
    Date: December 5th, 2021
    Name(s): Qingqing Wu(991500423), Yiqian Chang(991554674)
    Description:HabitListFragment fragment is to display our habits list in the recycler view based on the habit
                type. on this page, we also offer user add function
 */

package finalproject.stN991554423.org.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcelable
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import finalproject.stN991554423.org.R
import finalproject.stN991554423.org.databinding.HabitListFragmentBinding
import finalproject.stN991554423.org.recyclerView.*
import finalproject.stN991554423.org.viewmodel.FirestoreViewModel
import finalproject.stN991554423.org.viewmodel.HabitListViewModel
import android.content.pm.ActivityInfo

import android.app.Activity

const val TAG = "FIRESTORE"

class HabitListFragment : Fragment() {
    // properties
    private var _binding: HabitListFragmentBinding? = null
    private lateinit var viewModel: HabitListViewModel

    private val firestoreViewModel: FirestoreViewModel by activityViewModels()

    // with the backing property of the kotlin we extract
    // the non null value of the _binding
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HabitListFragmentBinding.inflate(inflater, container, false)

        // has menu
        setHasOptionsMenu(true)

        // set up recyclerView
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // button click event to trigger database data fetching
        binding.btnRun.setOnClickListener {
            binding.tvViewList.visibility = View.INVISIBLE
            binding.recyclerView.visibility = View.VISIBLE

            val list = firestoreViewModel.getAllHabitRun()
            binding.habitAttr1Label.text = "Date"
            binding.habitAttr2Label.text = "Time"
            binding.habitAttr3Label.text = "Distance"
            val adapter = HabitRunItemListAdapter {
                val action =
                    HabitListFragmentDirections.actionHabitListFragmentToHabitDetailFragment(
                        it.id,
                        it.runDate,
                        it.runTime,
                        it.runDistance.toString()
                    )
                this.findNavController().navigate(action)
            }
            binding.recyclerView.adapter = adapter
            adapter.submitList(list)
        }

        binding.btnDrinking.setOnClickListener {
            binding.tvViewList.visibility = View.INVISIBLE
            binding.recyclerView.visibility = View.VISIBLE

            val list = firestoreViewModel.getAllHabitDrinking()
            binding.habitAttr1Label.text = "Date"
            binding.habitAttr2Label.text = "Frequency"
            binding.habitAttr3Label.text = "Consumption"
            val adapter = HabitDrinkingItemListAdapter {
                val action =
                    HabitListFragmentDirections.actionHabitListFragmentToHabitDetailFragment(
                        it.id,
                        it.drinkingDate,
                        it.drinkingFrequency.toString(),
                        it.drinkingConsumption.toString()
                    )
                this.findNavController().navigate(action)
            }
            binding.recyclerView.adapter = adapter
            adapter.submitList(list)
        }

        binding.btnMeditation.setOnClickListener {
            binding.tvViewList.visibility = View.INVISIBLE
            binding.recyclerView.visibility = View.VISIBLE

            val list = firestoreViewModel.getAllHabitMeditation()
            binding.habitAttr1Label.text = "Date"
            binding.habitAttr2Label.text = "Time"
            binding.habitAttr3Label.text = "Duration"
            val adapter = HabitMeditationItemListAdapter {
                val action =
                    HabitListFragmentDirections.actionHabitListFragmentToHabitDetailFragment(
                        it.id,
                        it.meditationDate,
                        it.meditationTime,
                        it.meditationDuration.toString()
                    )
                this.findNavController().navigate(action)
            }
            binding.recyclerView.adapter = adapter
            adapter.submitList(list)
        }

        binding.btnReading.setOnClickListener {
            binding.tvViewList.visibility = View.INVISIBLE
            binding.recyclerView.visibility = View.VISIBLE

            val list = firestoreViewModel.getAllHabitReading()
            binding.habitAttr1Label.text = "Date"
            binding.habitAttr2Label.text = "Time"
            binding.habitAttr3Label.text = "Duration"
            val adapter = HabitReadingItemListAdapter {
                val action =
                    HabitListFragmentDirections.actionHabitListFragmentToHabitDetailFragment(
                        it.id,
                        it.readingDate,
                        it.readingTime,
                        it.readingDuration.toString()
                    )
                this.findNavController().navigate(action)
            }
            binding.recyclerView.adapter = adapter
            adapter.submitList(list)
        }

        binding.btnSleep.setOnClickListener {
            binding.tvViewList.visibility = View.INVISIBLE
            binding.recyclerView.visibility = View.VISIBLE

            val list = firestoreViewModel.getAllHabitSleep()
            binding.habitAttr1Label.text = "Date"
            binding.habitAttr2Label.text = "Time"
            binding.habitAttr3Label.text = "Duration"
            val adapter = HabitSleepItemListAdapter {
                val action =
                    HabitListFragmentDirections.actionHabitListFragmentToHabitDetailFragment(
                        it.id,
                        it.sleepDate,
                        it.sleepTime,
                        it.sleepDuration.toString()
                    )
                this.findNavController().navigate(action)
            }
            binding.recyclerView.adapter = adapter
            adapter.submitList(list)
        }

        binding.btnYoga.setOnClickListener {
            binding.tvViewList.visibility = View.INVISIBLE
            binding.recyclerView.visibility = View.VISIBLE

            val list = firestoreViewModel.getAllHabitYoga()
            binding.habitAttr1Label.text = "Date"
            binding.habitAttr2Label.text = "Time"
            binding.habitAttr3Label.text = "Duration"
            val adapter = HabitYogaItemListAdapter {
                val action =
                    HabitListFragmentDirections.actionHabitListFragmentToHabitDetailFragment(
                        it.id,
                        it.yogaDate,
                        it.yogaTime,
                        it.yogaDuration.toString()
                    )
                this.findNavController().navigate(action)
            }
            binding.recyclerView.adapter = adapter
            adapter.submitList(list)
        }

        binding.floatingActionButton.setOnClickListener {
            val action = HabitListFragmentDirections.actionHabitListFragmentToAddHabitFragment(
            )
            this.findNavController().navigate(action)
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

    // navigation to AboutFragment
    private fun displayAboutUs() {
        val action = HabitListFragmentDirections.actionHabitListFragmentToAboutFragment()
        this.findNavController().navigate(action)
    }

    // navigation to HelpFragment
    private fun displayUserGuide() {
        val action = HabitListFragmentDirections.actionHabitListFragmentToHelpFragment()
        this.findNavController().navigate(action)
    }

    // sign out from the app
    private fun logout() {
        val action = HabitListFragmentDirections.actionHabitListFragmentToMainFragment()

        this.findNavController().navigate(action)
        FirebaseAuth.getInstance().signOut()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HabitListViewModel::class.java)

    }

}










