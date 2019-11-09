package telran.java31.forum.dto;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import telran.java31.forum.model.Comment;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponceDto {
	String id;
	String title;
	String content;
	String author;
	LocalDateTime dateCreated;
	Set<String> tags;
	Integer likes;
	Set<Comment> comments;
	
}
