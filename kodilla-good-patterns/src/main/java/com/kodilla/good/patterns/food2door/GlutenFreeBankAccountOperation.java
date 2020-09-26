package com.kodilla.good.patterns.food2door;

import java.lang.invoke.LambdaMetafactory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class GlutenFreeBankAccountOperation {

    private final String operationType;
    private BigDecimal amount;
    private final String name;
    private final String surname;
    private List<GlutenFreeBankAccountOperation> operationHistory = new ArrayList<>();

    public GlutenFreeBankAccountOperation(String operationType, double amount, String name, String surname) {
        this.operationType = operationType;
        this.amount = new BigDecimal(amount);
        this.name = name;
        this.surname = surname;
    }

    public void addOperation(GlutenFreeBankAccountOperation operation) {
        amount = amount.setScale(2, RoundingMode.HALF_EVEN);
        operationHistory.add(operation);
    }

    public String getOperationType() {
        return operationType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<GlutenFreeBankAccountOperation> getOperationHistory() {
        return operationHistory;
    }

    @Override
    public String toString() {
        return operationType + ", "  + amount + ", " + name + ", " + surname;
    }
}
