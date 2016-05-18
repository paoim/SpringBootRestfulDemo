package com.restful.demo.service;

import java.math.BigInteger;
import java.util.Collection;

import com.restful.demo.model.Blog;

public interface BlogService {

	public abstract Collection<Blog> getAll();

	public abstract Blog getId(BigInteger id);
	
	public abstract Blog create(Blog blog);

	public abstract Blog update(BigInteger id, Blog blog);

	public abstract boolean delete(BigInteger id);
}
