package com.solvd.tests.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;


@Endpoint(url = "${base_url}/repos/${owner}/${repo}", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/repos/_delete/rq.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.NO_CONTENT_204)
public class DeleteRepoMethod extends AbstractApiMethodV2 {

    public DeleteRepoMethod(String loginOwner, String repoName) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("owner", loginOwner);
        replaceUrlPlaceholder("repo", repoName);
        //TODO: add your token for test in config.properties
        setHeader("Authorization", "Bearer " + Configuration.getRequired("api_token"));

    }
}
