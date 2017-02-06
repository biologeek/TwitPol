package net.biologeek.twitpol.analyzer.batch.dto;

import java.util.ArrayList;
import java.util.List;

import net.biologeek.twitpol.analyzer.batch.beans.User.UserBuilder;
import net.biologeek.twitpol.analyzer.batch.reader.TwitterBusinessObject;
import twitter4j.User;

public class UserConvrter {

	public List<TwitterBusinessObject> convert(List<User> users) {
		List<TwitterBusinessObject> list = new ArrayList<>();
		for (User user : users) {
			list.add(convert(user));
		}
		return list;
	}

	public TwitterBusinessObject convert(User user) {
		return new UserBuilder().userName(user.getName())//
				.shownUserName(user.getScreenName())//
				.twitterUserID(String.valueOf(user.getId()))//
				.build();
	}

}
