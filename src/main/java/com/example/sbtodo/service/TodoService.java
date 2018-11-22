package com.example.sbtodo.service;

import com.example.sbtodo.pojo.Todo;

import java.util.List;

public interface TodoService {

    Todo get(int id);

    int add(Todo todo);

    int deleteById(int id);

    List<Todo> getAll();

}
