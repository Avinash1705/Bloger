package com.example.blog.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.blog.R
import com.example.blog.databinding.ListNameBinding
import com.example.blog.model.UserDetail
import androidx.core.content.ContextCompat.startActivity
import com.example.blog.ViewBlogActivity
//Bundle data make in 1 object then send

class RecycerViewDetail : RecyclerView.Adapter<RecycerViewDetail.CustomViewHolder> {
    private lateinit var itemListBinding:ListNameBinding
    var arraylist:ArrayList<UserDetail>
     var context:Context

    constructor(arraylist: ArrayList<UserDetail>,context: Context) : super() {
        this.arraylist = arraylist
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
//        val view  = LayoutInflater.from(context).inflate(R.layout.card_layout,parent,false)
//        return  CustomViewHolder(view)
     itemListBinding = ListNameBinding.inflate(LayoutInflater.from(context),parent,false)
        return CustomViewHolder(itemListBinding)
    }
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val userDetail = arraylist[position]
        with(holder){
            with(arraylist[position]){
                itemListBinding.tvName.text =userDetail.name
                itemListBinding.tvDesc.text =userDetail.desc
                itemListBinding.tvLikes.text = userDetail.likes.toString()
                itemListBinding.tvJob.text =userDetail.job
                Glide.with(context)
                    .load(userDetail.img)
                    .into(itemListBinding.ivUser)
            }
        }
        holder.itemView.setOnClickListener {
//            Toast.makeText(context, "ok"+holder.adapterPosition, Toast.LENGTH_SHORT).show()
            var intent = Intent(context, ViewBlogActivity::class.java)
            intent.putExtra("keyName",userDetail.name)
            intent.putExtra("keyDesc",userDetail.desc)
            intent.putExtra("keyJob",userDetail.job)
            intent.putExtra("keyLikes",userDetail.likes)
            intent.putExtra("keyImg",userDetail.img)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
       return  arraylist.size
    }

    class CustomViewHolder(itemListBinding: ListNameBinding) : RecyclerView.ViewHolder(itemListBinding.root) {

    }
    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }
}
