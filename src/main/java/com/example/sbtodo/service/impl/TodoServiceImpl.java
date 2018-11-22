package com.example.sbtodo.service.impl;

import com.example.sbtodo.dao.TodoDao;
import com.example.sbtodo.service.TodoService;
import com.example.sbtodo.pojo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoDao todoDao = null;

    @Override
    public Todo get(int id) {
        return todoDao.get(id);
    }

    @Override
    public int add(Todo todo) {
        return todoDao.add(todo);
    }

    @Override
    public int deleteById(int id) {
        return todoDao.deleteById(id);
    }

    @Override
    public List<Todo> getAll() {
        return todoDao.getAll();
    }
}
