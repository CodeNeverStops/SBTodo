package com.example.sbtodo.dao;

import com.example.sbtodo.pojo.Todo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoDao {

    @Select("SELECT * FROM todolist WHERE id=#{id}")
    Todo get(Long id);

    @Insert("INSERT INTO todolist(name) VALUES(#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int add(Todo todo);

    @Delete("DELETE FROM todolist WHERE id=#{id}")
    int deleteById(Long id);

    @Select("SELECT * FROM todolist")
    List<Todo> getAll();

}
