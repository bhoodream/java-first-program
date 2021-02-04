package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    private float[] credits;
    private float[] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    private float sumOfCredits() {
        float sum = 0.0f;

        for (float credit : this.credits) {
            sum += credit;
        }

        return sum;
    }

    private float sumOfDebits() {
        float sum = 0.0f;

        for (float debit : this.debits) {
            sum += debit;
        }

        return sum;
    }

    static private int remainingDaysInMonth(LocalDate date) {
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();

        return totalDaysInMonth - date.getDayOfMonth();
    }

    public float calculate() {
        return this.sumOfCredits() - this.sumOfDebits();
    }

    static public void main(String[] args) {
        String[] creditsAsString = args[0].split(",");
        String[] debitsAsString = args[1].split(",");
        float[] credits = new float[creditsAsString.length];
        float[] debits = new float[debitsAsString.length];

        for(int i = 0; i < credits.length; i += 1) {
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }

        for(int i = 0; i < debits.length; i += 1) {
            debits[i] = Float.parseFloat(debitsAsString[i]);
        }

        SavingsCalculator calculator = new SavingsCalculator(credits, debits);

        float netSavings = calculator.calculate();

        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }
}
