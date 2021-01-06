package com.express.cadastro.domain.enums;

public enum Level {
    BASIC("Básico"), INTERMEDIATE("Intermediário"), ADVANCED("Avançado"), CONVERSATION("Conversação");

    private String level;

    Level(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return this.level;
    }
}
