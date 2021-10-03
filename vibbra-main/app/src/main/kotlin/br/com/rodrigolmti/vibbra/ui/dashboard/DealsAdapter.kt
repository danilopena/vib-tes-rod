package br.com.rodrigolmti.vibbra.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.rodrigolmti.vibbra.databinding.ItemDealBinding
import br.com.rodrigolmti.vibbra.domain.model.Deal
import coil.load

internal class DealsAdapter(private val deals: List<Deal>) :
    RecyclerView.Adapter<DealsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemDealBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: Deal) {

            if (item.photos.isNotEmpty()) {
                binding.imgPhoto.load(item.photos.first())
            }
            binding.tvDescription.text = item.description
            binding.tvLimitDate.text = item.displayLimitDate()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDealBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(deals[position])
    }

    override fun getItemCount() = deals.size
}