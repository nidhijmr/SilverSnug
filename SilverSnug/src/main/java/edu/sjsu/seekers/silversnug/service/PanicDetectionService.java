package edu.sjsu.seekers.silversnug.service;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import edu.sjsu.seekers.silversnug.dao.UserLocationDAO;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.response.UserLocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static edu.sjsu.seekers.silversnug.util.Constants.*;

@Service
public class PanicDetectionService {

    AmazonSNSClient snsClient;
    public GenericResponse sendPanicNotification(String userName) {
        GenericResponse genericResponse = new GenericResponse();

        AWSCredentialsProvider awsCredentialsProvider = new ClasspathPropertiesFileCredentialsProvider("application.properties");

        snsClient = new AmazonSNSClient(awsCredentialsProvider);
        snsClient.setRegion(Region.getRegion(Regions.US_EAST_1));

        try {
            PublishRequest publishReq = new PublishRequest()
                    .withTopicArn(PANIC_NOTIFICATION)
                    .withMessage(userName + PANIC_ALERT);
            snsClient.publish(publishReq);

        } catch (Exception e) {
            genericResponse.setMessage(PANIC_ERROR);
            genericResponse.setStatus(HttpStatus.EXPECTATION_FAILED.toString());
            System.out.println(e.getMessage());
        } finally {
            genericResponse.setMessage(PANIC_SUCCESS);
            genericResponse.setStatus(HttpStatus.OK.toString());
            System.out.println("Successfully pushed message for user: " + userName);
        }
        return genericResponse;
    }
}
