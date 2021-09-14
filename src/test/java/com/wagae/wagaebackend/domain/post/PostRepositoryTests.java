package com.wagae.wagaebackend.domain.post;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostRepositoryTests {

    @Autowired
    PostRepository postRepository;

    @AfterEach
    public void cleanup() {
        postRepository.deleteAll();
    }

    @Test
    public void post저장_조회() {
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "eari100@naver.com";

        postRepository.save(Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());

        List<Post> posts = postRepository.findAll();

        assertThat(posts.get(0).getTitle(), is(title));
        assertThat(posts.get(0).getContent(), is(content));
        assertThat(posts.get(0).getAuthor(), is(author));
    }
}
