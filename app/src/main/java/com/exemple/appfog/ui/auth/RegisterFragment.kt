package com.exemple.appfog.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.exemple.appfog.R
import com.exemple.appfog.databinding.FragmentRegisterBinding
import com.exemple.appfog.util.setBackAction
import com.exemple.appfog.util.showBottomSheet


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.BTVoltar.setBackAction(this)


        initRegister()
    }

    private fun initRegister() {
        binding.BTRegister.setOnClickListener {
            ValidaRegister()
        }

    }
    private fun ValidaRegister(){
        val email = binding.EDEmail.text.toString().trim()
        val senha = binding.EDSenha.text.toString().trim()
        val usuario = binding.EDUsuario.text.toString().trim()
        val ConfSenha = binding.EDConfSenha.text.toString().trim()



        if (usuario.isNotBlank()) {
            if (email.isNotBlank()) {
                if (senha.isNotBlank()) {
                    if (ConfSenha.isNotBlank()) {
                        Toast.makeText(requireContext(), "Tudo OK!", Toast.LENGTH_SHORT).show()
                    } else {
                        showBottomSheet(message = getString(R.string.confirm_senha_empty))
                    }
                } else {
                    showBottomSheet(message = getString(R.string.password_empty))
                }
            } else {
                showBottomSheet(message = getString(R.string.email_empty))
            }
        } else {
            showBottomSheet(message = getString(R.string.usuario_empty))
        }



    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}