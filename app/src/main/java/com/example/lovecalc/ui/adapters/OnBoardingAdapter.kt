package com.example.lovecalc.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalc.data.models.OnBoardingModel
import com.example.lovecalc.databinding.ItemOnBoardingBinding
import com.example.lovecalc.ui.inter.TransitionLoveCalculate

class OnBoardingAdapter(
    private val list: ArrayList<OnBoardingModel>,
    val transitionLoveCalculate: TransitionLoveCalculate
) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: OnBoardingModel) {
            binding.lottieImage.setAnimation(model.image)
            binding.tvTittle.text = model.tittle
            binding.tvDescription.text = model.description
            binding.btnGo.text = model.nameBtn

            if (binding.btnGo.text == "Father") {
                transitionLoveCalculate.transition()
            } else {
                binding.btnGo.setOnClickListener {
                    transitionLoveCalculate.next()
                }
            }
        }

    }
}