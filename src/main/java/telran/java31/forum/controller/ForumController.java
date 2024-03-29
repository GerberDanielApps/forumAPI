package telran.java31.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.java31.forum.dto.CommentDto;
import telran.java31.forum.dto.PostDto;
import telran.java31.forum.dto.PostResponceDto;
import telran.java31.forum.service.ForumService;

@RestController
public class ForumController {
	
	@Autowired
	ForumService forumService;
	
	@PostMapping("/forum/post/{author}")
	public PostResponceDto addPost(@PathVariable String author, @RequestBody PostDto postDto) {
		return forumService.addPost(author, postDto);
	}
	
	@GetMapping("/forum/post/{id}")
	public PostResponceDto findPostById(@PathVariable String id) {
		return forumService.findPostById(id);
	}
	
	@DeleteMapping("/forum/post/{id}")
	public PostResponceDto deletePost(@PathVariable String id) {
		return forumService.deletePost(id);
	}
	
	@PutMapping("/forum/post/{id}")
	public PostResponceDto updatePost(@PathVariable String id, @RequestBody PostDto postDto) {
		return forumService.updatePost(id, postDto);
	}
	
	@PutMapping("/forum/post/{id}/like")
	public boolean addLikeToPost(@PathVariable String id) {
		return forumService.addLikeToPost(id);
	}
	
	@PutMapping("/forum/post/{id}/comment/{author}")
	public PostResponceDto addCommentToPost(@PathVariable String id, @PathVariable String author,
			@RequestBody CommentDto commentDto) {
		return forumService.addCommentToPost(id, author, commentDto);
	}
	
	@GetMapping("/forum/posts/author/{author}")
	public List<PostResponceDto> findPostByAuthor(@PathVariable String author) {
		return forumService.findPostByAuthor(author);
	}
}
