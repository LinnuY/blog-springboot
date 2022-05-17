package org.linuy.blog;

import org.junit.jupiter.api.Test;
import org.linuy.blog.entity.user.BaseUser;
import org.linuy.blog.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.Date;

@SpringBootTest
class BlogApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(BlogApplicationTests.class);

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testRedisClient() {
        BaseUser user = new BaseUser();
        user.setId(1L);
        user.setUsername("LongTeng");
        user.setPassword("lldeai0221");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        redisTemplate.opsForValue().set("user", user);
        BaseUser user1 = (BaseUser) redisTemplate.opsForValue().get("user");
        if (user1 != null) {
            logger.error("{}", JsonUtils.toJsonString(user1));
        }
    }
}
