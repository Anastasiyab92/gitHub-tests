package com.solvd.tests.api;

import com.solvd.tests.db.models.User;
import com.zebrunner.carina.core.IAbstractTest;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
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
    public void testUserByUsername() {
        String userName = "Anastasiyab92";
        GetUserMethod getUserMethod = new GetUserMethod(userName);
        Response response = getUserMethod.callAPIExpectSuccess();

        User user = response.as(User.class);

        SoftAssert sa = new SoftAssert();
        sa.assertNotNull(user, "User not found!");
        sa.assertEquals(user.getLogin(), userName, "Username doesn't equals!");

        sa.assertAll();
    }
}
