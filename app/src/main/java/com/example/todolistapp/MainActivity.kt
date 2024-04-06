package com.example.todolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.todolistapp.fragment.FirstFragment
import com.example.todolistapp.fragment.SecondFragment
import com.example.todolistapp.fragment.ThirdFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Главная активность приложения, которая управляет навигацией между фрагментами.
 */
class MainActivity : AppCompatActivity() {
    /**
     * Вызывается при создании активности. Здесь инициализируются фрагменты и устанавливается обработчик навигации.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация фрагментов
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        // Установка первого фрагмента как текущего
        setCurrentFragment(firstFragment)

        // Инициализация нижней панели навигации
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Установка обработчика выбора элементов нижней панели навигации
        bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.miHome -> setCurrentFragment(firstFragment)
                R.id.miMessages -> setCurrentFragment(secondFragment)
                R.id.miProfile -> setCurrentFragment(thirdFragment)
            }
            true
        }
    }

    /**
     * Устанавливает указанный фрагмент как текущий, заменяя текущий фрагмент в контейнере.
     *
     * @param fragment Фрагмент, который должен быть установлен как текущий.
     */
    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentt, fragment)
            commit()
//            there is default fragment will be shown
        }
    }
}