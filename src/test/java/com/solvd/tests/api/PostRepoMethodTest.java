package com.solvd.tests.api;

import com.solvd.tests.db.models.Repository;
import com.zebrunner.carina.core.IAbstractTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PostRepoMethodTest implements IAbstractTest {

    @Test
    public void testCreateRepo() {
        String repoName = "test-repo3";
        String description = "Creating repo3 for testing API GitHub!";
        boolean isPrivate = false;

        PostRepoMethod postRepoMethod = new PostRepoMethod(repoName, description, isPrivate);
        Response response = postRepoMethod.callAPIExpectSuccess();

        Repository repository = response.as(Repository.class);

        SoftAssert sa = new SoftAssert();
        sa.assertNotNull(repository.getId(), "Id can't be null!");
        sa.assertEquals(repository.getName(), repoName, "RepoName doesn't equals");
        sa.assertEquals(repository.getDescription(), description, "Description doesn't equals!");

        sa.assertAll();
    }
}
