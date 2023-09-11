package com.example.djinniparserspring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Vacancy {

    @Id
    private String url;
    private String vacancy_name;

    public Vacancy(String vacancy_name, String url) {
        this.vacancy_name = vacancy_name;
        this.url = url;
    }
}
