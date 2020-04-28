package com.github.yanzord.spacechallenge;

import com.github.yanzord.spacechallenge.exception.InvalidNumberException;
import com.github.yanzord.spacechallenge.service.SpaceCoinConverter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        SpaceCoinConverter spaceCoinConverter = new SpaceCoinConverter();

        try {
            System.out.println(spaceCoinConverter.processFile());
        } catch (InvalidNumberException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }
}
