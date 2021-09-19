package com.wagae.wagaebackend.web;

import com.wagae.wagaebackend.service.PostService;
import com.wagae.wagaebackend.web.dto.PostListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @GetMapping("/api/v1/post/list")
    public List<PostListResponseDto> findAll() {
        return postService.findAll();
    }
}
