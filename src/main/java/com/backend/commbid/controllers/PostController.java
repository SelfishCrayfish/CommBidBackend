package com.backend.commbid.controllers;

import com.backend.commbid.models.Post;
import com.backend.commbid.models.User;
import com.backend.commbid.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final UserController userService;

    @Autowired
    public PostController(PostService postService, UserController userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Post>>getAllUserPosts(@PathVariable Long id){
        ResponseEntity<User> response = userService.getUserById(id);
        if(response.getStatusCode() == HttpStatus.OK){
            Optional<List<Post>> posts = postService.findAllByUser(response.getBody());
            return posts.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        return post.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.save(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        Optional<Post> existingPost = postService.findById(id);

        if (existingPost.isPresent()) {
            Post post = existingPost.get();
            post.setTitle(postDetails.getTitle());
            post.setBody(postDetails.getBody());
            post.setImage(postDetails.getImage());
            post.setUser(postDetails.getUser());
            post.setCreatedAt(postDetails.getCreatedAt());

            Post updatedPost = postService.save(post);
            return new ResponseEntity<>(updatedPost, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        if (postService.findById(id).isPresent()) {
            postService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
