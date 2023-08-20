package com.shyren.unittesting.unittesting.business;

import com.shyren.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataServiceStubForTest2 implements SomeDataService{

    @Override
    public int[] retreiveAllData() {
        return new int[]{1, 2, 3};
    }
}
class DataServiceStubForBasicTest implements SomeDataService{

    @Override
    public int[] retreiveAllData() {
        return new int[]{3, 2, 3};
    }
}

public class BusinessImplStubTest {

    @Test
    public void calculateSum_basic_test(){
        BusinessImpl business= new BusinessImpl();
        int actual_res = business.calculateSum(new int[] {1, 2, 3});
        int exp_res = 6;
        assertEquals(exp_res, actual_res);
    }

    @Test
    public void calculateSumUsingStub_basic_test(){
        BusinessImpl business= new BusinessImpl();
        business.setSomeDataService(new DataServiceStubForBasicTest());
        int actual_res = business.calculateSumUsingDataService();
        int exp_res = 8;
        assertEquals(exp_res, actual_res);
    }

    @Test
    public void calculateSumUsingDataService_test(){
        BusinessImpl business= new BusinessImpl();

        business.setSomeDataService(new DataServiceStubForTest2());
        int actual_res = business.calculateSumUsingDataService();;
        int exp_res = 6;
        assertEquals(exp_res, actual_res);
    }
}
