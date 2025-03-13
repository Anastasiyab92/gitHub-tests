package com.solvd.tests.api;

import com.solvd.tests.db.models.User;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class GetUsersMethodTest implements IAbstractTest {

    @Test
    public void testGetUser() {
        GetUserMethod getUserMethod = new GetUserMethod();
        Response response = getUserMethod.callAPIExpectSuccess();

        List<User> users = response.as(new TypeRef<>() {
        });

        Assert.assertFalse(users.isEmpty(), "List of users is empty!");

        SoftAssert sa = new SoftAssert();
        for (User user : users) {
            sa.assertNotNull(user.getLogin(), "Login can't be null!");
            sa.assertNotNull(user.getId(), "ID can't be null!");
            sa.assertNotNull(user.getType(), "Type of user can't be null!");
            sa.assertNotNull(user.getUserViewType(), "User view type can't be null!");
        }
        sa.assertAll();
    }

    @Test
    public void testUserByName() {
        String userName = "Anastasiyab92";
        GetUserByNameMethod getUserByNameMethod = new GetUserByNameMethod(userName);
        getUserByNameMethod.setProperties("api/users/_get/user.properties");
        getUserByNameMethod.callAPI();
        getUserByNameMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());

    }
}
