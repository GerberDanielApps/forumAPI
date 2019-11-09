package telran.java31.forum.service;

import java.util.List;

import telran.java31.forum.dto.CommentDto;
import telran.java31.forum.dto.PostDto;
import telran.java31.forum.dto.PostResponceDto;

public interface ForumService {
	
	PostResponceDto addPost(String author, PostDto postDto);
	
	PostResponceDto findPostById(String id);
	
	PostResponceDto deletePost(String id);
	
	PostResponceDto updatePost(String id, PostDto postDto);
	
	boolean addLikeToPost(String id);
	
	PostResponceDto addCommentToPost(String id, String author, CommentDto commentDto);
	
	List<PostResponceDto> findPostByAuthor(String author);
	
	

}
