package com.solvd.tests.api;

import com.solvd.tests.db.models.Repository;
import com.zebrunner.carina.core.IAbstractTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;
import java.util.UUID;

public class RepoMethodsTest implements IAbstractTest {

    @Test
    public void testCreateRepo() {
        String repoName = "test-repo" + new Random().nextInt(0, 1000);
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

    @Test()
    public void testDeleteRepo() {
        String loginOwner = "Anastasiyab92";
        String repo = "test-repo" + new Random().nextInt(0, 1000);

        PostRepoMethod postRepoMethod = new PostRepoMethod(repo, UUID.randomUUID().toString(), true);
        postRepoMethod.callAPI();

        DeleteRepoMethod deleteRepoMethod = new DeleteRepoMethod(loginOwner, repo);
        Response response = deleteRepoMethod.callAPIExpectSuccess();

        Assert.assertEquals(response.getStatusCode(), 204, "Expected 204 No Content but got different response!");
    }
}
