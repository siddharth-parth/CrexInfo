package com.example.crexinfo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.crexinfo.api.CrexVolley
import com.example.crexinfo.databinding.FragmentInfoBinding
import com.example.crexinfo.repository.MatchInfoRepository
import com.example.crexinfo.viewmodel.InfoViewModel
import com.example.crexinfo.viewmodel.InfoViewModelFactory

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding

    private lateinit var infoRepository: MatchInfoRepository

    private lateinit var viewModel: InfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        infoRepository = MatchInfoRepository(CrexVolley.getInstance(requireContext()).requestQueue)

        viewModel = ViewModelProvider(
            this,
            InfoViewModelFactory(infoRepository)
        )[InfoViewModel::class.java]

        observeData()
        fetchData()
    }

    private fun observeData() {
        viewModel.infoLiveData.observe(viewLifecycleOwner) { response ->

        }
    }

    private fun fetchData() {
        viewModel.fetchInfo()
    }
}
