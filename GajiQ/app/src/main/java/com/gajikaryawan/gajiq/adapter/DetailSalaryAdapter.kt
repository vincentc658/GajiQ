package com.gajikaryawan.gajiq.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gajikaryawan.gajiq.R
import com.gajikaryawan.gajiq.model.PaymentRoll
import com.gajikaryawan.gajiq.model.Staff
import java.lang.Exception
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class DetailSalaryAdapter(private val context: Context, private val data: ArrayList<PaymentRoll>, private val staff : Staff) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ItemViewHolder(
            LayoutInflater.from(context).inflate(R.layout.rv_item_detail_salary, parent, false)
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            val paymentRoll = data[position]
            holder.tvDate.text ="${paymentRoll.startDate} - ${paymentRoll.endDate}"
            var total=0f
            if (staff.isPerMonth!!) {
                val perDay = staff.salary!!.toFloat() / 30
                total =   perDay * paymentRoll.totalWorkingDay!!
            } else {
                val perDay = staff.salary!!.toFloat() * paymentRoll.totalWorkingDay!!
                total =    perDay
            }
            holder.tvTotal.text = "IDR ${getPrice(total)}"
            holder.tvSubTotal.text = "IDR ${getPrice(total)}"
            holder.tvMonthPerSalary.text ="${paymentRoll.totalWorkingDay} x ${getPrice(staff.salary!!.toFloat())}"
        }
    }
    private fun getPrice(price: Float): String {
        return try {

            val locale = Locale("in")
            val nf = NumberFormat.getNumberInstance(locale)



            nf.format(price)
        } catch (e: Exception) {
            price.toString()
        }
    }

    override fun getItemCount(): Int = data.size
    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvDate: TextView = view.findViewById(R.id.tvDate)
        var tvTotal: TextView = view.findViewById(R.id.tvTotal)
        var tvSubTotal: TextView = view.findViewById(R.id.tvSubTotal)
        var tvMonthPerSalary: TextView = view.findViewById(R.id.tvMonthPerSalary)
    }


}