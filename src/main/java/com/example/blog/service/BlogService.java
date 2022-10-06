package com.example.blog.service;

import com.example.blog.dto.BlogRequestDto;
import com.example.blog.entity.Blog;
import com.example.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    @Transactional
    public Long update(Long id, BlogRequestDto requestDto) {
        Blog blog1 = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id가 존재하지 않습니다.")
        );
        blog1.update(requestDto);
        return blog1.getId();
    }

    @Transactional
    public boolean check(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id가 존재하지 않습니다.")
        );
        if(requestDto.getPassword().equals(blog.getPassword())){
            return true;
        } else {
            return false;
        }
    }
}
