package edu.sjsu.seekers.silversnug.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Service
public class DynamoDbClient {

    private AmazonDynamoDB dynamoDB;

    @PostConstruct
    private void init() {
        AWSCredentialsProvider awsCredentialsProvider = new ClasspathPropertiesFileCredentialsProvider("application.properties");
        dynamoDB = AmazonDynamoDBClientBuilder.standard().withCredentials(awsCredentialsProvider).withRegion(Regions.US_EAST_2.getName()).build();
    }

    public AmazonDynamoDB getDynamoDB() {
        if (dynamoDB == null) {
            init();
        }
        return dynamoDB;
    }

    public void setDynamoDB(AmazonDynamoDB dynamoDB) {
        this.dynamoDB = dynamoDB;
    }

}
