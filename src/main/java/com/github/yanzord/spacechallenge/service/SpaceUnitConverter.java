package com.github.yanzord.spacechallenge.service;

import com.github.yanzord.spacechallenge.dao.AnnotationsDAO;
import com.github.yanzord.spacechallenge.exception.InvalidNumberException;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpaceUnitConverter {
    private RomanConverter converter;
    private Map<String, String> galacticWordRomanMap = new HashMap<>();
    private static final Logger logger = Logger.getLogger(SpaceUnitConverter.class.getName());

    public SpaceUnitConverter() {
        converter = new RomanConverter();
    }

    public List<String> processAnnotations() throws InvalidNumberException {
        logger.log(Level.INFO, "Starting to process file.");
        List<String> fileLines = AnnotationsDAO.readFile();
        List<String> metalDeclarations = new ArrayList<>();
        List<String> questions = new ArrayList<>();

        for (String line : fileLines) {
            String lastLetter = line.substring(line.length() - 1);

            if (converter.getROMANS().contains(lastLetter)) {
                String galacticWord = line.substring(0, line.indexOf(" "));
                galacticWordRomanMap.put(galacticWord, lastLetter);
            }

            if (line.substring(line.lastIndexOf(" ") + 1).equals("Credits")) {
                metalDeclarations.add(line);
            }

            if (lastLetter.equals("?")) {
                questions.add(line);
            }
        }

        Map<String, Float> metalToUnitMap = processDeclarations(metalDeclarations);
        List<String> answers = resolveQuestions(metalToUnitMap, questions);

        logger.log(Level.INFO, "File processed with success.");

        return answers;
    }

    private Map<String, Float> processDeclarations(List<String> metalDeclarations) throws InvalidNumberException {
        logger.log(Level.INFO, "Starting to process declarations.");

        Map<String, Float> metalToUnitMap = new HashMap<>();

        for (String declaration : metalDeclarations) {
            List<String> galacticWords = new ArrayList<>();
            List<String> declarationSplitted = Arrays.asList(declaration.split(" "));

            int unitValue = Integer.parseInt(declarationSplitted.get(declarationSplitted.size() - 2));

            for (String word : declarationSplitted) {
                if (galacticWordRomanMap.containsKey(word)) {
                    galacticWords.add(word);
                }
            }

            String romanNumber = makeRomanNumber(galacticWords);

            int convertedNumber = converter.convert(romanNumber);
            float unitValueByNumber = unitValue / (float)convertedNumber;

            metalToUnitMap.put(declarationSplitted.get(declarationSplitted.size() - 4), unitValueByNumber);
        }

        logger.log(Level.INFO, "Declarations processed with success.");

        return metalToUnitMap;
    }

    private List<String> resolveQuestions(Map<String, Float> metalToUnitMap, List<String> questions) throws InvalidNumberException {
        logger.log(Level.INFO, "Starting to resolve questions.");

        List<String> answers = new ArrayList<>();

        for (String question : questions) {
            List<String> galacticWords = new ArrayList<>();
            String metal = "";
            String[] questionSplitted = question.split(" ");

            for (String word : questionSplitted) {
                if (galacticWordRomanMap.containsKey(word)) {
                    galacticWords.add(word);
                }
                if (metalToUnitMap.containsKey(word)) {
                    metal = word;
                }
            }

            if(galacticWords.isEmpty()) {
                answers.add("I have no idea what you are talking about");
                continue;
            }

            String romanNumber = makeRomanNumber(galacticWords);

            Integer value = converter.convert(romanNumber);

            StringBuilder answer = new StringBuilder();

            for (String word : galacticWords) {
                String wordToAppend = word + " ";
                answer.append(wordToAppend);
            }

            if (!metal.isEmpty()) {
                float unitValue = value * metalToUnitMap.get(metal);

                String unitAnswer = metal + " is " + (int)unitValue + " Credits";

                answer.append(unitAnswer);
                answers.add(answer.toString());
                continue;
            }

            answer.append("is ");
            answer.append(value);
            answers.add(answer.toString());
        }

        logger.log(Level.INFO, "Questions resolved with success");

        return answers;
    }

    private String makeRomanNumber(List<String> galacticWords) {
        StringBuilder romanNumber = new StringBuilder();

        for (String word : galacticWords) {
            if(galacticWordRomanMap.containsKey(word)) {
                romanNumber.append(galacticWordRomanMap.get(word));
            }
        }

        return romanNumber.toString();
    }
}
