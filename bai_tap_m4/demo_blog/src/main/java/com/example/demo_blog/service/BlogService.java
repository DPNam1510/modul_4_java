package com.example.demo_blog.service;

import com.example.demo_blog.entity.Blog;
import com.example.demo_blog.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepo iBlogRepo;
    @Override
    public List<Blog> findAll() {
        return iBlogRepo.findAll();
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepo.findById(id).orElse(null);
    }

    @Override
    public boolean save(Blog blog) {
        try {
            blog.setCreateBlog(LocalDateTime.now());
            iBlogRepo.save(blog);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            iBlogRepo.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
