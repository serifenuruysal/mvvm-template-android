package com.androidapp.template.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidapp.template.R
import com.androidapp.template.domain.entity.Model
import com.androidapp.template.presentation.rx.RxBus
import kotlinx.android.synthetic.main.item_model.view.*

/**
 * Created by S.Nur Uysal on 2020-03-01.
 */
class MyAdapter(
    private val myDataset: List<Model>
) :
    RecyclerView.Adapter<MyAdapter.ModelViewHolder>() {

    class ModelViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ModelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_model, parent, false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val model = myDataset.get(position)
        holder.view.tv_title.text = model.title

        holder.view.setOnClickListener {
            RxBus.publish(ModelClickEvent(model))
        }
    }

    override fun getItemCount() = myDataset.size
}

data class ModelClickEvent(val model: Model)