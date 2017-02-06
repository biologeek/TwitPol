package net.biologeek.twitpol.analyzer.batch.reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import net.biologeek.twitpol.analyzer.batch.beans.Tweet;
import net.biologeek.twitpol.analyzer.batch.beans.TwitterObject;
import net.biologeek.twitpol.analyzer.batch.dto.UserConvrter;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class TweetApiReader implements ItemReader<SortedMap<TwitterObject, List<TwitterBusinessObject>>> {

	@Autowired
	TwitterFactory twitterFactory;
	private String screenName;
	
	@Value("${stalk.usernames}")
	String rawPropertiesUsers;

	public SortedMap<TwitterObject, List<TwitterBusinessObject>> read() throws Exception, UnexpectedInputException, ParseException,
			NonTransientResourceException {
		List<User> users = getTwitterUsersByUsername();
		
		SortedMap<TwitterObject, List<TwitterBusinessObject>> result = new TreeMap<TwitterObject, List<TwitterBusinessObject>>();
		
		result.put(TwitterObject.USER, new UserConvrter().convert(users));
		for (User currentUser : users){
			List<Status> statuses = getTweetsOfUser(currentUser);
			
		}
		
		return result;
	}

	List<Status> getTweetsOfUser(User currentUser) throws TwitterException {
		List<Status> statuses = twitterFactory.getInstance().getUserTimeline(currentUser.getId());
		return statuses;
	}

	List<User> getTwitterUsersByUsername() throws TwitterException {
		
		List<String> users = getUsersFromProperties();
		List<User> result = new ArrayList<User>();
		for(String user : users){
			User currentUser = twitterFactory.getInstance().showUser(user);
			result.add(currentUser);
		}
		return result;		
	}

	private List<String> getUsersFromProperties() {
		String[] rawPropertiesUsersArray = rawPropertiesUsers.split(",");		
		return Arrays.asList(rawPropertiesUsersArray);
	}

	public TwitterFactory getTwitterFactory() {
		return twitterFactory;
	}

	public void setTwitterFactory(TwitterFactory twitterFactory) {
		this.twitterFactory = twitterFactory;
	}

}
