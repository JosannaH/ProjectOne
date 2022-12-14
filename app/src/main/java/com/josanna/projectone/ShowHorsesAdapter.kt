package com.josanna.projectone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.josanna.projectone.databinding.ItemInListBinding
import com.josanna.projectone.entities.Horse

class ShowHorsesAdapter (var horseList: List<Horse>): RecyclerView.Adapter<ShowHorsesAdapter.MyViewHolder>(){

    private lateinit var binding : ItemInListBinding

    inner class MyViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        binding = ItemInListBinding.bind(view)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.apply {
            binding.tvItemInList.text = horseList[position].name + "\n" + horseList[position].gender
            //TODO show owner of horse
        }
    }

    override fun getItemCount(): Int {
        return horseList.size
    }
}