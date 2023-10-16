package cote.hccare.controller;

import cote.hccare.domain.ToastUiResponse;
import cote.hccare.mapper.PostMapper;
import cote.hccare.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@Controller
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<ToastUiResponse> getAllPosts() {
        return new ResponseEntity<>(postService.findPosts(), HttpStatus.OK);
    }

    @PostMapping
//    public ResponseEntity<ToastUiResponse> createPost(@RequestBody HashMap<String, Object> createdRows) {
    public String createPost(@RequestBody HashMap<String, Object> createdRows) {
        postService.createPosts(createdRows);
        return "/board";
    }

    @PutMapping
    public ResponseEntity<ToastUiResponse>  updatePost(@RequestBody HashMap<String, Object> updatedRows) {
        postService.updatePosts(updatedRows);
        return new ResponseEntity<>(postService.findPosts(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "/board";
    }
}