package pl.emil7f.microblog.service;

import org.springframework.stereotype.Service;
import pl.emil7f.microblog.model.Comment;
import pl.emil7f.microblog.model.Post;
import pl.emil7f.microblog.repository.CommentRepository;
import pl.emil7f.microblog.repository.PostRepository;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }


    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }


    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        postRepository.delete(post);
    }

    @Override
    public void addComment(Long postId, String comment) {
        Comment commentObj = new Comment();
        commentObj.setContent(comment);
        commentObj.setPostId(postId);
        Post post = getPost(postId);
        Long ownerId = post.getOwner().getId();
        commentObj.setUserId(ownerId);
        Comment savedComment = commentRepository.save(commentObj);

        post.getComments().add(savedComment);
        postRepository.save(post);
    }
}
