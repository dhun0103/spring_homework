package com.example.blog.controller;

import com.example.blog.dto.BlogRequestDto;
import com.example.blog.entity.Blog;
import com.example.blog.repository.BlogRepository;
import com.example.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BlogController {

    private final BlogRepository blogRepository;
    private final BlogService blogService;

    //글 전체 조회하기
    @GetMapping("/api/blogs")
    public List<Blog> getBlogs() {
        return blogRepository.findAllByOrderByModifiedAtDesc();
    }

    //글 개별 조회하기
    @GetMapping("/api/blogs/{id}")
    public Blog getMemos(@PathVariable Long id) {
        Optional<Blog> blog = blogRepository.findById(id);

        return blog.orElseGet(null);

    }

    //글 작성하기
    @PostMapping("/api/blogs")
    public Blog createBlog(@RequestBody BlogRequestDto requestDto) {

        Blog blog = new Blog(requestDto);

        return blogRepository.save(blog);
    }

    //글 비밀번호 확인하기
    @PostMapping("/api/blogs/{id}")
    public boolean check(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        return blogService.check(id, requestDto);
    }

    //글 수정하기
    @PutMapping("/api/blogs/{id}")
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        blogService.update(id, requestDto);
        return id;
    }

    //글 삭제하기
    @DeleteMapping("/api/blogs/{id}")
    public Long deleteCourse(@PathVariable Long id) {
        blogRepository.deleteById(id);
        return id;
    }
}
