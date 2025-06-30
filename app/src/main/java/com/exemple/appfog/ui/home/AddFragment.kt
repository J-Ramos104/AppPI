package com.exemple.appfog.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.exemple.appfog.R
import com.exemple.appfog.databinding.FragmentAddBinding
import com.exemple.appfog.databinding.FragmentConfBinding
import com.exemple.appfog.util.setBackAction
import com.exemple.appfog.util.showBottomSheet


class AddFragment : Fragment() {



    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Chamando a função de extensão
        binding.voltar.setBackAction(this)

        initAdd()
    }

    private fun initAdd() {
        binding.bntS.setOnClickListener {
            validateDataCasa()
        }

    }
    private fun validateDataCasa() {
        val nomeCasa = binding.edit1.text.toString().trim()
        val endereco = binding.edit2.text.toString().trim()
        val idSensor = binding.edit4.text.toString().trim()

        if (nomeCasa.isNotBlank()) {
            if (endereco.isNotBlank()) {
                if (idSensor.isNotBlank()) {
                    findNavController().navigate(R.id.action_addFragment_to_homeFragment22)
                } else {
                    showBottomSheet(message = getString(R.string.sensor_id_empty))
                }
            } else {
                showBottomSheet(message = getString(R.string.endereco_empty))
            }
        } else {
            showBottomSheet(message = getString(R.string.nome_casa_empty))
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}