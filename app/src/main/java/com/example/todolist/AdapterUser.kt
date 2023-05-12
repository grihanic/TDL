package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.TextViewOnReceiveContentListener
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.todolist.database.db


class AdapterUser: RecyclerView.Adapter<AdapterUser.UserItem>() {
    private var userList = emptyList<db>()

    inner class UserItem(v:View):RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItem {
        return UserItem(LayoutInflater.from(parent.context).inflate(R.layout.views,parent,false))
    }

    override fun onBindViewHolder(holder: UserItem, position: Int) {

        val item= userList[position]
        holder.itemView.findViewById<TextView>(R.id.textView4).text = item.title
        holder.itemView.findViewById<TextView>(R.id.textView3).text =item.text
        holder.itemView.findViewById<ConstraintLayout>(R.id.cleart).setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    fun setUserList (userListData: List <db>){
        userList = userListData
        notifyDataSetChanged()
    }
    }


