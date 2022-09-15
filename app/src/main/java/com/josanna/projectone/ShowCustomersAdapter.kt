package com.josanna.projectone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.josanna.projectone.databinding.ItemInListBinding
import com.josanna.projectone.entities.Customer

class ShowCustomersAdapter (var customerList: List<Customer>): RecyclerView.Adapter<ShowCustomersAdapter.MyViewHolder>(){

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
            binding.tvItemInList.text = customerList[position].firstName + "\n" + customerList[position].lastName
            //TODO: add data to tell customers apart if they have the same name
        }
    }

    override fun getItemCount(): Int {
        return customerList.size
    }
}