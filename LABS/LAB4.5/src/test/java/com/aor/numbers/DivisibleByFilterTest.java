package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DivisibleByFilterTest {
    @Test
    public void acceptDivideBy4(){
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(4);
        List<Integer> divisible = Arrays.asList(4,8,12,1000);
        List<Integer> notDivisible = Arrays.asList(1,3,5,1001);

        for (int n : divisible){
            Assertions.assertTrue(divisibleByFilter.accept(n));
        }
        for (int n : notDivisible){
            Assertions.assertFalse(divisibleByFilter.accept(n));
        }
    }

    @Test
    public void acceptDivideBy5(){
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(5);
        List<Integer> divisible = Arrays.asList(5,10,20,1000);
        List<Integer> notDivisible = Arrays.asList(1,2,3,1001);

        for (int n : divisible){
            Assertions.assertTrue(divisibleByFilter.accept(n));
        }
        for (int n : notDivisible){
            Assertions.assertFalse(divisibleByFilter.accept(n));
        }

    }

}
