package pl.emil7f.microblog.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.emil7f.microblog.model.Post;
import pl.emil7f.microblog.model.User;
import pl.emil7f.microblog.repository.PostRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImpl postService;

    private Post post;
    private User user;

    @BeforeEach
    void setup() {
        user = new User();
        user.setName("John");
        user.setSurname("Doe");
        user.setEmail("johndoe@mail.com");
        post = new Post();
        post.setOwner(user);
        post.setContent("Post content test");

    }

    @Test
    @DisplayName("when getPost should return not null post")
    void test1() {
        // given
        Mockito.when(postRepository.findById(1L)).thenReturn(Optional.ofNullable(post));
        // when
        Post testPost = postService.getPost(1L);
        //then
        assertThat(testPost).isNotNull();
        assertThat(testPost).isEqualTo(post);
    }





}
