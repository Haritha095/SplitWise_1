package com.example.testcase;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OperationsTest extends TestCase {
private Operations operations;

    @Before
    public void setUp() {
//Arrange
        operations = new Operations();
    }

    @Test
    public void testAdd() {
        int a = 15; int b = 20;
        int expectedResult = 35;
//Act
        long result = operations.add(a, b);
//Assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testSubtract() {
        int a = 25; int b = 20;
        int expectedResult = 5;
        long result = operations.subtract(a, b);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testMultiply() {
        int a = 10; int b = 25;
        long expectedResult = 250;
        long result = operations.multiply(a, b);
        Assert.assertEquals(expectedResult, result);
    }



}
