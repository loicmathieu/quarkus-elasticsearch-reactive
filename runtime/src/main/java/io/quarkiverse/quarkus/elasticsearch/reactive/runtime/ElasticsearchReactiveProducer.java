package io.quarkiverse.quarkus.elasticsearch.reactive.runtime;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import org.elasticsearch.client.RestClientBuilder;

import io.quarkus.elasticsearch.restclient.lowlevel.runtime.ElasticsearchConfig;
import io.quarkus.elasticsearch.restclient.lowlevel.runtime.RestClientBuilderHelper;
import io.reactiverse.elasticsearch.client.mutiny.RestHighLevelClient;
import io.vertx.mutiny.core.Vertx;

@ApplicationScoped
public class ElasticsearchReactiveProducer {
    @Inject
    ElasticsearchConfig config;

    @Inject
    Vertx vertx;

    @Produces
    @Singleton
    public RestHighLevelClient restHighLevelClient() {
        RestClientBuilder builder = RestClientBuilderHelper.createRestClientBuilder(config);
        return RestHighLevelClient.create(vertx, builder);
    }
}
