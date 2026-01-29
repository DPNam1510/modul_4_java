package com.example.demo_blog.repository;

import com.example.demo_blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepo extends JpaRepository<Blog,Integer> {
}
