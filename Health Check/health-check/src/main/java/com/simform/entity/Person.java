package com.simform.entity;

import com.simform.helper.URLHelper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSONS")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String profileURL;


    public Person(String firstName, String lastName, String profileURL) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileURL = profileURL == null ? null : URLHelper.shortenURL(profileURL);
    }
}
