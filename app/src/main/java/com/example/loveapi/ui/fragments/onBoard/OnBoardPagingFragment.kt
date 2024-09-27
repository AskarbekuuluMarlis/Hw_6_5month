package com.example.loveapi.ui.fragments.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loveapi.R
import com.example.loveapi.databinding.FragmentViewPagerPadingBinding

class OnBoardPagingFragment : Fragment() {
    private lateinit var binding: FragmentViewPagerPadingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerPadingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when (requireArguments().getInt(ARG_ONBOARD_POSITION)) {
            0 -> {
                img.setAnimation(R.raw.lottie_1)
                tv1.text = "Have a good time"
                tv2.text = "You should take the time to help those\n" +
                        "who need you"
            }

            1 -> {
                img.setAnimation(R.raw.lottie_2)
                tv1.text = "Cherishing love"
                tv2.text = "It is now no longer possible for\n" +
                        "vou to cherish love"
            }

            2 -> {
                img.setAnimation(R.raw.lottie_3)
                tv1.text = "Have a breakup?"
                tv2.text = "We have made the correction for you\n" +
                        "don't worry\n" +
                        "Maybe someone is waiting for you!"
            }
        }
    }

    companion object {
        const val ARG_ONBOARD_POSITION = "onBoard"
    }

}