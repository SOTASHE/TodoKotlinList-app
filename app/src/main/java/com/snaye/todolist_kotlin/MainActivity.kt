package com.snaye.todolist_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


//an activity is just a single screen in an android app
//in our app we will just have the single activity which represent the do list screen
//THis activity will just have different views
/*
A single view is just a visible element inside of an activity or our
screen (example: button , text , list of todo items..all
this is called view in android)
an activity is just a single screen that contains these views in our app
An activity always has a life circle
The onCreate function is just a function inherited from the
life circle
There's also a on destroy function - when the activity is destroyed
And many more of these life circle activity function
all these functions are in the life circle of
an activity
Usually when we have an activity, we also want to
set the design of that activity.
same as in web development.
You have css to design your website.
but in android  xml is used to design an activity.

inside of the on create function, we set the main activity to accept xml designs
or layout
 */
class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter:TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvDoToItems.adapter = todoAdapter
        rvDoToItems.layoutManager = LinearLayoutManager(this)
        btAddTodo.setOnClickListener{
            val todoTitle = etTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()){
                val  todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }
       btDeleteDoneTodo.setOnClickListener {
           todoAdapter.deleteDoneTodos()
       }

    }
}