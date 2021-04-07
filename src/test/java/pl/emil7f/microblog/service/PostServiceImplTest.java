package pl.emil7f.microblog.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.emil7f.microblog.exception.PostError;
import pl.emil7f.microblog.exception.PostException;
import pl.emil7f.microblog.model.Comment;
import pl.emil7f.microblog.model.Post;
import pl.emil7f.microblog.model.Status;
import pl.emil7f.microblog.model.User;
import pl.emil7f.microblog.repository.CommentRepository;
import pl.emil7f.microblog.repository.PostRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private PostServiceImpl postService;

    private Post post;
    private User user;
    private Comment comment;

    @BeforeEach
    void setup() {
        user = new User();
        user.setName("John");
        user.setSurname("Doe");
        user.setEmail("johndoe@mail.com");
        post = new Post();
        post.setOwner(user);
        post.setContent("Post content test");
        comment = new Comment();
        comment.setId(1L);
        comment.setUserId(user.getId());
        comment.setPostId(post.getId());


    }

    @Test
    @DisplayName("when getPost should return not null post")
    void test1() {
        // given
        when(postRepository.findById(1L)).thenReturn(Optional.ofNullable(post));
        // when
        Post testPost = postService.getPost(1L);
        //then
        assertThat(testPost).isNotNull();
        assertThat(testPost).isEqualTo(post);
    }

    @Test
    @DisplayName("when getPost not exist should throw PostException")
    void test2() {
        // given
        // when
        when(postRepository.findById(10L)).thenThrow(new PostException(PostError.POST_NOT_EXIST));
        //then
        Assertions.assertThrows(PostException.class, () -> postService.getPost(10L));

    }

    @Test
    @DisplayName("when getComment not exist should throw PostException")
    void test3() {
        // given
        // when
        when(commentRepository.findById(10L)).thenThrow(new PostException(PostError.COMMENT_NOT_EXIST));
        //then
        Assertions.assertThrows(PostException.class, () -> postService.getComment(10L));
    }



}
