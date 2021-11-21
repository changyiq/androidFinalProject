package finalproject.stN991554423.org

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import finalproject.stN991554423.org.viewmodel.HabitListViewModel

class HabitListFragment : Fragment() {

    companion object {
        fun newInstance() = HabitListFragment()
    }

    private lateinit var viewModel: HabitListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.habit_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HabitListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}