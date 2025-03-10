package com.solvd.tests.api;

import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

public class GetUserMethodTest implements IAbstractTest {

    @Test
    public void testGetUser(){
        GetUserMethod getUserMethod = new GetUserMethod();
        getUserMethod.callAPIExpectSuccess();
        getUserMethod.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }
}
