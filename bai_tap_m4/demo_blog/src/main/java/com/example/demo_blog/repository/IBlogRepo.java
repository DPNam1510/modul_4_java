package com.example.demo_blog.repository;

import com.example.demo_blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepo extends JpaRepository<Blog,Integer> {
    Page<Blog> findByTitleContaining(String title, Pageable pageable);
    @Query(value = "select * from blog where title like :searchTitle",nativeQuery = true)
    Page<Blog> searchTitle(@Param("searchTitle") String searchTitle, Pageable pageable);
}
