package com.stacksimplify.restservices.dtos;

public class UserMsDto {
    private Long id;
    private String username;
    private String emailAddress;
    private String rolename;

    public UserMsDto() {
    }

    public UserMsDto(Long id, String username, String emailAddress, String rolename) {
        this.id = id;
        this.username = username;
        this.emailAddress = emailAddress;
        this.rolename = rolename;
    }

    public UserMsDto(Long id, String username, String emailString) {
        this.id = id;
        this.username = username;
        this.emailAddress = emailString;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
