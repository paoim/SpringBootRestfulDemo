package com.restful.demo.service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.restful.demo.model.Blog;

public class BlogServiceImpl implements BlogService {

	private BigInteger nextId;
	private Map<BigInteger, Blog> blogMap;
	
	@Override
	public Collection<Blog> getAll() {
		Blog b1 = new Blog();
		b1.setTitle("Create Project by using Maven Command");
		b1.setBody("mvn archetype:generate -DgroupId={project-packaging} -DartifactId={project-name} -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false");
		this.save(b1);
		
		Blog b2 = new Blog();
		b2.setTitle("Update pom.xml File");
		b2.setBody("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""
				+ "xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd\">"
				+ "<modelVersion>4.0.0</modelVersion>"
				+ "<groupId>com.restful.demo</groupId>"
				+ "<artifactId>SpringBootRestfulDemo</artifactId>"
				+ "<version>1.0-SNAPSHOT</version>"
				+ "<parent>"
				+ "<groupId>org.springframework.boot</groupId>"
				+ "<artifactId>spring-boot-starter-parent</artifactId>"
				+ "<version>1.2.1.RELEASE</version>"
				+ "</parent>"
				+ "<dependencies>"
				+ "<dependency>"
				+ "<groupId>org.springframework.boot</groupId>"
				+ "<artifactId>spring-boot-starter-web</artifactId>"
				+ "</dependency>"
				+ "</dependencies>"
				+ "<build>"
				+ "<plugins>"
				+ "<plugin>"
				+ "<groupId>org.springframework.boot</groupId>"
				+ "<artifactId>spring-boot-maven-plugin</artifactId>"
				+ "</plugin>"
				+ "</plugins>"
				+ "</build>"
				+ "</project>"
				);
		this.save(b2);
		
		Collection<Blog> blogs = blogMap.values();
		return blogs;
	}
	
	private void save(Blog blog) {
		if (blogMap == null) {
			blogMap = new HashMap<BigInteger, Blog>();
			nextId = BigInteger.ONE;
		}
		blog.setId(nextId);
		nextId = nextId.add(BigInteger.ONE);
		blogMap.put(blog.getId(), blog);
	}
}
