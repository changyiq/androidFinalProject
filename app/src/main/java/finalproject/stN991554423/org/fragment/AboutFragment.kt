package finalproject.stN991554423.org.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import finalproject.stN991554423.org.R

class AboutFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.about_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_display_list -> {
                displayHabitList()
                true
            }

            R.id.action_help -> {
                displayUserGuide()
                true
            }

            R.id.action_logout -> {
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun displayHabitList() {
        val action = AboutFragmentDirections.actionAboutFragmentToHabitListFragment()
        this.findNavController().navigate(action)
    }

    private fun displayUserGuide() {
        val action = AboutFragmentDirections.actionAboutFragmentToHelpFragment()
        this.findNavController().navigate(action)
    }

    fun logout() {
        val action = HabitListFragmentDirections.actionHabitListFragmentToMainFragment()
        this.findNavController().navigate(action)
        FirebaseAuth.getInstance().signOut()
    }


}