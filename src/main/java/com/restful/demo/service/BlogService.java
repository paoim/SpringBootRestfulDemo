package com.restful.demo.service;

import java.math.BigInteger;
import java.util.Collection;

import com.restful.demo.model.Blog;

public interface BlogService {

	public abstract Collection<Blog> getAll();

	public abstract Blog getId(BigInteger id);

}