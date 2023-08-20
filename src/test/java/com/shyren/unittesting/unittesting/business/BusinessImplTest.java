package com.shyren.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BusinessImplTest {

    @Test
    public void calculateSum_basic_test(){
        BusinessImpl business= new BusinessImpl();
        int actual_res = business.calculateSum(new int[] {1, 2, 3});
        int exp_res = 6;
        assertEquals(exp_res, actual_res);
    }
}
