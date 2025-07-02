package com.exemple.appfog.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.exemple.appfog.R
import com.exemple.appfog.databinding.FragmentHomeBinding
import com.exemple.appfog.databinding.FragmentLoginBinding
import com.exemple.appfog.util.showBottomSheet
import kotlin.toString


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener(){
        binding.BTLogin.setOnClickListener {
            validateData()
        }

        binding.imageButton4.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment2_to_infoFragment2)
        }

        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment2_to_registerFragment)
        }
    }
    private fun validateData(){
        val email = binding.EDEmail.text.toString().trim()
        val senha = binding.EDSenha.text.toString().trim()
        if (email.isNotBlank()){
            if (senha.isNotBlank()){
                findNavController().navigate(R.id.action_loginFragment2_to_homeFragment2)
            }else{
                showBottomSheet(message = getString(R.string.password_empty))
            }
        }else{
            showBottomSheet(message = getString(R.string.email_empty))

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}