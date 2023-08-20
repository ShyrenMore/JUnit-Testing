package com.shyren.unittesting.unittesting.business;

import com.shyren.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BusinessImplMockTest {

    BusinessImpl business= new BusinessImpl();
    SomeDataService mockDataService = mock(SomeDataService.class);
    // Before for Junit 4
    @BeforeEach
    public void before(){
        business.setSomeDataService(mockDataService);
    }


    @Test
    public void calculateSum_basic_test(){

        int actual_res = business.calculateSum(new int[] {1, 2, 3});
        assertEquals(6, actual_res);
    }

    @Test
    public void calculateSumUsingStub_basic_test(){

//        SomeDataService mockDataService = mock(SomeDataService.class);
        when(mockDataService.retreiveAllData()).thenReturn(new int[]{3, 2, 3});
        int actual_res = business.calculateSumUsingDataService();
        assertEquals(8, actual_res);
    }

    @Test
    public void calculateSumUsingDataService_test(){

        // mock the class
        // SomeDataService mockDataService = mock(SomeDataService.class);

        // one liner stub using mock
        // when this method is called, return this
        when(mockDataService.retreiveAllData()).thenReturn(new int[]{1, 2, 3});

        int actual_res = business.calculateSumUsingDataService();;
        assertEquals(6, actual_res);
    }
}
