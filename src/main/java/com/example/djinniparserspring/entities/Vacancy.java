package com.example.djinniparserspring.entities;

import com.example.djinniparserspring.enums.Platform;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Entity(name = "vacancies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Vacancy {
    @Id
    private String url;
    private String vacancyName;
    private String vacancyLevels;
    private String companyName;
    private String locations;
    private String typesOfWork;
    private String skills;
    private String additional;
    private Platform platform;
}
