package com.blueprint.common.cache.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

/**
 * redis configurations
 * @author yzll
 * @time  2019-3-25 10:21:06
 */
@EnableCaching
public class RedisConfig {

    @Value("spring.redis.host")
    private String host;
    @Value("spring.redis.port")
    private int port;
    @Value("spring.redis.timeout")
    private String timeout;

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    /**
     * @description 自定义的缓存key的生成策略
     *              若想使用这个key  只需要讲注解上keyGenerator的值设置为keyGenerator即可</br>
     * @return 自定义策略生成的key
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator(){
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuffer sb = new StringBuffer();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for(Object obj:params){
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

    //缓存管理器
    @Bean
    public RedisCacheManager cacheManager(JedisConnectionFactory jedisConnectionFactory) {
        return RedisCacheManager.create(jedisConnectionFactory);
    }

    /**
     * RedisTemplate配置
     *
     * @param jedisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory ) {
        //设置序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //配置redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);//key序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);//value序列化
        redisTemplate.setHashKeySerializer(stringSerializer);//Hash key序列化
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);//Hash value序列化
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }


}
