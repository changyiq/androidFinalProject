/*
    Date: December 5th, 2021
    Name(s): Qingqing Wu(991500423), Yiqian Chang(991554674)
    Description:AddHabitFragment fragment is to provide user function to add a new habit under specific type.
                all field has data validation.
 */

package finalproject.stN991554423.org.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import finalproject.stN991554423.org.R
import finalproject.stN991554423.org.data.*
import finalproject.stN991554423.org.databinding.FragmentAddHabitBinding
import finalproject.stN991554423.org.viewmodel.FirestoreViewModel

class AddHabitFragment() : Fragment() {

    private val firestoreViewModel: FirestoreViewModel by activityViewModels()

    private var _binding: FragmentAddHabitBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddHabitBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*
            Spinner adpater
         */
        val spinner: Spinner = binding.habitType
        val fieldLabel1: TextView = binding.tvAttr1
        val fieldLabel2: TextView = binding.tvAttr2
        val fieldLabel3: TextView = binding.tvAttr3
        val inputField1: TextView = binding.habitAttr1
        val inputField2: TextView = binding.habitAttr2
        val inputField3: TextView = binding.habitAttr3
        var type = ""

        this.activity?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.habit_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }
        }

        spinner.setSelection(0)

        // spinner setOnItemClickEvent
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("error")
            }

            // change textfiled label based on the habit type
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                type = parent?.getItemAtPosition(position).toString()
                if (type == "Run") {
                    fieldLabel1.text = "Date:"
                    fieldLabel2.text = "Time:"
                    fieldLabel3.text = "Distance:"
                } else if (type == "Meditation") {
                    fieldLabel1.text = "Date:"
                    fieldLabel2.text = "Time:"
                    fieldLabel3.text = "Duration:"
                } else if (type == "Reading") {
                    fieldLabel1.text = "Date:"
                    fieldLabel2.text = "Time:"
                    fieldLabel3.text = "Duration:"
                } else if (type == "Sleep") {
                    fieldLabel1.text = "Date:"
                    fieldLabel2.text = "Time:"
                    fieldLabel3.text = "Duration:"
                } else if (type == "Drinking") {
                    fieldLabel1.text = "Date:"
                    fieldLabel2.text = "Frequency:"
                    fieldLabel3.text = "Consumption:"
                } else if (type == "Yoga") {
                    fieldLabel1.text = "Date:"
                    fieldLabel2.text = "Time:"
                    fieldLabel3.text = "Duration:"
                }

            }
        }

        // save data into firestore
        binding.saveAction.setOnClickListener {

            if (type == "Run") {
                if (!inputField1.text.isNullOrEmpty() && !inputField2.text.isNullOrEmpty() && !inputField3.text.isNullOrEmpty()) {
                    val habitRun = HabitRun()
                    habitRun.runDate = inputField1.text.toString().format()
                    habitRun.runTime = inputField2.text.toString().format()
                    habitRun.runDistance = inputField3.text.toString().toDouble()
                    habitRun.id = (0..10000000).random().toString()
                    firestoreViewModel.saveRunToFirebase(habitRun)
                    val action =
                        AddHabitFragmentDirections.actionAddHabitFragmentToHabitListFragment()
                    this.findNavController().navigate(action)
                } else {
                    Toast.makeText(activity, "Please input valid data", Toast.LENGTH_SHORT).show();
                }
            }

            if (type == "Meditation") {
                if (!inputField1.text.isNullOrEmpty() && !inputField2.text.isNullOrEmpty() && !inputField3.text.isNullOrEmpty()) {
                    val habitMeditation = HabitMeditation()
                    habitMeditation.meditationDate = inputField1.text.toString().format()
                    habitMeditation.meditationTime = inputField2.text.toString().format()
                    habitMeditation.meditationDuration = inputField3.text.toString().toDouble()
                    habitMeditation.id = (10000001..20000000).random().toString()
                    firestoreViewModel.saveMeditationToFirebase(habitMeditation)
                    val action =
                        AddHabitFragmentDirections.actionAddHabitFragmentToHabitListFragment()
                    this.findNavController().navigate(action)
                } else {
                    Toast.makeText(activity, "Please input valid data", Toast.LENGTH_SHORT).show();
                }
            }

            if (type == "Reading") {
                if (!inputField1.text.isNullOrEmpty() && !inputField2.text.isNullOrEmpty() && !inputField3.text.isNullOrEmpty()) {
                    val habitReading = HabitReading()
                    habitReading.readingDate = inputField1.text.toString().format()
                    habitReading.readingTime = inputField2.text.toString().format()
                    habitReading.readingDuration = inputField3.text.toString().toDouble()
                    habitReading.id = (20000001..30000000).random().toString()
                    firestoreViewModel.saveReadingToFirebase(habitReading)
                    val action =
                        AddHabitFragmentDirections.actionAddHabitFragmentToHabitListFragment()
                    this.findNavController().navigate(action)
                } else {
                    Toast.makeText(activity, "Please input valid data", Toast.LENGTH_SHORT).show();
                }
            }

            if (type == "Sleep") {
                if (!inputField1.text.isNullOrEmpty() && !inputField2.text.isNullOrEmpty() && !inputField3.text.isNullOrEmpty()) {
                    val habitSleep = HabitSleep()
                    habitSleep.sleepDate = inputField1.text.toString().format()
                    habitSleep.sleepTime = inputField2.text.toString().format()
                    habitSleep.sleepDuration = inputField3.text.toString().toDouble()
                    habitSleep.id = (30000001..40000000).random().toString()
                    firestoreViewModel.saveSleepToFirebase(habitSleep)
                    val action =
                        AddHabitFragmentDirections.actionAddHabitFragmentToHabitListFragment()
                    this.findNavController().navigate(action)
                } else {
                    Toast.makeText(activity, "Please input valid data", Toast.LENGTH_SHORT).show();
                }
            }

            if (type == "Drinking") {
                if(!inputField1.text.isNullOrEmpty() && !inputField2.text.isNullOrEmpty() && !inputField3.text.isNullOrEmpty()) {
                    if (!inputField2.text.matches("-?\\d+(\\.\\d+)?".toRegex())) {
                        Toast.makeText(
                            activity,
                            "Please enter numeric value for frequency",
                            Toast.LENGTH_SHORT
                        ).show();
                    } else {
                        val habitDrinking = HabitDrinking()
                        habitDrinking.drinkingDate = inputField1.text.toString().format()
                        habitDrinking.drinkingFrequency = inputField2.text.toString().toInt()
                        habitDrinking.drinkingConsumption = inputField3.text.toString().toDouble()
                        habitDrinking.id = (40000001..50000000).random().toString()
                        firestoreViewModel.saveDrinkingToFirebase(habitDrinking)
                        val action =
                            AddHabitFragmentDirections.actionAddHabitFragmentToHabitListFragment()
                        this.findNavController().navigate(action)
                    }
                } else {
                    Toast.makeText(activity, "Please input valid data", Toast.LENGTH_SHORT).show();
                }

            }

            if (type == "Yoga") {
                if (!inputField1.text.isNullOrEmpty() && !inputField2.text.isNullOrEmpty() && !inputField3.text.isNullOrEmpty()) {
                    val habitYoga = HabitYoga()
                    habitYoga.yogaDate = inputField1.text.toString().format()
                    habitYoga.yogaTime = inputField2.text.toString().format()
                    habitYoga.yogaDuration = inputField3.text.toString().toDouble()
                    habitYoga.id = (50000001..60000000).random().toString()
                    firestoreViewModel.saveYogaToFirebase(habitYoga)
                    val action =
                        AddHabitFragmentDirections.actionAddHabitFragmentToHabitListFragment()
                    this.findNavController().navigate(action)
                } else {
                    Toast.makeText(activity, "Please input valid data", Toast.LENGTH_SHORT).show();
                }
            }
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