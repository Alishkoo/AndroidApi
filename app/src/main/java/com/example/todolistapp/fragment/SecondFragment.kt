package com.example.todolistapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.R
import com.example.todolistapp.adapter.AnimalAdapter
import com.example.todolistapp.model.Animal
import com.example.todolistapp.model.Characteristics
import com.example.todolistapp.model.Taxonomy
import com.example.todolistapp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Второй фрагмент, который выполняет сетевой запрос для получения списка животных.
 */
class SecondFragment : Fragment(R.layout.fragment_second) {

    private lateinit var adapter: AnimalAdapter
    private lateinit var recyclerView: RecyclerView


    /**
     * Вызывается после создания представления фрагмента. Здесь выполняется сетевой запрос.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchEditText: EditText = view.findViewById(R.id.Search_input)
        val searchButton: Button = view.findViewById(R.id.searchButton)

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            adapter.filter(query)

        }

        // Получение экземпляра клиента AppClient
        val client = ApiClient.instance
        // Выполнение сетевого запроса
        val responce = client.fetchAnimalList()

        // Обработка ответа на сетевой запрос
        responce.enqueue(object: Callback<List<Animal>> {
            /**
             * Вызывается, когда получен ответ на сетевой запрос.
             *
             * @param call Вызов, который был выполнен
             * @param response Ответ на сетевой запрос
             */
            override fun onResponse(call: Call<List<Animal>>, response: Response<List<Animal>>) {
                println("HttpResponce:(when accepted) ${response.body()}")

                response.body()?.let {
                    adapter = AnimalAdapter(it)
                    recyclerView = view.findViewById(R.id.recyclerview)
                    recyclerView.adapter = adapter
                    adapter.submitList(it)
                }
            }
            /**
             * Вызывается, когда сетевой запрос завершился неудачей.
             *
             * @param call Вызов, который был выполнен
             * @param t Исключение, которое было вызвано во время выполнения сетевого запроса
             */
            override fun onFailure(call: Call<List<Animal>>, t: Throwable) {
                println("HttpResponce:(when not) ${t.message}")
            }

        })


    }

}