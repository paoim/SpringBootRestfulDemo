package com.restful.demo.rest;

import java.math.BigInteger;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restful.demo.model.Blog;
import com.restful.demo.service.BlogService;

@RestController
@RequestMapping("/api/")
public class BlogController {
	
	@Resource
	private BlogService blogService;
	
	@RequestMapping(
			value = "blog/blogs",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Collection<Blog>> getAllBlogs() {
		Collection<Blog> blogs = blogService.getAll();
		return new ResponseEntity<Collection<Blog>>(blogs, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "blog/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Blog> getBlog(@PathVariable("id") BigInteger id) {
		Blog blog = blogService.getId(id);
		if (blog == null) {
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
}
