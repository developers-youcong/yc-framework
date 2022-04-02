package com.yc.common.elasticsearch;


import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @description:
 * @author: youcong
 */
@Configuration
public class ElasticsearchRestTemplateConfig extends AbstractElasticsearchConfiguration {
    @Value("${spring.elasticsearch.rest.uris}")
    private String uris;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration configuration = ClientConfiguration.builder()
                .connectedTo(uris)
                .build();
        return RestClients.create(configuration).rest();
    }
}


