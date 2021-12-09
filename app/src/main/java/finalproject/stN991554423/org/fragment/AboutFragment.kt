/*
    Date: December 5th, 2021
    Name(s): Qingqing Wu(991500423), Yiqian Chang(991554674)
    Description:The about fragment that shows users the programmers' information
 */

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
        // add options menu
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.about_menu, menu)
    }

    // menu options
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

    // navigation to HabitListFragment
    private fun displayHabitList() {
        val action = AboutFragmentDirections.actionAboutFragmentToHabitListFragment()
        this.findNavController().navigate(action)
    }

    // navigation to HelpFragment
    private fun displayUserGuide() {
        val action = AboutFragmentDirections.actionAboutFragmentToHelpFragment()
        this.findNavController().navigate(action)
    }

    // sign out from the app
    private fun logout() {
        val action = AboutFragmentDirections.actionAboutFragmentToMainFragment()
        this.findNavController().navigate(action)
        FirebaseAuth.getInstance().signOut()
    }
}