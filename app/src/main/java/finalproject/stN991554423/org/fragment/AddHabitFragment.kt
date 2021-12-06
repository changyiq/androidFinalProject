package finalproject.stN991554423.org.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import finalproject.stN991554423.org.R
import finalproject.stN991554423.org.data.*
import finalproject.stN991554423.org.databinding.FragmentAddHabitBinding
import finalproject.stN991554423.org.viewmodel.FirestoreViewModel


class AddHabitFragment() : Fragment() {

    private val firestoreViewModel: FirestoreViewModel by activityViewModels()

    private val navigationArgs: HabitDetailFragmentArgs by navArgs()

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
        var type: String = ""

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
                val habitRun = HabitRun()
                habitRun.runDate = inputField1.text.toString()
                habitRun.runTime = inputField2.text.toString()
                habitRun.runDistance = inputField3.text.toString().toDouble()
                habitRun.id = (0..10000000).random().toString()
                firestoreViewModel.saveRunToFirebase(habitRun)
            } else if (type == "Meditation") {
                val habitMeditation = HabitMeditation()
                habitMeditation.meditationDate = inputField1.text.toString()
                habitMeditation.meditationTime = inputField2.text.toString()
                habitMeditation.meditationDuration = inputField3.text.toString().toDouble()
                habitMeditation.id = (10000001..20000000).random().toString()
                firestoreViewModel.saveMeditationToFirebase(habitMeditation)
            } else if (type == "Reading") {
                val habitReading = HabitReading()
                habitReading.readingDate = inputField1.text.toString()
                habitReading.readingTime = inputField2.text.toString()
                habitReading.readingDuration = inputField3.text.toString().toDouble()
                habitReading.id = (20000001..30000000).random().toString()
                firestoreViewModel.saveReadingToFirebase(habitReading)
            } else if (type == "Sleep") {
                val habitSleep = HabitSleep()
                habitSleep.sleepDate = inputField1.text.toString()
                habitSleep.sleepTime = inputField2.text.toString()
                habitSleep.sleepDuration = inputField3.text.toString().toDouble()
                habitSleep.id = (30000001..40000000).random().toString()
                firestoreViewModel.saveSleepToFirebase(habitSleep)
            } else if (type == "Drinking") {
                val habitDrinking = HabitDrinking()
                habitDrinking.drinkingDate = inputField1.text.toString()
                habitDrinking.drinkingFrequency = inputField2.text.toString().toInt()
                habitDrinking.drinkingConsumption = inputField3.text.toString().toDouble()
                habitDrinking.id = (40000001..50000000).random().toString()
                firestoreViewModel.saveDrinkingToFirebase(habitDrinking)

            } else if (type == "Yoga") {
                val habitYoga = HabitYoga()
                habitYoga.yogaDate = inputField1.text.toString()
                habitYoga.yogaTime = inputField2.text.toString()
                habitYoga.yogaDuration = inputField3.text.toString().toDouble()
                habitYoga.id = (50000001..60000000).random().toString()
                firestoreViewModel.saveYogaToFirebase(habitYoga)
            }
            val action = AddHabitFragmentDirections.actionAddHabitFragmentToHabitListFragment()
            // navigate back to list fragment
            this.findNavController().navigate(action)
        }

//        fun updateHabitDrinkingDoc() {
//
//            if (type == "Drinking") {
//                val habitDrinking = HabitDrinking()
//                habitDrinking.drinkingDate = inputField1.text.toString()
//                habitDrinking.drinkingFrequency = inputField2.text.toString().toInt()
//                habitDrinking.drinkingConsumption = inputField3.text.toString().toDouble()
//                habitDrinking.id = (40000001..50000000).random().toString()
//                this.navigationArgs.habitId
//                firestoreViewModel.updateHabitDrinking(habitId = navigationArgs.habitId, )
//                val action = AddHabitFragmentDirections.actionAddHabitFragmentToHabitListFragment()
//                // navigate back to list fragment
//                this.findNavController().navigate(action)
//            }
//        }

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