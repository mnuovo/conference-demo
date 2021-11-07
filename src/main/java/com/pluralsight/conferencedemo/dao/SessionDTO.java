package com.pluralsight.conferencedemo.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SessionDTO {
    private String name;
    private String description;
    private int length;
}
