package pl.emil7f.microblog.service;

import org.springframework.stereotype.Service;
import pl.emil7f.microblog.exception.PostError;
import pl.emil7f.microblog.exception.PostException;
import pl.emil7f.microblog.model.Comment;
import pl.emil7f.microblog.model.Post;
import pl.emil7f.microblog.model.Status;
import pl.emil7f.microblog.repository.CommentRepository;
import pl.emil7f.microblog.repository.PostRepository;

import java.time.LocalDateTime;
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
                .orElseThrow(() -> new PostException(PostError.POST_NOT_EXIST));
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }


    @Override
    public void deletePost(Long id) {
        Post post = getPost(id);
        postRepository.delete(post);
    }

    @Override
    public Comment addComment(Long postId, String comment) {
        Comment commentObj = new Comment();
        commentObj.setContent(comment);
        commentObj.setPostId(postId);
        Post post = getPost(postId);
        Long ownerId = post.getOwner().getId();
        commentObj.setUserId(ownerId);
        Comment savedComment = commentRepository.save(commentObj);

        post.getComments().add(savedComment);
        postRepository.save(post);
        return savedComment;
    }

    @Override
    public Comment editComment(Long commentId, String editedContent) {
        return commentRepository.findById(commentId)
                .map(commentFromDb -> {
                    commentFromDb.setContent(editedContent);
                    commentFromDb.setUpdated(LocalDateTime.now());
                    commentFromDb.setStatus(Status.EDITED);
                    return commentRepository.save(commentFromDb);
                })
                .orElseThrow(() -> new PostException(PostError.COMMENT_NOT_EXIST));
    }

    @Override
    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new PostException(PostError.COMMENT_NOT_EXIST));
    }
}
