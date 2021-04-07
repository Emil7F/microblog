package pl.emil7f.microblog.service;

import pl.emil7f.microblog.model.Comment;
import pl.emil7f.microblog.model.Post;

import java.util.List;

public interface PostService {
    Post addPost(Post post);

    Post getPost(Long id);

    List<Post> getPosts();

    void deletePost(Long id);

    Comment addComment(Long postId, String comment);

    Comment editComment(Long commentId, String editedContent);

    Comment getComment(Long commentId);
}
