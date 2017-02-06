package net.biologeek.twitpol.analyzer.batch.beans;

import net.biologeek.twitpol.analyzer.batch.reader.TwitterBusinessObject;

public class Tweet implements TwitterBusinessObject {
	
	
	private long id;
	private long author;
	private long twitterId;
	private String message;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAuthor() {
		return author;
	}
	public void setAuthor(long author) {
		this.author = author;
	}
	public long getTwitterId() {
		return twitterId;
	}
	public void setTwitterId(long twitterId) {
		this.twitterId = twitterId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
