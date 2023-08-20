package com.shyren.unittesting.unittesting.business;

import com.shyren.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BusinessImplMockInjectTest {

    /*
    @Mock:
    * create mock objects using the Mockito.mock() method for each class or interface that your class under test depends on
        BusinessImpl business = new BusinessImpl();

     @InjectMocks:
     You do not need to manually instantiate the class under test and inject the mock dependencies
     @BeforeEach
    public void before(){
        business.setSomeDataService(mockDataService);
    }

    @RunWith(MockitoJUnitRunner.class) will automatically initialise your mocks by calling setters implicitly

    * */
    @InjectMocks
    BusinessImpl business;

    @Mock
    SomeDataService mockDataService;

    @Test
    public void calculateSum_basic_test(){

        int actual_res = business.calculateSum(new int[] {1, 2, 3});
        assertEquals(6, actual_res);
    }

    @Test
    public void calculateSumUsingStub_basic_test(){

        when(mockDataService.retreiveAllData()).thenReturn(new int[]{3, 2, 3});
        int actual_res = business.calculateSumUsingDataService();
        assertEquals(8, actual_res);
    }

    @Test
    public void calculateSumUsingDataService_test(){

        when(mockDataService.retreiveAllData()).thenReturn(new int[]{1, 2, 3});
        int actual_res = business.calculateSumUsingDataService();;
        assertEquals(6, actual_res);
    }
}
