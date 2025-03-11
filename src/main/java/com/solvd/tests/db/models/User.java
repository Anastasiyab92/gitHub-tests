package com.solvd.tests.db.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private Integer id;
    private String login;
    private String type;
    @JsonProperty("user_view_type")
    private String userViewType;
    @JsonProperty("site_admin")
    private boolean siteAdmin;
}

