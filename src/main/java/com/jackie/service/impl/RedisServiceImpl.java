package com.jackie.service.impl;

import com.jackie.service.RedisService;
import org.springframework.stereotype.Service;

/**
 * Created by jackie on 2016/5/20.
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Override
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }
}
