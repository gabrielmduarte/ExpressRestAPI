package com.express.cadastro.domain.enums;

public enum AccountType {
    CONTA_CORRENTE("Conta Corrente"), CONTA_POUPANCA("Conta Poupança");

    private String type;

    AccountType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
