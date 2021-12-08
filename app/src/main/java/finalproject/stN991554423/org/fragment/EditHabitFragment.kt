/*
    Date: December 5th, 2021
    Name(s): Qingqing Wu(991500423), Yiqian Chang(991554674)
    Description:EditHabitFragment fragment is to provide user function to edit their habit information. they will see the previous
                data of that habit, and feel free to edit it.
 */

package finalproject.stN991554423.org.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import finalproject.stN991554423.org.data.*
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

    // function to retrieve the value for each field
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

        // fields declaration
        val inputField1: TextView = binding.habitAttr1
        val inputField2: TextView = binding.habitAttr2
        val inputField3: TextView = binding.habitAttr3

        getHabitBind()

        // save action
        binding.saveAction.setOnClickListener {

            // perform if the if statement is true
            if (binding.tvType.text == "Run") {
                if (!inputField1.text.isNullOrEmpty() && !inputField2.text.isNullOrEmpty() && !inputField3.text.isNullOrEmpty()) {
                    val habitRun = HabitRun()
                    habitRun.id = habitId
                    habitRun.runDate = inputField1.text.toString()
                    habitRun.runTime = inputField2.text.toString()
                    habitRun.runDistance = inputField3.text.toString().toDouble()
                    firestoreViewModel.updateHabitRun(habitId, habitRun)
                } else {
                    Toast.makeText(activity, "Please input valid data", Toast.LENGTH_SHORT).show();
                }
            }
            if (binding.tvType.text == "Meditation") {
                if (!inputField1.text.isNullOrEmpty() && !inputField2.text.isNullOrEmpty() && !inputField3.text.isNullOrEmpty()) {
                    val habitMeditation = HabitMeditation()
                    habitMeditation.id = habitId
                    habitMeditation.meditationDate = inputField1.text.toString()
                    habitMeditation.meditationTime = inputField2.text.toString()
                    habitMeditation.meditationDuration = inputField3.text.toString().toDouble()
                    firestoreViewModel.updateHabitMeditation(habitId, habitMeditation)
                } else {
                    Toast.makeText(activity, "Please input valid data", Toast.LENGTH_SHORT).show();
                }
            }
            if (binding.tvType.text == "Sleep") {
                if (!inputField1.text.isNullOrEmpty() && !inputField2.text.isNullOrEmpty() && !inputField3.text.isNullOrEmpty()) {
                    val habitSleep = HabitSleep()
                    habitSleep.id = habitId
                    habitSleep.sleepDate = inputField1.text.toString()
                    habitSleep.sleepTime = inputField2.text.toString()
                    habitSleep.sleepDuration = inputField3.text.toString().toDouble()
                    firestoreViewModel.updateHabitSleep(habitId, habitSleep)
                } else {
                    Toast.makeText(activity, "Please input valid data", Toast.LENGTH_SHORT).show();
                }
            }
            if (binding.tvType.text == "Reading") {
                if (!inputField1.text.isNullOrEmpty() && !inputField2.text.isNullOrEmpty() && !inputField3.text.isNullOrEmpty()) {
                    val habitReading = HabitReading()
                    habitReading.id = habitId
                    habitReading.readingDate = inputField1.text.toString()
                    habitReading.readingTime = inputField2.text.toString()
                    habitReading.readingDuration = inputField3.text.toString().toDouble()
                    firestoreViewModel.updateHabitReading(habitId, habitReading)
                } else {
                    Toast.makeText(activity, "Please input valid data", Toast.LENGTH_SHORT).show();
                }
            }
            if (binding.tvType.text == "Drinking") {
                if (!inputField1.text.isNullOrEmpty() && !inputField2.text.isNullOrEmpty() && !inputField3.text.isNullOrEmpty()) {
                    if (!inputField2.text.matches("-?\\d+(\\.\\d+)?".toRegex())) {
                        Toast.makeText(
                            activity,
                            "Please enter numeric value for frequency",
                            Toast.LENGTH_SHORT
                        ).show();
                    } else {
                        val habitDrinking = HabitDrinking()
                        habitDrinking.id = habitId
                        habitDrinking.drinkingDate = inputField1.text.toString()
                        habitDrinking.drinkingFrequency = inputField2.text.toString().toInt()
                        habitDrinking.drinkingConsumption = inputField3.text.toString().toDouble()
                        firestoreViewModel.updateHabitDrinking(habitId, habitDrinking)
                    }
                } else {
                    Toast.makeText(
                        activity,
                        "Please input valid data",
                        android.widget.Toast.LENGTH_SHORT
                    ).show();
                }
            }
            if (binding.tvType.text == "Yoga") {
                if (!inputField1.text.isNullOrEmpty() && !inputField2.text.isNullOrEmpty() && !inputField3.text.isNullOrEmpty()) {

                    val habitYoga = HabitYoga()
                    habitYoga.id = habitId
                    habitYoga.yogaDate = inputField1.text.toString()
                    habitYoga.yogaTime = inputField2.text.toString()
                    habitYoga.yogaDuration = inputField3.text.toString().toDouble()
                    firestoreViewModel.updateHabitYoga(habitId, habitYoga)
                } else {
                    Toast.makeText(activity, "Please input valid data", Toast.LENGTH_SHORT).show();
                }
            }

            // action/navigation back to the HabitListFragment after edit
            val action =
                EditHabitFragmentDirections.actionEditHabitFragmentToHabitListFragment()
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