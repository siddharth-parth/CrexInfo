package com.example.crexinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.crexinfo.databinding.FragmentCommentaryBinding

class CommentaryFragment : Fragment() {

    private lateinit var binding: FragmentCommentaryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommentaryBinding.inflate(layoutInflater)
        return binding.root
    }
}