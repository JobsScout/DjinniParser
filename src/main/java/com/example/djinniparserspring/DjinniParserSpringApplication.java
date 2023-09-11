package com.example.djinniparserspring;

import com.example.djinniparserspring.entities.Vacancy;
import com.example.djinniparserspring.enums.Platform;
import com.example.djinniparserspring.service.DjinniService;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaRepositories
public class DjinniParserSpringApplication {
    private final DjinniService djinniService;

    @Bean
    public Function<String, String> myCustomBean() {
        return baseUrl -> {
            try {
                Document doc = Jsoup.connect(baseUrl).get();

                Elements jobItems = doc.select(".job-list-item__title");
                List<Vacancy> vacancies = new ArrayList<>();

                for (Element jobItem : jobItems) {
                    String vacancy_name = jobItem.select(".job-list-item__link").text();
                    String url = jobItem.select(".job-list-item__link").attr("href");

                    vacancies.add(new Vacancy(baseUrl.replace("/jobs/", "") + url, vacancy_name,
                            null, null, null, null, null, null,
                            Platform.DJINNI_CO));
                }

                djinniService.save(vacancies.get(0));
                //vacancies.forEach(djinniService::save);
                System.out.println("**************");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return "Hello from Spring Boot and AWS Lambda!";
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DjinniParserSpringApplication.class, args);
    }
}
