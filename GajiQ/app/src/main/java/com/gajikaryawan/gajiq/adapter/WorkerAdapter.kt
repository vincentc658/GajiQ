package com.gajikaryawan.gajiq.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gajikaryawan.gajiq.R
import com.gajikaryawan.gajiq.model.Staff

class WorkerAdapter(private val context: Context,private val data: ArrayList<Staff>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_item_staff, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.tvName.text = data[position].name
            holder.tvNumber.text = data[position].phone
            holder.tvSalary.text = "IDR ${data[position].salary}"
            holder.tvType.text = if(data[position].isPerMonth!!)"Perbulan" else "Perhari"
        }
    }

    override fun getItemCount(): Int = data.size
    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvNumber: TextView = view.findViewById(R.id.tvNumber)
        var tvName: TextView = view.findViewById(R.id.tvName)
        var tvSalary: TextView = view.findViewById(R.id.tvSalary)
        var tvType: TextView = view.findViewById(R.id.tvType)
    }
}