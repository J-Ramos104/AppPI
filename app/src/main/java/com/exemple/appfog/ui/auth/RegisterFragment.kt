package com.exemple.appfog.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.exemple.appfog.R
import com.exemple.appfog.databinding.FragmentRegisterBinding
import com.exemple.appfog.util.setBackAction
import com.exemple.appfog.util.showBottomSheet
import com.google.firebase.auth.FirebaseAuth



class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        binding.BTVoltar.setBackAction(this)
        initRegister()
    }

    private fun initRegister() {
        binding.BTRegister.setOnClickListener {
            validaRegister()
        }

    }

    private fun validaRegister() {
        val email = binding.EDEmail.text.toString().trim()
        val senha = binding.EDSenha.text.toString().trim()
        val usuario = binding.EDUsuario.text.toString().trim()
        val confSenha = binding.EDConfSenha.text.toString().trim()

        if (usuario.isBlank()) {
            showBottomSheet(message = getString(R.string.usuario_empty))
        } else if (email.isBlank()) {
            showBottomSheet(message = getString(R.string.email_empty))
        } else if (senha.isBlank()) {
            showBottomSheet(message = getString(R.string.password_empty))
        } else if (confSenha.isBlank()) {
            showBottomSheet(message = getString(R.string.confirm_senha_empty))
        } else if (senha != confSenha) {
            showBottomSheet(message = getString(R.string.senhas_diferentes))
        } else {
            cadastrarUsuario(email, senha)
        }
    }

    private fun cadastrarUsuario(email: String, senha: String) {
        auth.createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    showBottomSheet(message = getString(R.string.registro_sucesso))
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment2)
                } else {
                    val erro = task.exception?.message ?: getString(R.string.registro_falhou)
                    showBottomSheet(message = erro)
                }
            }
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}