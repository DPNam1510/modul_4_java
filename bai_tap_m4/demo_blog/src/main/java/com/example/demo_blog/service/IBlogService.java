package com.example.demo_blog.service;

import com.example.demo_blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Page<Blog> findByTitleContaining(String title, Pageable pageable);
    Page<Blog> searchTitle(@Param("searchTitle") String searchTitle, Pageable pageable);
    Blog findById(int id);
    boolean save(Blog blog);
    boolean delete(int id);
}
