package com.backend.commbid.services;

import com.backend.commbid.models.Post;
import com.backend.commbid.models.User;
import com.backend.commbid.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
    public Optional<List<Post>> findAllByUser(User user) {
        return Optional.ofNullable(postRepository.findAllByUser(user));
    }
}
