import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;


public class TwitterExample {

	
	/*private static final String CONSUMER_KEY = "OCV10De0BGALO8OH7NSjTeWFm";
	private static final String CONSUMER_SECRET = "******************************************";
	private static final String ACCESS_KEY = "2713093310-ZariuygvNSl1YAcQYhPwt8JlO62UTMG1AoHyO9C";
	private static final String ACCESS_SECRET = "******************************************";*/

	public static void main(String[] args) throws TwitterException, IOException{
		
		
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setDebugEnabled(true);
		builder.setOAuthConsumerKey(CONSUMER_KEY);
		builder.setOAuthConsumerSecret(CONSUMER_SECRET);
		builder.setOAuthAccessToken(ACCESS_KEY);
		builder.setOAuthAccessTokenSecret(ACCESS_SECRET);
		
		TwitterFactory tf = new TwitterFactory(builder.build());
	    Twitter twitter = tf.getInstance();
	    
	    File file = new File ("Twitter/TweetCoffee.txt");
	    FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    BufferedWriter bw = new BufferedWriter(fw);

	  		Query query = new Query("coffee");
		    QueryResult result = twitter.search(query);
		    for (Status status : result.getTweets()) {
		    	bw.write(("@" + status.getUser().getScreenName() + ":" + status.getText()));
		    }
		    bw.close();
		    
	    }
	}
