package com.example.loveapi.ui.fragments.loveCalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.loveapi.R
import com.example.loveapi.databinding.FragmentLoveCalculatorBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class LoveCalculatorFragment : Fragment() {

    private lateinit var binding: FragmentLoveCalculatorBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoveCalculatorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() = with(binding) {
        btnHistory.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
        btnCalculate.setOnClickListener {
            viewModel.getLovePercentage(
                firstName = et1.text.toString(),
                secondName = et2.text.toString()
            ).observe(viewLifecycleOwner) { loveModel ->
                setFragmentResult(
                    "key", bundleOf(
                        "data" to loveModel
                    )
                )

                viewModel.flag.observe(viewLifecycleOwner) { flag ->
                    Log.e("TAG", "initListener: $flag")
                    if (flag == false) {
                        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
                            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT)
                                .show()
                        }
                    } else {
                        findNavController().navigate(R.id.resultFragment)
                    }
                }

            }

        }
    }
}