package br.com.rodrigolmti.vibbra.ui.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.findNavController
import br.com.rodrigolmti.vibbra.R
import br.com.rodrigolmti.vibbra.core.extensions.hide
import br.com.rodrigolmti.vibbra.core.extensions.hideKeyboard
import br.com.rodrigolmti.vibbra.core.extensions.show
import br.com.rodrigolmti.vibbra.core.view_binding_delegate.viewBinding
import br.com.rodrigolmti.vibbra.databinding.FragmentSignInBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
internal class SignInFragment : Fragment() {

    private val viewModel: SignInViewModel by viewModels()

    private val binding by viewBinding {
        FragmentSignInBinding.inflate(layoutInflater)
    }

    private val login
        get() = binding.etLogin.text.toString()

    private val password
        get() = binding.etPassword.text.toString()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        observeChanges()
        binding.btnAction.setOnClickListener {
            doLogin()

        }
        binding.etPassword.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                doLogin()
            }

            false
        }
        binding.tbAction.setOnClickListener {
            viewModel.dispatchViewAction(
                SignInAction.DoSSOLogin(
                    login,
                    password
                )
            )
        }
    }

    private fun doLogin() {
        binding.root.hideKeyboard()
        viewModel.dispatchViewAction(
            SignInAction.DoLogin(
                login,
                password
            )
        )
    }

    private fun observeChanges() {
        viewModel.viewState.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                SignInViewState.State.IDLE -> {
                    hideLoading()
                }
                SignInViewState.State.LOADING -> {
                    showLoading()
                }
            }
        }
        viewModel.viewState.action.observe(viewLifecycleOwner) { action ->
            when (action) {
                SignInViewState.Action.InvalidLogin -> {
                    binding.ilLogin.error = getString(R.string.sign_in_screen_login_error)
                }
                SignInViewState.Action.InvalidPassword -> {
                    binding.ilPassword.error = getString(R.string.sign_in_screen_password_error)
                }
                SignInViewState.Action.ResetFieldError -> {
                    binding.ilLogin.error = null
                    binding.ilLogin.error = null
                }
                SignInViewState.Action.ShowError -> {
                    Snackbar
                        .make(
                            binding.root,
                            getString(R.string.sign_in_screen_error),
                            Snackbar.LENGTH_LONG
                        )
                        .show()
                }
                SignInViewState.Action.SuccessLogin -> {
                    findNavController(this).navigate(
                        R.id.action_signInFragment_to_dashboardFragment
                    )
                }
            }
        }
    }

    private fun hideLoading() {
        binding.ilLogin.show()
        binding.ilPassword.show()
        binding.tvTitle.show()
        binding.btnAction.show()
        binding.tbAction.show()
        binding.orLabel.show()

        binding.progressBar.hide()
    }

    private fun showLoading() {
        binding.ilLogin.hide()
        binding.ilPassword.hide()
        binding.tvTitle.hide()
        binding.btnAction.hide()
        binding.tbAction.hide()
        binding.orLabel.hide()

        binding.progressBar.show()
    }
}