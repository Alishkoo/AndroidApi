package com.example.todolistapp.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.todolistapp.model.Animal

class AnimalDiffUtil(
    private val oldList: List<Animal>,
    private val newList: List<Animal>
) : DiffUtil.Callback() {


    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }



}