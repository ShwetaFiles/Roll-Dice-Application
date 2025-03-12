package com.example.service;

public interface RandomNumberService {

    /**
     * Gets a random number between 1 and a max provided
     *
     * @param maxLimit The upper boundary of the number
     * @return A random number between 1 and x
     */
    int getRandomNumber(int maxLimit);
}
