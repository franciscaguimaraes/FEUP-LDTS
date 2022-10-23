package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    private int div;

    public DivisibleByFilter(int div){
        this.div= div;
    }

    public boolean accept(Integer number) {
        return number % div == 0;
    }
}
