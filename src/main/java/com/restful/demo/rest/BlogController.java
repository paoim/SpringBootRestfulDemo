package com.restful.demo.rest;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restful.demo.model.Blog;
import com.restful.demo.service.BlogService;
import com.restful.demo.service.BlogServiceImpl;

@RestController
@RequestMapping("/api/")
public class BlogController {
	
	private BlogService blogService;
	
	@RequestMapping(
			value = "blogs",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Collection<Blog>> getAllBlogs() {
		blogService = new BlogServiceImpl();
		Collection<Blog> blogs = blogService.getAll();
		return new ResponseEntity<Collection<Blog>>(blogs, HttpStatus.OK);
	}
}
