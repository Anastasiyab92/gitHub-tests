package com.solvd.tests.api;

import com.solvd.tests.db.models.User;
import com.zebrunner.carina.core.IAbstractTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class GetUserMethodTest implements IAbstractTest {

    @Test
    public void testGetUser() {
        GetUserMethod getUserMethod = new GetUserMethod();
        Response response = getUserMethod.callAPIExpectSuccess();

        List<Map<String, Object>> rawUsers = response.as(List.class);
        Assert.assertFalse(rawUsers.isEmpty(), "List of users is empty!");

        List<User> users = rawUsers.stream().map(userMap -> {
            User user = new User();
            user.setLogin((String) userMap.get("login"));
            user.setId((Integer) userMap.get("id"));
            user.setType((String) userMap.get("type"));
            user.setUserViewType((String) userMap.get("user_view_type"));
            user.setSiteAdmin((Boolean) userMap.get("site_admin"));
            return user;

        }).toList();

        for (User user : users) {
            Assert.assertNotNull(user.getLogin(), "Login can't be null!");
            Assert.assertNotNull(user.getId(), "ID can't be null!");
            Assert.assertNotNull(user.getType(), "Type of user can't be null!");
            Assert.assertNotNull(user.getUserViewType(), "User view type can't be null!");
        }
    }
}
