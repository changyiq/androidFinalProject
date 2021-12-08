package finalproject.stN991554423.org.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import finalproject.stN991554423.org.R
import finalproject.stN991554423.org.databinding.FragmentMainBinding
import finalproject.stN991554423.org.viewmodel.LoginViewModel

class MainFragment : Fragment() {

    companion object {
        const val TAG = "MainFragment"
        const val SIGN_IN_RESULT_CODE = 1001
    }

    // Get a reference to the ViewModel scoped to this Fragment
    private val viewModel by viewModels<LoginViewModel>()
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        //binding.welcomeText.text = viewModel.getQuotesToDisplay(requireContext())
        binding.welcomeText.text = "Hi there! "
        binding.authButton.text = getString(R.string.login_btn)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeAuthenticationState()

        binding.authButton.setOnClickListener { launchSignInFlow() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SIGN_IN_RESULT_CODE) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK) {
                // User successfully signed in
                Log.i(
                    TAG,
                    "Successfully signed in user ${FirebaseAuth.getInstance().currentUser?.displayName}!"
                )
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                Log.i(TAG, "Sign in unsuccessful ${response?.error?.errorCode}")
            }
        }
    }

    //Observes the authentication state and changes the UI accordingly.
    private fun observeAuthenticationState() {
        val quoteToDisplay = viewModel.getQuotesToDisplay(requireContext())

        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                // If there is a logged in user direct to habit list
                LoginViewModel.AuthenticationState.AUTHENTICATED -> {
                    val action = MainFragmentDirections.actionMainFragmentToHabitListFragment(
                    )
                    this.findNavController().navigate(action)
//                    binding.welcomeText.text = getQuoteWithPersonalization(quoteToDisplay)
//
//                    binding.authButton.text = getString(R.string.view_list_button_text)
//                    binding.authButton.setOnClickListener {
//                        val action = MainFragmentDirections.actionMainFragmentToHabitListFragment(
//                        )
//                        this.findNavController().navigate(action)
//                    }
                }   // If there is no logged in user: show a login button
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

//    private fun getQuoteWithPersonalization(quote: String): String {
//        return String.format(
//            resources.getString(
//                R.string.welcome_message_authed,
//                FirebaseAuth.getInstance().currentUser?.displayName,
//                quote.substring(0)
//            )
//        )
//    }

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
            ).build(), SIGN_IN_RESULT_CODE
        )
    }
}