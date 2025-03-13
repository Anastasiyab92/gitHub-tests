package com.solvd.tests.api;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGExample {

    @BeforeClass
    public void executeTestClass() {
        System.out.println("Execute testNGExample class:");
    }

    @DataProvider(name = "numberData")
    public Object[][] provideNumber() {
        return new Object[][]{
                {1, 2, 3},
                {5, 5, 10},
                {30, 4, 34}
        };
    }

    @Test(dataProvider = "numberData")
    public void testAdditional(int x, int y, int sum) {
        System.out.println("Testing: " + x + "+" + y + "= " + sum);
        Assert.assertEquals(x + y, sum, "Error: Invalid result!");
    }

    @AfterClass
    public void finishTestClass() {
        System.out.println("TestNGExample class completed!");
    }


}



