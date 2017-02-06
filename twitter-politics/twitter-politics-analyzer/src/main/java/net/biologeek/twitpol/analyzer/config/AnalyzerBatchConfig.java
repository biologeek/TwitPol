package net.biologeek.twitpol.analyzer.config;

import net.biologeek.twitpol.analyzer.batch.beans.Tweet;
import net.biologeek.twitpol.analyzer.batch.reader.TweetApiReader;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


@Configuration
@EnableBatchProcessing
@EnableAutoConfiguration
@PropertySources({@PropertySource("${app.parameters}/oauth.properties")})
public class AnalyzerBatchConfig {
	
	
	@Bean(name="tweetReader")
	public TweetApiReader tweetReader(){
		TweetApiReader tweetReader = new TweetApiReader();
		tweetReader.setTwitterFactory(getTwitterFactory());
		return tweetReader;
	}

	@Bean
	/**
	 * Returns TwitterFactory based on properties configuration. Currently only 1 token accepted
	 * @return TwitterFactory object
	 */
	public TwitterFactory getTwitterFactory() {		
		return new TwitterFactory();
	}

	
	
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
}
