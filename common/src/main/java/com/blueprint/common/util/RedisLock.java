package com.blueprint.common.util;


import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 *  redis distribute lock
 * @author yzll
 * @time 2019-3-25 14:59:53
 */
public class RedisLock {

    /**
     * note
     *  SETNX : SETNX key val
     *      当且仅当key不存在时，set一个key为val的字符串，返回1；若key存在，则什么都不做，返回0
     *  expire : expire key timeout
     *      为key设置一个超时时间，单位为second，超过这个时间锁会自动释放，避免死锁
     *  delete : delete key
     *      删除key
     */


    /**
     * status of when the lock is successful used
     */
    private static final String LOCK_SUCCESS = "ok";
    /**
     * SETNX
     */
    private static final String SET_IF_NOT_EXIST = "NX";

    /**
     * expire
     */
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 释放成功标识
     */
    private static final Long RELEASE_SUCCESS = 1L;


    /**
     *  获取分布式锁
     * @param jedis  redis 客户端
     * @param lockKey   锁
     * @param requestId     请求标识
     * @param expireTime    过期时间 单位：秒
     * @return  获取成功与否
     */
    public static boolean tryGetDistributeLock(Jedis jedis, String lockKey,
                                               String requestId, long expireTime){
//        String result = jedis.set(lockKey,requestId,SET_IF_NOT_EXIST,SET_WITH_EXPIRE_TIME,expireTime);
//        if(LOCK_SUCCESS.equals(result)){
//            return true;
//        }
        return false;
    }

    /**
     *  释放分布式锁
     * @param jedis redis 客户端
     * @param lockKey   锁
     * @param requestId  请求标识
     * @return  释放成功与否
     */
    public static boolean releaseDistributeLock(Jedis jedis,String lockKey,String requestId){
        String script = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey),Collections.singletonList(requestId));
        if(RELEASE_SUCCESS.equals(result)){
            return true;
        }
        return false;
    }

}
