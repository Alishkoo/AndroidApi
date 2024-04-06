package com.example.todolistapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.R
import com.example.todolistapp.model.Todo

/**
 * Адаптер для отображения списка дел в RecyclerView.
 *
 * @param todos Список дел, которые должны быть отображены.
 */
class TodoAdapter(
    var todos: List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    /**
     * ViewHolder для отображения отдельного элемента списка дел.
     */
    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val cbDone = itemView.findViewById<CheckBox>(R.id.cbDone)
    }

    /**
     * Создает новый ViewHolder для отображения элемента списка дел.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    /**
     * Привязывает данные дела к ViewHolder.
     */
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.apply {
            holder.tvTitle.text = todos[position].title
            holder.cbDone.isChecked = todos[position].isChecked
        }

    }

    /**
     * Возвращает количество дел в списке.
     */
    override fun getItemCount(): Int {
        return todos.size
    }
}