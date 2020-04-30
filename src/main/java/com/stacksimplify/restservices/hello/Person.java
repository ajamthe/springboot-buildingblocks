package com.stacksimplify.restservices.hello;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Person {
    private final String firstName;
    private final String lastName;
    private final String city;
}
