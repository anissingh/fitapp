package com.fitapp.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDbConfig {

    private final DynamoDbProperties dynamoDbProperties;

    @Autowired
    public DynamoDbConfig(DynamoDbProperties dynamoDbProperties) {
        this.dynamoDbProperties = dynamoDbProperties;
    }

    /**
     * Create DynamoDbClient bean.
     * @return DynamoDbClient.
     */
    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder()
                .region(Region.of(dynamoDbProperties.getRegion()))
                .credentialsProvider(awsDynamoDbCredentials())
                .build();
    }

    /**
     * Create DynamoDbEnhancedClient bean.
     * @return DynamoDbEnhancedClient.
     */
    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient() {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient())
                .build();
    }

    /**
     * Get AWS DynamoDB credentials.
     * @return AWSCredentialsProvider with credentials required to work against
     * DynamoDb tables.
     */
    private AwsCredentialsProvider awsDynamoDbCredentials() {
        return StaticCredentialsProvider.create(
                AwsBasicCredentials.create(
                        dynamoDbProperties.getAccessKey(),
                        dynamoDbProperties.getSecretKey()
                ));
    }

}
