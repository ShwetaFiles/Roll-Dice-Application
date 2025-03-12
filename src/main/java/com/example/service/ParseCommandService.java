package com.example.service;

public interface ParseCommandService {
    /**
     * Splits a command line into arguments, the first being the name of the command
     * This split is done on spaces " "
     *
     * @param command The full command string including arguments
     * @return The command line split into the command and its arguments
     */
    String[] getArgs(String command);
}
