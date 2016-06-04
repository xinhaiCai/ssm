package com.jackie.util;

import redis.clients.jedis.Jedis;

import java.util.BitSet;

/**
 * Created by acer on 2016/4/8.
 */
public class RedisManager {
    Jedis redis = new Jedis("localhost");

//play:yyyy-mm-dd

    /**
     * 使用bitmap 记录 key为“操作+操作时间”,value为 偏移量（id）处置为true(1)的二进制值
     * 将bitmap中对应位置的位置为1，时间复杂度是O(1)
     * 一个bitmap包含10亿个位，占16MB，但可以使用Bitmap压缩技术
     * 对于一个很大的Bitmap，如果里边的数据分布很稀疏（说明有很多大片连续的0），
     * 采用RLE编码后，占用的空间会比原始的Bitmap小很多
     *
     * @param action  操作
     * @param user_id
     * @param value   设为1表示登陆了
     */
    public void actionCount(String action, long user_id, boolean value) {
        redis.setbit(action + ":" + DateUtil.today(), user_id, value);
    }

    /**
     * @param action
     * @param date    自选时间，方便添加数据
     * @param user_id
     * @param value
     */
    public void actionCount(String action, String date, long user_id, boolean value) {
        redis.setbit(action + ":" + date, user_id, value);
    }

    /**
     * 统计某个用户操作在某天的活跃用户
     *
     * @param action
     * @param date
     * @return
     */
    public int uniqueCount(String action, String date) {
        String key = action + ":" + date;
        if (redis.get(key.getBytes()) != null) {
            BitSet users = BitSet.valueOf(redis.get(key.getBytes()));
            return users.cardinality();
        }
        return 0;
    }

    /**
     * 统计某个用户操作在一个指定多个日期的活跃用户
     *
     * @param action
     * @param dates
     * @return
     */
    public int uniqueCount(String action, String... dates) {
        BitSet all = new BitSet();
        for (String date : dates) {
            String key = action + ":" + date;
            BitSet users = BitSet.valueOf(redis.get(key.getBytes()));
            all.or(users);
        }
        return all.cardinality();
    }

    public static void main(String[] args) {
        //模拟登陆操作并记录到redis
        RedisManager redisManager = new RedisManager();
        for (int i = 1; i < 61; i++) {//多少天前
            for (int j = 1; j <= i; j++) {//用户id
                redisManager.actionCount("login", DateUtil.beforeNDay(i), j, true);
            }
        }
    }
}
