package net.biologeek.twitpol.analyzer.config;

import net.biologeek.twitpol.analyzer.batch.beans.Tweet;
import net.biologeek.twitpol.analyzer.batch.reader.TwitterApiReader;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter4j.TwitterFactory;


@Configuration
@EnableBatchProcessing
@EnableAutoConfiguration
public class AnalyzerBatchConfig {
	
	@Bean(name="tweetReader")
	public TwitterApiReader<Tweet> reader(){
		TwitterApiReader<Tweet> tweetReader = new TwitterApiReader<Tweet>();
		tweetReader.setTwitterFactory(getTwitterFactory());
		return tweetReader;
	}

	@Bean
	public TwitterFactory getTwitterFactory() {		
		return new TwitterFactory();
	}

}
