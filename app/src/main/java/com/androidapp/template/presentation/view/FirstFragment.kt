package com.androidapp.template.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidapp.template.R
import com.androidapp.template.domain.entity.Model
import com.androidapp.template.presentation.adapter.MyAdapter
import com.androidapp.template.presentation.viewmodel.*
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * Created by S.Nur Uysal on 2020-02-28.
 */

class FirstFragment : Fragment() {

    private var isLoading = false

    private val viewModel: FirstViewModel by lazy {
        ViewModelProviders.of(this, context?.let { FirstViewModelFactory() }).get(
            FirstViewModel::class.java
        )
    }
    private val stateObserver = Observer<FirstState> { state ->
        state?.let {
            when (state) {
                is LoadedState -> {
                    isLoading = false
                    fillList(it.list)
                }
                is LoadingState -> {
                    isLoading = true
                }
                is ErrorState -> {
                    isLoading = false
                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        viewModel.getData()

    }

    private fun observeViewModel() {
        viewModel.stateLiveData.observe(this, stateObserver)
    }

    private fun fillList(list: List<Model>) {

        rv_list.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rv_list.adapter = MyAdapter(list)
    }
}