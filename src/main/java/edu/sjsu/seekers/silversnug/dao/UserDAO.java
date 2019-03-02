package edu.sjsu.seekers.silversnug.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.CollectionUtils;
import edu.sjsu.seekers.silversnug.model.User;
import edu.sjsu.seekers.silversnug.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAO {

	@Autowired
	DynamoDbClient dynamodbClient;

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");

	public User authenticate(LoginRequest loginRequest) {
		System.out.println("In DAO for authenticating: " + loginRequest.getUserName());
		AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
		DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
		Map<String, AttributeValue> values = new HashMap<>();
		values.put(":userName", new AttributeValue().withS( loginRequest.getUserName()));
		values.put(":password", new AttributeValue().withS( loginRequest.getPassword()));
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withFilterExpression("userName = :userName and password = :password").withExpressionAttributeValues(values);

		List<User> user = mapper.scan(User.class, scanExpression);
		if (!CollectionUtils.isNullOrEmpty(user)) {
			System.out.println("Authenticated: " + loginRequest.getUserName()  + " at " + sdf.format(Calendar.getInstance().getTime()));

			return user.get(0);
		}
		return null;
	}

	public void saveUser(User user) {
		AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
		DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
		System.out.println("Saved: " + user.getUserName()  + " at " + sdf.format(Calendar.getInstance().getTime()));
		mapper.save(user);
	}

	public User getUserByUserName(String userName) {
		AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
		DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

		Map<String, AttributeValue> values = new HashMap<>();
		values.put(":userName", new AttributeValue().withS(userName));
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withFilterExpression("userName = :userName").withExpressionAttributeValues(values);

		List<User> user = mapper.scan(User.class, scanExpression);
		if (!CollectionUtils.isNullOrEmpty(user)) {
			return user.get(0);
		}
		return null;
	}


}
