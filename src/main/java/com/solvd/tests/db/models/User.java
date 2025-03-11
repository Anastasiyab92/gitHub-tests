package com.solvd.tests.db.models;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String login;
    private String type;
    private String userViewType;
    private boolean siteAdmin;
}

