package com.exemple.appfog.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.exemple.appfog.R
import com.exemple.appfog.databinding.FragmentHistBinding
import com.exemple.appfog.databinding.FragmentHomeBinding
import com.exemple.appfog.util.setBackAction


class HistFragment : Fragment() {
    private var _binding: FragmentHistBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Chamando a função de extensão
        binding.voltar.setBackAction(this)

        initHist()
    }

    private fun initHist() {
        binding.buttonHist.setOnClickListener {
            initHist()
        }
        binding.buttonHome.setOnClickListener {
            findNavController().navigate(R.id.action_histFragment_to_homeFragment22)
        }

        binding.buttonConf.setOnClickListener {
            findNavController().navigate(R.id.action_histFragment_to_confFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}