package com.restful.demo.rest;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restful.demo.model.Blog;
import com.restful.demo.service.BlogService;

@RestController
@RequestMapping("/api/blog/")
public class BlogController {
	
	@Resource
	private BlogService blogService;
	
	@RequestMapping(
			value = "all",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Collection<Blog>> getAllBlogs() {
		Collection<Blog> blogs = blogService.getAll();
		return new ResponseEntity<Collection<Blog>>(blogs, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Blog> getBlog(@PathVariable("id") Long id) {
		Blog blog = blogService.getId(id);
		if (blog == null) {
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	
	
	@RequestMapping(
			value = "create",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
		if (blog == null) {
			return new ResponseEntity<Blog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Blog newBlog = blogService.create(blog);
		return new ResponseEntity<Blog>(newBlog, HttpStatus.CREATED);
	}
	
	@RequestMapping(
			value = "update/{id}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog, @PathVariable("id") Long id) {
		Blog updateBlog = blogService.update(id, blog);
		if (updateBlog == null) {
			return new ResponseEntity<Blog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Blog>(updateBlog, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "delete/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Blog> deleteBlog(@PathVariable("id") Long id) {
		boolean isDelete = blogService.delete(id);
		if (!isDelete) {
			return new ResponseEntity<Blog>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
	}
}
