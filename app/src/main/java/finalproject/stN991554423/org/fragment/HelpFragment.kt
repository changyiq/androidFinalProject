/*
    Date: December 5th, 2021
    Name(s): Qingqing Wu(991500423), Yiqian Chang(991554674)
    Description:The help fragment that show users the hint on how to use our app
 */

package finalproject.stN991554423.org.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import finalproject.stN991554423.org.R

class HelpFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_help, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.help_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_display_list -> {
                displayHabitList()
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

    // navigation to HabitListFragment
    private fun displayHabitList() {
        val action = HelpFragmentDirections.actionHelpFragmentToHabitListFragment()
        this.findNavController().navigate(action)
    }

    // navigation to AboutFragment
    private fun displayAboutUs() {
        val action = HelpFragmentDirections.actionHelpFragmentToAboutFragment()
        this.findNavController().navigate(action)
    }

    // sign out from the app
    private fun logout() {
        val action = HabitListFragmentDirections.actionHabitListFragmentToMainFragment()
        this.findNavController().navigate(action)
        FirebaseAuth.getInstance().signOut()
    }
}