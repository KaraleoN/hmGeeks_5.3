package com.example.retrofit.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.retrofit.R
import com.example.retrofit.data.model.PercentageModel
import com.example.retrofit.databinding.FragmentLoveCalculatorBinding
import com.example.retrofit.ui.presenter.ILoveCalculatorView
import com.example.retrofit.ui.presenter.LoveCalculatorPresenter

class LoveCalculatorFragment : Fragment(), ILoveCalculatorView {

    private var _binding: FragmentLoveCalculatorBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: LoveCalculatorPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoveCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = LoveCalculatorPresenter(this)

        binding.btnCalculate.setOnClickListener {
            val firstName = binding.etFirstName.getString()
            val secondName = binding.etSecondName.getString()
            presenter.calculateLovePercentage(firstName, secondName)
        }

        binding.btnHistory.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
    }

    override fun showResult(percentageModel: PercentageModel) {
        val action = LoveCalculatorFragmentDirections
            .actionLoveCalculatorFragmentToResultFragment(result = percentageModel.result)
        findNavController().navigate(action)
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }


    private fun EditText.getString(): String = this.text.toString()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}