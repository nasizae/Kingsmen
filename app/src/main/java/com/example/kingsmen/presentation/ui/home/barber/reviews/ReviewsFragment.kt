package com.example.kingsmen.presentation.ui.home.barber.reviews

import ReviewsAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import com.example.kingsmen.data.model.ModelMastersItem
import com.example.kingsmen.data.model.PostReviws
import com.example.kingsmen.data.network.RetrofitClient
import com.example.kingsmen.data.remote.RemoteDataSource
import com.example.kingsmen.databinding.FragmentReviewsBinding
import com.example.kingsmen.domain.repository.Repository
import kotlinx.coroutines.launch

class ReviewsFragment : Fragment() {

    private lateinit var binding: FragmentReviewsBinding
    private val retrofitClient= RetrofitClient().createApiService()
    private val remoteDataSource= RemoteDataSource(retrofitClient)
    private val repository= Repository(remoteDataSource)
    private val viewModel=ReviewViewModel(repository)
    private var adapter= ReviewsAdapter()
    private var list=ArrayList<PostReviws>()

    override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View {
        binding= FragmentReviewsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPost()
        initGet()
    }

    private fun initGet() {

    }
    private fun initPost() {
        val data= arguments?.getSerializable("key") as ModelMastersItem
        viewModel.getReview(data.id)

        binding.send.setOnClickListener {
            viewModel.viewModelScope.launch {
                viewModel.postReview(
                    client = 3,
                    master = data.id,
                    rate = 5,
                    text = binding.etText.text.toString(),
                    date_time = "2023-11-25 06:17:37+00:00"

                )
            }
            viewModel.reviews.observe(viewLifecycleOwner){
                adapter.addData(list)
                Log.e("ololo", "initGet: $list", )
            }
            viewModel.error.observe(viewLifecycleOwner){
                Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
            }
            binding.rvReviews.adapter=adapter
        }
    }

}