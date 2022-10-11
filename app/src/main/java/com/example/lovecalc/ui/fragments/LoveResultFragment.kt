package com.example.lovecalc.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalc.R
import com.example.lovecalc.data.models.LoveModel
import com.example.lovecalc.databinding.FragmentLoveResultBinding

class LoveResultFragment : Fragment() {

    private lateinit var binding: FragmentLoveResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoveResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model: LoveModel = arguments?.getSerializable("model") as LoveModel
        with(binding) {
            tvFirstName.text = model.firstName
            tvSecondName.text = model.secondName
            tvAdvice.text = model.result
            tvPercentageLove.text = model.percentage

            btnTryAgain.setOnClickListener {
                findNavController().navigate(R.id.loveCalculate)
            }
        }
    }
}