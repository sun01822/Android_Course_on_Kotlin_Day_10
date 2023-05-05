package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.data.Data
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(private val data : ArrayList<MyDataModel>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var mOnClickListener : OnClickListener ?= null
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.sample_user_name)
        val phone: TextView = itemView.findViewById(R.id.sample_user_number)
        val profile: CircleImageView = itemView.findViewById(R.id.profile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val myItem = LayoutInflater.from(parent.context).inflate(R.layout.sample_layout, parent, false)
        return MyViewHolder(myItem)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val singleData = data[position]
        holder.name.text = singleData.name
        holder.phone.text = singleData.phone
        Glide.with(holder.profile.context).load(singleData.profile).into(holder.profile)
        holder.itemView.setOnClickListener {
            if(mOnClickListener!=null){
                mOnClickListener!!.onClick(position,singleData)
            }
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.mOnClickListener = onClickListener
    }
    interface OnClickListener {
        fun onClick(index:Int, model: MyDataModel)
    }
}