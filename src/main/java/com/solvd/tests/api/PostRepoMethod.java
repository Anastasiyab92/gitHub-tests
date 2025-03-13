package com.solvd.tests.api;

import com.sun.xml.bind.v2.TODO;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/user/repos", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/repos/_post/rq.json")
@ResponseTemplatePath(path = "api/repos/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostRepoMethod extends AbstractApiMethodV2 {

    public PostRepoMethod(String repoName, String description, boolean isPrivate) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
       //TODO: add your token for test in config.properties
        setHeader("Authorization", "Bearer " + Configuration.getRequired("api_token"));

        addProperty("name", repoName);
        addProperty("description", description);
        addProperty("private", isPrivate);
    }
}
