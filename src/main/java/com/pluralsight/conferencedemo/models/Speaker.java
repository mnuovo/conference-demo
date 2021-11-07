package com.pluralsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "SPEAKERS")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SPE", sequenceName = "SPEAKERS_SPEAKER_ID_SEQ")
    @Column(name = "SPEAKER_ID")
    private long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "SPEAKER_BIO")
    private String bio;
    @Column(name = "SPEAKER_PHOTO")
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] photo;

    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore
    List<Session> sessions;
}
