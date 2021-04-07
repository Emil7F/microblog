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

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id){
       return postService.getPost(id);

    }

    @GetMapping
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    @PostMapping
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }

    @PostMapping("/{postId}/comment")
    public void addComment(@PathVariable Long postId, @RequestParam String text){
        postService.addComment(postId, text);
    }

}
