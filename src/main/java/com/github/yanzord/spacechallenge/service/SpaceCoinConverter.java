package com.github.yanzord.spacechallenge.service;

import com.github.yanzord.spacechallenge.dao.AnnotationsDAO;
import com.github.yanzord.spacechallenge.exception.InvalidNumberException;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpaceCoinConverter {
    private RomanConverter converter;
    private Map<String, Integer> galacticWordIntegerMap = new HashMap<>();
    private List<String> metalDeclarations = new ArrayList<>();
    private List<String> questions = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(SpaceCoinConverter.class.getName());

    public SpaceCoinConverter() {
        converter = new RomanConverter();
    }

    public List<Integer> processFile() throws InvalidNumberException {
        logger.log(Level.INFO, "Starting to process file.");
        List<String> fileLines = AnnotationsDAO.readFile();

        for (String line : fileLines) {
            String lastLetter = line.substring(line.length() - 1);

            if (converter.getROMANS().contains(lastLetter)) {
                String galacticWord = line.substring(0, line.indexOf(" "));

                galacticWordIntegerMap.put(galacticWord, converter.convert(lastLetter));
            }

            if (line.substring(line.lastIndexOf(" ")+1).equals("Credits")) {
                metalDeclarations.add(line);
            }

            if (lastLetter.equals("?")) {
                questions.add(line);
            }
        }

        processDeclarations();
        resolveQuestions();

        logger.log(Level.INFO, "File processed with success.");

        return new ArrayList<>(galacticWordIntegerMap.values());
    }

    private void processDeclarations() {

    }

    private void resolveQuestions() {

    }
}
