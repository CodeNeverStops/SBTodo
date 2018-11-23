package com.example.sbtodo.service;

import com.example.sbtodo.pojo.Todo;

import java.util.List;

public interface TodoService {

    Todo get(Long id);

    int add(Todo todo);

    int deleteById(Long id);

    List<Todo> getAll();

}
