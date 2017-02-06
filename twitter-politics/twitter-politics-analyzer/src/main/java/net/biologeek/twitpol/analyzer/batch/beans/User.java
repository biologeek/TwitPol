package net.biologeek.twitpol.analyzer.batch.beans;

import net.biologeek.twitpol.analyzer.batch.reader.TwitterBusinessObject;

public class User implements TwitterBusinessObject {

	private long userId;
	private String twitterUserId;
	private String username;
	private String shownUsername;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getTwitterUserId() {
		return twitterUserId;
	}

	public void setTwitterUserId(String twitterUserId) {
		this.twitterUserId = twitterUserId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getShownUsername() {
		return shownUsername;
	}

	public void setShownUsername(String shownUsername) {
		this.shownUsername = shownUsername;
	}

	public static class UserBuilder {
		User user;

		public UserBuilder() {
			user = new User();
		}

		public UserBuilder userName(String username) {
			user.setUsername(username);
			return this;
		}

		public UserBuilder shownUserName(String shownUserName) {
			user.setShownUsername(shownUserName);
			return this;
		}

		public UserBuilder userId(long userId) {
			user.setUserId(userId);
			return this;
		}

		public UserBuilder twitterUserID(String twitterUserID) {
			user.setTwitterUserId(twitterUserID);
			return this;
		}

		public User build() {
			return user;
		}
	}
}
