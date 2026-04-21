package com.example.problem2

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.problem2.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter
    private val todoItems = mutableListOf(
        TodoItem(1, "안드로이드 복습하기"),
        TodoItem(2, "RecyclerView 실습"),
        TodoItem(3, "Intent 예제 코드 작성"),
        TodoItem(4, "Adapter 패턴 정리"),
        TodoItem(5, "시험 범위 최종 확인")
    )
    private var nextId = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoAdapter = TodoAdapter(todoItems) { item ->
            val index = todoItems.indexOfFirst { it.id == item.id }
            if (index != -1) {
                todoItems.removeAt(index)
                todoAdapter.notifyItemRemoved(index)
            }
        }

        binding.recyclerViewTodos.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewTodos.adapter = todoAdapter

        binding.buttonAdd.setOnClickListener {
            val content = binding.editTextTodo.text.toString().trim()
            if (content.isEmpty()) {
                Toast.makeText(this, "할 일을 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newItem = TodoItem(nextId++, content)
            todoItems.add(newItem)
            todoAdapter.notifyItemInserted(todoItems.lastIndex)
            binding.editTextTodo.text.clear()
        }
    }
}
