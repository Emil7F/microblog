package pl.emil7f.microblog.controller;

import org.springframework.web.bind.annotation.*;
import pl.emil7f.microblog.model.Comment;
import pl.emil7f.microblog.model.Post;
import pl.emil7f.microblog.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    public final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{postId}")
    public Post getPost(@PathVariable Long postId) {
        return postService.getPost(postId);

    }

    @GetMapping
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @PostMapping
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }

    @PostMapping("/{postId}/comments")
    public Comment addComment(@PathVariable Long postId, @RequestParam String text) {
        return postService.addComment(postId, text);
    }

    @PatchMapping("/comments/{commentId}")
    public Comment editComment(@PathVariable Long commentId, @RequestParam String text) {
        return postService.editComment(commentId, text);
    }

    @GetMapping("/comments/{commentId}")
    public Comment getComment(@PathVariable Long commentId){
        return postService.getComment(commentId);
    }

}
