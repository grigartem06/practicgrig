package com.example.practikagrig

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView




class MainActivity : AppCompatActivity() {

    private var likeCount = 0
    private lateinit var likeButton: ImageButton
    private lateinit var textView4: TextView


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView) // Находим RecyclerView в activity_main
        recyclerView.layoutManager = LinearLayoutManager(this) // Устанавливаем LinearLayoutManager
        recyclerView.adapter = VkAdapter() // Устанавливаем адаптер VkAdapter

        val likeButton = findViewById<ImageButton>(R.id.likeButton) // Инициализация кнопки лайка
        val likeText = findViewById<TextView>(R.id.textView4) // Инициализация TextView для отображения количества лайков

    }

    // Адаптер для RecyclerView
    class VkAdapter : RecyclerView.Adapter<VkAdapter.VkViewHolder>() {
        // Определяем количество элементов в RecyclerView (в данном случае 3)
        override fun getItemCount(): Int = 3
        // Создаем ViewHolder для каждого элемента
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VkViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.vk, parent, false) // Инфлейтим layout vk.xml
            return VkViewHolder(view)
        }


        // Связываем данные с ViewHolder
        override fun onBindViewHolder(holder: VkViewHolder, position: Int) {
            // В данном случае, у нас нет конкретных данных, которые нужно привязать.
            // Просто отображаем layout vk.xml для каждого элемента.
            // При необходимости, здесь можно добавить логику для отображения разных данных
            // в зависимости от позиции.
        }

        // ViewHolder для хранения View
        inner class VkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            // Здесь можно хранить ссылки на элементы view внутри layout vk.xml,
            // если нужно с ними взаимодействовать.
            // Например:
            // val textView = itemView.findViewById<TextView>(R.id.textViewInVkLayout)
        }
    }
}