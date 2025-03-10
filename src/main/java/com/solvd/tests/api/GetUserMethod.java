package com.solvd.tests.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.Header;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/users", methodType = HttpMethodType.GET)
//@Header(key = "Authorization", value = "Bearer ${api_token}")
@ResponseTemplatePath(path = "api/users/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetUserMethod extends AbstractApiMethodV2 {

    public GetUserMethod(){
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
//        replaceUrlPlaceholder("api_token", Configuration.get("api_token").orElse(""));
    }
}
