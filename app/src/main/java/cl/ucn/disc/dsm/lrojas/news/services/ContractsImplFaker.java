/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cl.ucn.disc.dsm.lrojas.news.services;

import cl.ucn.disc.dsm.lrojas.news.model.News;
import com.github.javafaker.Faker;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Cotract Implementation of News with Faker
 */
public class ContractsImplFaker implements Contracts{

  /**
   * @return all the News in the backend sorted by publishedAt
   */
  @Override
  public List<News> retrieveNews(final int newsQuantity) {

    // Faker provider
    Faker faker = new Faker();
    final  List<News> newsList = new ArrayList<>();
    for (int i = 0; i < newsQuantity; i++) {
      News news = new News(
          faker.funnyName().name(),
          faker.university().name(),
          faker.dragonBall().character(),
          faker.internet().url(),
          faker.internet().url(),
          faker.backToTheFuture().quote(),
          faker.elderScrolls().quote(),
          ZonedDateTime.now(ZoneId.of("-4"))
      );
      newsList.add(news);

    }
    return newsList;
  }
}
