package com.github.yanzord.spacechallenge.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnnotationsDAO {
    public static final Path FILE_PATH = Paths.get("./annotations.txt");
    private static final Logger logger = Logger.getLogger(AnnotationsDAO.class.getName());

    public static List<String> readFile() {
        logger.log(Level.INFO, "Starting to read file.");

        createFile();
        List<String> fileLines = new ArrayList<>();

        try {
            fileLines = Files.readAllLines(FILE_PATH);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }

        logger.log(Level.INFO, "File read with success.");
        return fileLines;
    }

    private static void createFile() {
        if(!Files.exists(FILE_PATH)) {
            try {
                logger.log(Level.INFO, "File doesn't exist, creating a new one.");

                Files.createFile(FILE_PATH);

                logger.log(Level.INFO, "File created.");
            } catch (IOException e) {
                logger.log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }
}
