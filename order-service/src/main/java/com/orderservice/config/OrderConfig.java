package com.orderservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OrderConfig {
    public static final String ORDER_QUEUE = "ORDER Queue";
    public static final String ORDER_EXCHANGE = "ORDER Exchange";
    public static final String ORDER_ROUTING_KEY = "ORDER Routing Key";


    @Bean
    public Queue queue() {
        return new Queue(ORDER_QUEUE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(ORDER_EXCHANGE);
    }

    @Bean
    public Binding bindings(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(queue)
                .to(topicExchange)
                .with(ORDER_ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate notificationRabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
}
