package com.example.demo_blog.service;

import com.example.demo_blog.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(int id);
    boolean save(Blog blog);
    boolean delete(int id);
}
