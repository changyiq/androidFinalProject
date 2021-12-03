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
import finalproject.stN991554423.org.R
import finalproject.stN991554423.org.data.*
import finalproject.stN991554423.org.databinding.FragmentAddHabitBinding
import finalproject.stN991554423.org.viewmodel.FirestoreViewModel
import org.w3c.dom.Text
import kotlin.collections.HashMap

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddHabitFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddHabitFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    // Binding object instance corresponding to the fragment_add_item.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment
    private var _binding: FragmentAddHabitBinding? = null
    private val binding get() = _binding!!

    private val firestoreViewModel: FirestoreViewModel by activityViewModels()


//    var habitArray = this.context?.resources?.getStringArray(R.array.habit_array)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
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
        spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("error")
            }

            // change textfiled label based on the habit type
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                type = parent?.getItemAtPosition(position).toString()
                if (type == "Run"){
                    fieldLabel1.text = "Date:"
                    fieldLabel2.text = "Time:"
                    fieldLabel3.text = "Distance:"
                }else if (type == "Meditation"){
                    fieldLabel1.text = "Date:"
                    fieldLabel2.text = "Time:"
                    fieldLabel3.text = "Duration:"
                }else if (type == "Reading"){
                    fieldLabel1.text = "Date:"
                    fieldLabel2.text = "Time:"
                    fieldLabel3.text = "Duration:"
                }else if (type == "Sleep"){
                    fieldLabel1.text = "Date:"
                    fieldLabel2.text = "Time:"
                    fieldLabel3.text = "Duration:"
                }else if (type == "Drinking"){
                    fieldLabel1.text = "Date:"
                    fieldLabel2.text = "Frequency:"
                    fieldLabel3.text = "Consumption:"
                }else if (type == "Yoga"){
                    fieldLabel1.text = "Date:"
                    fieldLabel2.text = "Time:"
                    fieldLabel3.text = "Duration:"
                }

            }

        }

        // save data into firestore
        binding.saveAction.setOnClickListener {
            val action = AddHabitFragmentDirections.actionAddHabitFragmentToHabitListFragment(
            )

            if (type == "Run"){
                val habitRun = HabitRun()
                habitRun.userId = 1
                habitRun.runDate = inputField1.text.toString()
                habitRun.runTime = inputField2.text.toString()
                habitRun.runDistance = inputField3.text.toString().toDouble()
                firestoreViewModel.saveRunToFirebase(habitRun)
            }else if (type == "Meditation"){
                val habitMeditation = HabitMeditation()
                habitMeditation.userId = 1
                habitMeditation.meditationDate = inputField1.text.toString()
                habitMeditation.meditationTime = inputField2.text.toString()
                habitMeditation.meditationDuration = inputField3.text.toString().toDouble()
                firestoreViewModel.saveMeditationToFirebase(habitMeditation)
            }else if (type == "Reading"){
                val habitReading = HabitReading()
                habitReading.userId = 1
                habitReading.readingDate = inputField1.text.toString()
                habitReading.readingTime = inputField2.text.toString()
                habitReading.readingDuration = inputField3.text.toString().toDouble()
                firestoreViewModel.saveReadingToFirebase(habitReading)
            }else if (type == "Sleep"){
                val habitSleep = HabitSleep()
                habitSleep.userId = 1
                habitSleep.sleepDate = inputField1.text.toString()
                habitSleep.sleepTime = inputField2.text.toString()
                habitSleep.sleepDuration = inputField3.text.toString().toDouble()
                firestoreViewModel.saveSleepToFirebase(habitSleep)
            }else if (type == "Drinking"){
                val habitDrinking = HabitDrinking()
                habitDrinking.userId = 1
                habitDrinking.drinkingDate = inputField1.text.toString()
                habitDrinking.drinkingFrequency = inputField2.text.toString().toInt()
                habitDrinking.drinkingConsumption = inputField3.text.toString().toDouble()
                firestoreViewModel.saveDrinkingToFirebase(habitDrinking)
            }else if (type == "Yoga"){
                val habitYoga = HabitYoga()
                habitYoga.userId = 1
                habitYoga.yogaDate = inputField1.text.toString()
                habitYoga.yogaTime = inputField2.text.toString()
                habitYoga.yogaDuration = inputField3.text.toString().toDouble()
                firestoreViewModel.saveYogaToFirebase(habitYoga)
            }

            // navigate back to list fragment
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddHabitFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddHabitFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
//
//    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//        TODO("Not yet implemented")
//    }
//
//    override fun onNothingSelected(p0: AdapterView<*>?) {
//        TODO("Not yet implemented")
//    }
}