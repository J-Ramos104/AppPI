package com.exemple.appfog.util

import android.view.LayoutInflater
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.exemple.appfog.databinding.BottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.exemple.appfog.R


fun ImageButton.setBackAction(fragment: Fragment) {
    this.setOnClickListener {
        fragment.requireActivity().onBackPressedDispatcher.onBackPressed()
    }
}

fun Fragment.showBottomSheet(
    titleDialog: Int? = null,
    titleButton: Int? = null,
    message: String,
    onClick: () -> Unit = {}
) {
    // Cria o BottomSheetDialog com o estilo definido
    val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)

    // Infla o layout usando o ViewBinding do seu arquivo XML
    val binding = BottomSheetBinding.inflate(LayoutInflater.from(requireContext()))

    // Define os textos com base nos parâmetros (ou usa valores padrão)
    binding.textviewTitle.text = getText(titleDialog ?: R.string.text_title_warning)
    binding.textviewMessage.text = message
    binding.buttonOk.text = getText(titleButton ?: R.string.text_button_warning)

    // Define o comportamento do botão OK
    binding.buttonOk.setOnClickListener {
        onClick()
        bottomSheetDialog.dismiss()
    }

    // Associa o layout ao BottomSheet e exibe
    bottomSheetDialog.setContentView(binding.root)
    bottomSheetDialog.show()
}