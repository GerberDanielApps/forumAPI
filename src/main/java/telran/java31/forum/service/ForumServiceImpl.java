package telran.java31.forum.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.java31.forum.dao.ForumRepository;
import telran.java31.forum.dto.CommentDto;
import telran.java31.forum.dto.PostDto;
import telran.java31.forum.dto.PostNotFoundExeption;
import telran.java31.forum.dto.PostResponceDto;
import telran.java31.forum.model.Comment;
import telran.java31.forum.model.Post;

@Service
public class ForumServiceImpl implements ForumService{
	
	@Autowired
	ForumRepository forumRepository;

	@Override
	public PostResponceDto addPost(String author, PostDto postDto) {
		Post post = new Post(postDto.getTitle(), postDto.getContent(), author, postDto.getTags());
		post = forumRepository.save(post);
		return postToPostResponceDto(post);
	}

	@Override
	public PostResponceDto findPostById(String id) {
		Post post = forumRepository.findById(id)
				.orElseThrow(() -> new PostNotFoundExeption(id));
		return postToPostResponceDto(post);
	}

	@Override
	public PostResponceDto deletePost(String id) {
		Post post = forumRepository.findById(id)
				.orElseThrow(() -> new PostNotFoundExeption(id));
		forumRepository.delete(post);
		return postToPostResponceDto(post);
	}

	@Override
	public PostResponceDto updatePost(String id, PostDto postDto) {
		Post post = forumRepository.findById(id)
				.orElseThrow(() -> new PostNotFoundExeption(id));
		if (postDto.getTitle() != null) {
			post.setTitle(postDto.getTitle());
		}
		if (postDto.getContent() != null) {
			post.setContent(postDto.getContent());
		}
		if (postDto.getTags() != null) {
			post.setTags(postDto.getTags());
		}
		forumRepository.save(post);
		return postToPostResponceDto(post);
	}

	@Override
	public boolean addLikeToPost(String id) {
		Post post = forumRepository.findById(id)
				.orElseThrow(() -> new PostNotFoundExeption(id));
		post.addLike();
		forumRepository.save(post);
		return true;
	}

	@Override
	public PostResponceDto addCommentToPost(String id, String author, CommentDto commentDto) {
		Post post = forumRepository.findById(id)
				.orElseThrow(() -> new PostNotFoundExeption(id));
		Comment comment = new Comment(author, commentDto.getMessage());
		post.addComment(comment);
		forumRepository.save(post);
		return postToPostResponceDto(post);
	}

	@Override
	public List<PostResponceDto> findPostByAuthor(String author) {
		return forumRepository.findByAuthor(author)
				.map(this::postToPostResponceDto)
				.collect(Collectors.toList());
	}
	
	private PostResponceDto postToPostResponceDto(Post post) {
		PostResponceDto postResponceDto = new PostResponceDto(post.getId(),
				post.getTitle(), post.getContent(), post.getAuthor(),
				post.getDateCreated(), post.getTags(), post.getLikes(), post.getComments());
		return postResponceDto;
	}

}
