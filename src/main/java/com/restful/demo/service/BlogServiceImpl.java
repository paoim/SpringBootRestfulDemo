package com.restful.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.demo.model.Blog;
import com.restful.demo.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Override
	public Collection<Blog> getAll() {
		Collection<Blog> blogs = blogRepository.findAll();
		return blogs;
	}
	
	@Override
	public Blog getId(Long id) {
		Blog blog = blogRepository.findOne(id);
		return blog;
	}
	
	@Override
	public Blog create(Blog blog) {
		if (blog.getId() != null) {
			return null;
		}
		Blog result = blogRepository.save(blog);
		return result;
	}

	@Override
	public Blog update(Long id, Blog blog) {
		Blog oldBlog = getId(id);
		if (oldBlog == null) {
			return null;
		}
		Blog updateBlog = new Blog();
		if (oldBlog != null) {
			updateBlog.setId(oldBlog.getId());
		}
		updateBlog.setTitle(blog.getTitle());
		updateBlog.setBody(blog.getBody());
		Blog result = blogRepository.save(updateBlog);
		return result;
	}
	
	@Override
	public boolean delete(Long id) {
		blogRepository.delete(id);
		return true;
	}
}
