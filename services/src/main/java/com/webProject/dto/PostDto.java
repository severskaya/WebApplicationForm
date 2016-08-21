package com.webProject.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.LocalDateTime;

/**
 * Created by nsieverska on 13.08.16.
 */
public class PostDto {

	private Long postId;
	private String authorLogin;
	private String title;
	private String content;
	private LocalDateTime placeTime;

	public PostDto(Long postId, String authorLogin, String title, String content, LocalDateTime placeTime, Long postLikes) {
		this.postId = postId;
		this.authorLogin = authorLogin;
		this.title = title;
		this.content = content;
		this.placeTime = placeTime;
		this.postLikes = postLikes;
	}

	public PostDto() {
	}

	public Long getPostLikes() {
		return postLikes;
	}

	public void setPostLikes(Long postLikes) {
		this.postLikes = postLikes;
	}

	private Long postLikes;

	public String getAuthorLogin() {
		return authorLogin;
	}

	public void setAuthorLogin(String authorLogin) {
		this.authorLogin = authorLogin;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getPlaceTime() {
		return placeTime;
	}

	public void setPlaceTime(LocalDateTime placeTime) {
		this.placeTime = placeTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		PostDto postDto = (PostDto) o;

		return new EqualsBuilder()
				.append(postId, postDto.postId)
				.append(title, postDto.title)
				.append(content, postDto.content)
				.append(placeTime, postDto.placeTime)
				.append(authorLogin, postDto.authorLogin)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(25, 45)
				.append(postId)
				.append(title)
				.append(content)
				.append(placeTime)
				.append(authorLogin)
				.toHashCode();
	}
}
