package com.spark.springboot2learning.chap7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @author initiald0824
 * @date 2019/8/7 12:09
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate = null;

    @Autowired
    private StringRedisTemplate stringRedisTemplate = null;

    @RequestMapping("/test")
    public String test () {
        return "test";
    }

    @RequestMapping("/stringAndHash")
    public Map<String, Object> testStringAndHash() {
        redisTemplate.opsForValue().set("key1", "value1");
        redisTemplate.opsForValue().set("int_key", "1");
        stringRedisTemplate.opsForValue().set("int", "1");
        stringRedisTemplate.opsForValue().increment("int", 1);

        // 获取底层Jedis连接
        Jedis jedis = (Jedis)stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
        jedis.decr("int");
        Map<String, String> hash = new HashMap<String, String>();
        hash.put("field1", "value1");
        hash.put("field2", "value2");

        stringRedisTemplate.opsForHash().putAll("hash", hash);
        stringRedisTemplate.opsForHash().put("hash", "field3", "value3");

        BoundHashOperations hashOperations = stringRedisTemplate.boundHashOps("hash");

        hashOperations.delete("field1", "field2");
        hashOperations.put("field4", "value5");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/list")
    public Map<String, Object> testList() {
        stringRedisTemplate.opsForList().leftPushAll(
                "list1", "v2", "v4", "v6", "v8", "v10"
        );
        stringRedisTemplate.opsForList().rightPushAll(
                "list2", "v1", "v2", "v3", "v4", "v5", "v6"
        );

        BoundListOperations listOperations = stringRedisTemplate.boundListOps("list2");
        Object result1 = listOperations.rightPop();
        Object result2 = listOperations.index(1);
        listOperations.leftPush("v0");
        Long size = listOperations.size();
        List elements = listOperations.range(0, size-2);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/zset")
    public Map<String, Object> testZset() {
        Set<ZSetOperations.TypedTuple<String>> typedTupleSet = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            // 分数
            double score = i * 0.1;
            // 创建一个TypedTuple对象，存入值和分数
            ZSetOperations.TypedTuple<String> typedTuple = new DefaultTypedTuple<>("value" + i, score);
            typedTupleSet.add(typedTuple);
        }

        // 往有序集合插入元素
        stringRedisTemplate.opsForZSet().add("zset1", typedTupleSet);
        // 绑定zset1有序集合操作
        BoundZSetOperations<String, String> zSetOperations = stringRedisTemplate.boundZSetOps("zset1");

        // 增加一个元素
        zSetOperations.add("value10", 0.26);
        Set<String> setRange = zSetOperations.range(1, 6);
        // 按分数排序获取有序集合
        Set<String> setScore = zSetOperations.rangeByScore(0.2, 0.6);
        // 定义值范围
        RedisZSetCommands.Range range = new RedisZSetCommands.Range();
        range.gt("value3");

        range.lte("value8");
        // 按值排序，请注意这个排序是按字符串排序
        Set<String> setLex = zSetOperations.rangeByLex(range);
        // 删除元素
        zSetOperations.remove("value9", "value2");
        Double score = zSetOperations.score("value8");
        // 在下标区间下，按分数排序，同时返回value和score
        Set<ZSetOperations.TypedTuple<String>> rangeSet = zSetOperations.rangeWithScores(1, 6);
        // 在分数区间下，按分数排序，同时返回value和score
        Set<ZSetOperations.TypedTuple<String>> scoreSet = zSetOperations.rangeByScoreWithScores(1, 6);
        // 按从大到小排序
        Set<String> reverseSet = zSetOperations.reverseRange(2, 8);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }
}
