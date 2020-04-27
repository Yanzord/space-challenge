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

    public List<String> readFile() {
        createFile();
        List<String> fileLines = new ArrayList<>();

        try {
            fileLines = Files.readAllLines(FILE_PATH);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }

        return fileLines;
    }

    private void createFile() {
        if(!Files.exists(FILE_PATH)) {
            try {
                Files.createFile(FILE_PATH);
            } catch (IOException e) {
                logger.log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }
}
