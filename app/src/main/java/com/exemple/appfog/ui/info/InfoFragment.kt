package com.exemple.appfog.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.exemple.appfog.databinding.FragmentInfoBinding
import com.exemple.appfog.util.setBackAction

class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Reaproveitando a extensão
        binding.voltar.setBackAction(this)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}