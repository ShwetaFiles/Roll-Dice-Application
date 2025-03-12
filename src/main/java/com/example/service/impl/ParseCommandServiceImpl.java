package com.example.service.impl;

import com.example.service.ParseCommandService;
import org.springframework.stereotype.Service;

@Service
public class ParseCommandServiceImpl implements ParseCommandService {
    public String[] getArgs(String command) {
        return command.split(" ");
    }
}
