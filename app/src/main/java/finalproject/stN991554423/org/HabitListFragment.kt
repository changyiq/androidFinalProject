package finalproject.stN991554423.org

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import finalproject.stN991554423.org.databinding.FragmentMainBinding
import finalproject.stN991554423.org.viewmodel.HabitListViewModel
import finalproject.stN991554423.org.viewmodel.LoginViewModel

class HabitListFragment : Fragment() {

    companion object {
        fun newInstance() = HabitListFragment()
    }

    private lateinit var viewModel: HabitListViewModel
    private val loginViewModel by viewModels<LoginViewModel>()


    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.habit_list_fragment, container, false)

        binding = DataBindingUtil.inflate(inflater, R.layout.habit_list_fragment, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return NavigationUI.onNavDestinationSelected(
            item!!,
            requireView().findNavController()
        )
                || super.onOptionsItemSelected(item)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HabitListViewModel::class.java)
        // TODO: Use the ViewModel
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MainFragment.SIGN_IN_RESULT_CODE) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK) {
                // User successfully signed in
                Log.i(
                    MainFragment.TAG,
                    "Successfully signed in user ${FirebaseAuth.getInstance().currentUser?.displayName}!"
                )
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                Log.i(MainFragment.TAG, "Sign in unsuccessful ${response?.error?.errorCode}")
            }
        }
    }

    /**
     * Observes the authentication state and changes the UI accordingly.
     * If there is a logged in user: (1) show a logout button and (2) display their name.
     * If there is no logged in user: show a login button
     */
    private fun observeAuthenticationState() {
        val quoteToDisplay = loginViewModel.getQuotesToDisplay(requireContext())

        loginViewModel.authenticationState.observe(
            viewLifecycleOwner,
            Observer { authenticationState ->
                when (authenticationState) {
                    LoginViewModel.AuthenticationState.AUTHENTICATED -> {

                        binding.authButton.text = getString(R.string.logout_button_text)
                        binding.authButton.setOnClickListener {
                            AuthUI.getInstance().signOut(requireContext())
                        }
                    }
                    else -> {
                        binding.welcomeText.text = quoteToDisplay

                        binding.authButton.text = getString(R.string.login_button_text)
                        binding.authButton.setOnClickListener {
                            launchSignInFlow()
                        }
                    }
                }
            })
    }


    private fun getFactWithPersonalization(quote: String): String {
        return String.format(
            resources.getString(
                R.string.welcome_message_authed,
                FirebaseAuth.getInstance().currentUser?.displayName,
                Character.toLowerCase(quote[0]) + quote.substring(1)
            )
        )
    }

    private fun launchSignInFlow() {
        // Give users the option to sign in / register with their email
        // If users choose to register with their email,
        // they will need to create a password as well
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build()
            //
        )

        // Create and launch sign-in intent.
        // We listen to the response of this activity with the
        // SIGN_IN_RESULT_CODE code
        startActivityForResult(
            AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(
                providers
            ).build(), MainFragment.SIGN_IN_RESULT_CODE
        )
    }
}