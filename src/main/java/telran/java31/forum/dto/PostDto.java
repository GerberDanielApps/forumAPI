package telran.java31.forum.dto;

import java.util.Set;

import lombok.Getter;

@Getter
public class PostDto {
	String title;
	String content;
	Set<String> tags;

}
