package com.restful.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restful.demo.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
