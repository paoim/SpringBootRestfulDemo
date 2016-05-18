package com.restful.demo.service;

import java.util.Collection;

import com.restful.demo.model.Blog;

public interface BlogService {

	public abstract Collection<Blog> getAll();

	public abstract Blog getId(Long id);
	
	public abstract Blog create(Blog blog);

	public abstract Blog update(Long id, Blog blog);

	public abstract boolean delete(Long id);
}
