package com.example.todolistapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.R
import com.example.todolistapp.adapter.TodoAdapter
import com.example.todolistapp.model.Todo

/**
 * Первый фрагмент, отображающий список задач.
 *
 * Этот фрагмент содержит RecyclerView для отображения списка задач и кнопку для добавления новых задач.
 */
class FirstFragment : Fragment(R.layout.fragment_first) {
    /**
     * Создает и возвращает иерархию представлений, связанных с фрагментом.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    /**
     * Вызывается сразу после того, как onCreateView вернул свое представление.
     *
     * В этом методе мы инициализируем наш RecyclerView и кнопку добавления задач.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Инициализация списка задач
         */

        var todoList = mutableListOf(
            Todo("Hello I tried to implement fragments to my self", false),
            Todo("The hometask in second fragment which called 'Messages'", true),
            Todo("I hope that didn't stop you from checking my homework :)", false)
        )

        /**
         *  Инициализация адаптера и RecyclerView */
        val adapter = TodoAdapter(todoList)
        val rvTodos = getView()?.findViewById<RecyclerView>(R.id.rvTodos)
        rvTodos?.adapter = adapter
        rvTodos?.layoutManager = LinearLayoutManager(context)

        // Инициализация кнопки добавления задач
        val btnAddTodo = getView()?.findViewById<Button>(R.id.btnAddTodo)

        // Установка обработчика кликов для кнопки добавления задач
        btnAddTodo?.setOnClickListener{
            val etTodo = getView()?.findViewById<EditText>(R.id.etTodo)
            val title = etTodo?.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        //Функция которая обновляет наш ресайкл вию но там есть по больше функций
        // Так же можно заменить diffutil
        }
    }
}