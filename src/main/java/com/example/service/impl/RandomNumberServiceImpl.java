package com.example.service.impl;

import com.example.service.RandomNumberService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomNumberServiceImpl implements RandomNumberService {
    public int getRandomNumber(int maxLimit) {
        return ThreadLocalRandom.current().nextInt(1, maxLimit + 1);
    }
}
