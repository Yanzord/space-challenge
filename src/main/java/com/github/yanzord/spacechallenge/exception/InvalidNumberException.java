package com.github.yanzord.spacechallenge.exception;

public class InvalidNumberException extends Exception {
    public InvalidNumberException() {
        super("Numero inválido. Tente novamente.");
    }
}
