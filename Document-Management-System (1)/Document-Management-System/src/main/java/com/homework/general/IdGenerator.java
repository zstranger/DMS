package com.homework.general;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.homework.application.ApplicationSettings;

import java.security.SecureRandom;
import java.util.Collection;

public enum IdGenerator {

    INSTANCE;
    private final static Logger classLogger = LoggerFactory.getLogger(IdGenerator.class);

    private final SecureRandom randomGenerator;
    private final static char[] acceptedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    private IdGenerator() {
        this.randomGenerator = new SecureRandom();
        randomGenerator.setSeed(System.currentTimeMillis());
    }

    public String next() {
        return nextId(ApplicationSettings.DOCUMENT_NAME__DEFAULT_LENGTH);
    }

    public String nextFreeRandom(Collection<String> toBeAvoided) {
        String candidateString = next();
        while (toBeAvoided.contains(candidateString)) {
            //refresh value
            candidateString = next();
        }
        return candidateString;
    }

    private String nextId(int ofSize) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ofSize; i++) {
            int currentRandomCursorPosition = randomGenerator.nextInt(acceptedChars.length);
            result.append(acceptedChars[currentRandomCursorPosition]);
        }
        String nextRandom = result.toString();
        logCreation(nextRandom);
        return nextRandom;
    }

    private void logCreation(String nextRandom) {
        if (classLogger.isDebugEnabled()) {
            classLogger.debug("Created next id of size " + nextRandom.length() + " with value " + nextRandom);
        }
    }
}
