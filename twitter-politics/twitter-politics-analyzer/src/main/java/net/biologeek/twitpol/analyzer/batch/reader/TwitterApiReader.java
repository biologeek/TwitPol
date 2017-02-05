package net.biologeek.twitpol.analyzer.batch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import twitter4j.TwitterFactory;

public class TwitterApiReader<T> implements ItemReader<T> {

	@Autowired
	TwitterFactory twitterFactory;

	public T read() throws Exception, UnexpectedInputException, ParseException,
			NonTransientResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	public TwitterFactory getTwitterFactory() {
		return twitterFactory;
	}

	public void setTwitterFactory(TwitterFactory twitterFactory) {
		this.twitterFactory = twitterFactory;

	}

}
