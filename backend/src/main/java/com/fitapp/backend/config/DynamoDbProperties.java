package com.fitapp.backend.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aws.dynamodb")
@Getter
@Setter
public class DynamoDbProperties {

    private String accessKey;
    private String secretKey;
    private String region;
    private String endpoint;

}
