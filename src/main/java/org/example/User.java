package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    public String login;
    public int id;

    @JsonProperty("public_repos") //Jackson looks for the name as in the Json file. It doesn't recognize publicRepos
    public int publicRepos;

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public int getPublicRepos() {
        return publicRepos;
    }
}
