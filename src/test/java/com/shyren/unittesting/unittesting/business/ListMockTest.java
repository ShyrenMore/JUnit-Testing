package com.shyren.unittesting.unittesting.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ListMockTest {

    @Mock
    List list;

    @Test
    public void test(){
        when(list.size()).thenReturn(5);
        assertEquals(5, list.size());
    }

    @Test
    public void returnDifferentValues(){
        when(list.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, list.size());
        assertEquals(10, list.size());
    }

    @Test
    public void returnWithParams(){
        when(list.get(0)).thenReturn("shyren");
        assertEquals(null, list.get(1));
    }

    @Test
    public void returnWithGenericParams(){
        // anyInt is argument matchers
        when(list.get(anyInt())).thenReturn("shyren");
        assertEquals("shyren", list.get(100));
    }

    @Mock
    List<String> listOfStringsMock;
    @Test
    public void verificationBasics(){
        String value1  = listOfStringsMock.get(0);
        // value1 is null

        // verify if "get" method is called on mock
        verify(listOfStringsMock).get(anyInt());

        // verifying no of times mock is called
        verify(listOfStringsMock, times(1)).get(0);

        // verifying if .get() gets called at least once
        verify(listOfStringsMock, atLeast(1)).get(anyInt());

        // similar methods: atLeastOnce(), atMost(2), never()
    }

    @Test
    public void argumentCapturing(){
        listOfStringsMock.add("SomeString");

        // finding out what argument was provided: argument capturing
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(listOfStringsMock).add(captor.capture());

        // checking if someString was passed as a param
        assertEquals("SomeString", captor.getValue());
    }

    // spying: a normal mock does not retain behavior, eg you can perform two .add(), but the list.size() will still return 0
    // by spying, the original behavior of class is retained
    // you can stub specific methods
    @Test
    public void spying(){
        ArrayList arrayListSpy = spy(ArrayList.class);
        // arrayListSpy.get(0); // throws exception
        arrayListSpy.add("item1");
        arrayListSpy.add("item2");
        System.out.println(arrayListSpy.size()); // 2

        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); // 5
    }
}

/*
* public class ListMockTest{
*       @Test
*       public void test(){
*           List mock = mock(List.class);
*           when(mock.size()).thenReturn(5);
*           assertEquals(5, mock.size());
*       }
* }
* */
