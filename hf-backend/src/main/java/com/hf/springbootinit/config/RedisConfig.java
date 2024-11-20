package com.hf.springbootinit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfig {
    @Bean
    public Jedis jedis() {
        return new Jedis("localhost", 6379);  // 这里假设 Redis 运行在 localhost 和 6379 端口
    }
}
