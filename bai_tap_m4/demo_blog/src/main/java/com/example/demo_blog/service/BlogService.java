package com.example.demo_blog.service;

import com.example.demo_blog.entity.Blog;
import com.example.demo_blog.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepo blogRepo;
    @Override
    public List<Blog> findAll(){
        return blogRepo.findAll();
    }
    @Override
    public Page<Blog> findByTitleContaining(String title, Pageable pageable){
        return blogRepo.findByTitleContaining(title,pageable);
    }
    @Override
    public Page<Blog> searchTitle(@Param("searchTitle") String searchTitle, Pageable pageable){
        return blogRepo.searchTitle("%"+searchTitle+"%",pageable);
    }
    @Override
    public Blog findById(int id){
        return blogRepo.findById(id).orElse(null);
    }
    @Override
    public boolean save(Blog blog){
        try {
            blogRepo.save(blog);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean delete(int id){
        try {
            blogRepo.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
