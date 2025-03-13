package com.solvd.tests.api;

import com.zebrunner.carina.core.IAbstractTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DeleteRepoMethodTest implements IAbstractTest {

    @Test()
    public void testDeleteRepo() {
        String loginOwner = "Anastasiyab92";
        String repo = "test-repo3";

        DeleteRepoMethod deleteRepoMethod = new DeleteRepoMethod(loginOwner, repo);
        Response response = deleteRepoMethod.callAPIExpectSuccess();

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(response.getStatusCode(), 204, "Expected 204 No Content but got different response!");

        sa.assertAll();
    }
}
