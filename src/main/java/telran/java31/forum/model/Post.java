package telran.java31.forum.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Post {
	String id;
	@Setter
	String title;
	@Setter
	String content;
	String author;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime dateCreated;
	@Setter
	Set<String> tags;
	int likes;
	Set<Comment> comments;
	
	public Post(String title, String content, String author, Set<String> tags) {
		this.title = title;
		this.content = content;
		this.author = author;
		this.tags = tags;
		dateCreated = LocalDateTime.now();
		comments = new HashSet<>();
	}
	
	public void addLike() {
		likes++;
	}
	
	public boolean addComment(Comment comment) {
		return comments.add(comment);
	}
	
	public boolean addTag(String tag) {
		return tags.add(tag);
	}
	
	public boolean removeTag(String tag) {
		return tags.remove(tag);
	}
	
}
