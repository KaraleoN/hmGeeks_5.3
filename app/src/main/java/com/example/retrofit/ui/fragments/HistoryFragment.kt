package com.example.retrofit.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.MyApplication
import com.example.retrofit.R
import com.example.retrofit.data.model.PercentageModel
import com.example.retrofit.databinding.FragmentHistoryBinding
import com.example.retrofit.ui.adapters.PercentageAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryFragment : Fragment() {

    private val binding by lazy { FragmentHistoryBinding.inflate(layoutInflater) }
    private lateinit var percentageAdapter: PercentageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        percentageAdapter = PercentageAdapter()
        binding.recyclerView.adapter = percentageAdapter

        loadHistory()

        binding.btnHome.setOnClickListener {
            findNavController().navigate(R.id.loveCalculatorFragment)
        }
    }

    private fun loadHistory() {
        CoroutineScope(Dispatchers.IO).launch {
            val history = MyApplication.database.loveDao().getAllResults()
            withContext(Dispatchers.Main) {
                percentageAdapter.setData(history)
            }
        }
    }
}