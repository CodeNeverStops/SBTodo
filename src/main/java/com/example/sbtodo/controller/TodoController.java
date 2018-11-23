package com.example.sbtodo.controller;

import com.example.sbtodo.service.TodoService;
import com.example.sbtodo.pojo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService = null;

    @GetMapping("/list")
    public ModelAndView list() {
        List<Todo> todoList = todoService.getAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("todo/list");
        mv.addObject("todoList", todoList);
        return mv;
    }

    @PostMapping("/new")
    public ModelAndView create(@RequestParam String name) {
        Todo todo = new Todo();
        todo.setName(name);
        int createResult = todoService.add(todo);

        ModelAndView mv = new ModelAndView();
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        mv.setView(jsonView);

        if (createResult > 0) {
            todo.setName(HtmlUtils.htmlEscape(todo.getName()));
            mv.addObject("success", true);
            mv.addObject("todo", todo);
        } else {
            mv.addObject("success", false);
        }
        return mv;
    }

    @PostMapping("/del")
    public ModelAndView delete(@RequestParam long id) {
        int deletedResult = todoService.deleteById(id);

        ModelAndView mv = new ModelAndView();
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        mv.setView(jsonView);

        if (deletedResult > 0) {
            mv.addObject("success", true);
        } else {
            mv.addObject("success", false);
        }
        return mv;
    }

}
