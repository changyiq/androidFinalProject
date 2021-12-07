package finalproject.stN991554423.org.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import finalproject.stN991554423.org.R
import finalproject.stN991554423.org.data.*
import finalproject.stN991554423.org.databinding.FragmentAddHabitBinding
import finalproject.stN991554423.org.databinding.FragmentEditHabitBinding
import finalproject.stN991554423.org.viewmodel.FirestoreViewModel

class EditHabitFragment : Fragment() {

    private val firestoreViewModel: FirestoreViewModel by activityViewModels()
    private val navigationArgs: EditHabitFragmentArgs by navArgs()

    // binding
    private var _binding: FragmentEditHabitBinding? = null
    private val binding get() = _binding!!

    // properties
    var habitId = ""
    var field1 = ""
    var field2 = ""
    var field3 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun getHabitBind() {
        binding.apply {
            habitId = navigationArgs.habitId
            field1 = navigationArgs.habitField1
            field2 = navigationArgs.habitField2
            field3 = navigationArgs.habitField3
            when {
                habitId.toLong() in 0..10000000 -> {
                    tvType.text = "Run"
                    tvAttr1.text = "Date"
                    habitAttr1.setText(field1)
                    tvAttr2.text = "Time:"
                    habitAttr2.setText(field2)
                    tvAttr3.text = "Distance:"
                    habitAttr3.setText(field3)
                }
                habitId.toLong() in 10000001..20000000 -> {
                    tvType.text = "Meditation"
                    tvAttr1.text = "Date"
                    habitAttr1.setText(field1)
                    tvAttr2.text = "Time:"
                    habitAttr2.setText(field2)
                    tvAttr3.text = "Duration:"
                    habitAttr3.setText(field3)
                }
                habitId.toLong() in 20000001..30000000 -> {
                    tvType.text = "Reading"
                    tvAttr1.text = "Date"
                    habitAttr1.setText(field1)
                    tvAttr2.text = "Time:"
                    habitAttr2.setText(field2)
                    tvAttr3.text = "Duration:"
                    habitAttr3.setText(field3)
                }
                habitId.toLong() in 30000001..40000000 -> {
                    tvType.text = "Sleep"
                    tvAttr1.text = "Date"
                    habitAttr1.setText(field1)
                    tvAttr2.text = "Time:"
                    habitAttr2.setText(field2)
                    tvAttr3.text = "Duration:"
                    habitAttr3.setText(field3)
                }
                habitId.toLong() in 40000001..50000000 -> {
                    tvType.text = "Drinking"
                    tvAttr1.text = "Date"
                    habitAttr1.setText(field1)
                    tvAttr2.text = "Frequency:"
                    habitAttr2.setText(field2)
                    tvAttr3.text = "Consumption:"
                    habitAttr3.setText(field3)
                }
                habitId.toLong() in 50000001..60000000 -> {
                    tvType.text = "Yoga"
                    tvAttr1.text = "Date"
                    habitAttr1.setText(field1)
                    tvAttr2.text = "Time:"
                    habitAttr2.setText(field2)
                    tvAttr3.text = "Duration:"
                    habitAttr3.setText(field3)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditHabitBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputField1: TextView = binding.habitAttr1
        val inputField2: TextView = binding.habitAttr2
        val inputField3: TextView = binding.habitAttr3

        getHabitBind()

        binding.saveAction.setOnClickListener{
            if (binding.tvType.text == "Run"){
                val habitRun = HabitRun()
                habitRun.id = habitId
                habitRun.runDate = inputField1.text.toString()
                habitRun.runTime = inputField2.text.toString()
                habitRun.runDistance = inputField3.text.toString().toDouble()
                firestoreViewModel.updateHabitRun(habitId, habitRun)
            }
            if (binding.tvType.text == "Meditation"){
                val habitMeditation = HabitMeditation()
                habitMeditation.id = habitId
                habitMeditation.meditationDate = inputField1.text.toString()
                habitMeditation.meditationTime = inputField2.text.toString()
                habitMeditation.meditationDuration = inputField3.text.toString().toDouble()
                firestoreViewModel.updateHabitMeditation(habitId, habitMeditation)
            }
            if (binding.tvType.text == "Sleep"){
                val habitSleep = HabitSleep()
                habitSleep.id = habitId
                habitSleep.sleepDate = inputField1.text.toString()
                habitSleep.sleepTime = inputField2.text.toString()
                habitSleep.sleepDuration = inputField3.text.toString().toDouble()
                firestoreViewModel.updateHabitSleep(habitId, habitSleep)
            }
            if (binding.tvType.text == "Reading"){
                val habitReading = HabitReading()
                habitReading.id = habitId
                habitReading.readingDate = inputField1.text.toString()
                habitReading.readingTime = inputField2.text.toString()
                habitReading.readingDuration = inputField3.text.toString().toDouble()
                firestoreViewModel.updateHabitReading(habitId, habitReading)
            }
            if (binding.tvType.text == "Drinking"){
                val habitDrinking = HabitDrinking()
                habitDrinking.id = habitId
                habitDrinking.drinkingDate = inputField1.text.toString()
                habitDrinking.drinkingFrequency = inputField2.text.toString().toInt()
                habitDrinking.drinkingConsumption = inputField3.text.toString().toDouble()
                firestoreViewModel.updateHabitDrinking(habitId, habitDrinking)
            }
            if (binding.tvType.text == "Yoga"){
                val habitYoga = HabitYoga()
                habitYoga.id = habitId
                habitYoga.yogaDate = inputField1.text.toString()
                habitYoga.yogaTime = inputField2.text.toString()
                habitYoga.yogaDuration = inputField3.text.toString().toDouble()
                firestoreViewModel.updateHabitYoga(habitId, habitYoga)
            }
            val action = EditHabitFragmentDirections.actionEditHabitFragmentToHabitListFragment()
            this.findNavController().navigate(action)
        }
    }

    /**
     * Called before fragment is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        // Hide keyboard.
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as
                InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
        _binding = null
    }

}