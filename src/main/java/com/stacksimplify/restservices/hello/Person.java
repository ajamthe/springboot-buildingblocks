package com.stacksimplify.restservices.hello;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Person {
    private String firstName;
    private String lastName;
    private String city;
}
