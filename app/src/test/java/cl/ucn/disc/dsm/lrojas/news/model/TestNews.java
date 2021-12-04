/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cl.ucn.disc.dsm.lrojas.news.model;

import cl.ucn.disc.dsm.lrojas.news.model.News;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test of {@link News}
 * @author Luis Rojas Olivera
 */
@Slf4j
public final class TestNews {

  /**
   * Test the constructor
   */
  @Test
  public void testConstructor() {
    System.out.println("Testing Constructor ..");
    // Constructor Ok
    News news = new News(
        "Titulo Noticia",
        "Fuente Noticia",
        "Author Noticia",
        "https://google.com",
        "https://img2.rtve.es/imagenes/detalle-diario-clarin-2003/1591339409126.jpg",
        "Some Description",
        "Some Content",
        ZonedDateTime.now(ZoneId.of("-4"))
    );

    Assertions.assertNotNull(news, "The News was null");

    Assertions.assertNotNull(news.getId(), "The Id was null");
    Assertions.assertNotNull(news.getTitle(), "The Title was null");
    Assertions.assertNotNull(news.getSource(), "The Source was null");
    Assertions.assertNotNull(news.getAuthor(), "The Author was null");
    Assertions.assertNotNull(news.getUrl(), "The Url was null");
    Assertions.assertNotNull(news.getUrlImage(), "The UrlImage was null");
    Assertions.assertNotNull(news.getDescription(), "The Description() was null");
    Assertions.assertNotNull(news.getContent(), "The Content was null");
    Assertions.assertNotNull(news.getPublishedAt(), "The PublishedAt() was null");

    // Constructor not OK
    {
      Assertions.assertThrows(IllegalArgumentException.class, () -> new News(
            null,
            "Fuente Noticia",
            "Author Noticia",
            "https://google.com",
            "https://img2.rtve.es/imagenes/detalle-diario-clarin-2003/1591339409126.jpg",
            "Some Description",
            "Some Content",
            ZonedDateTime.now(ZoneId.of("-4"))
        ));

      Assertions.assertThrows(IllegalArgumentException.class, () -> new News(
          "Titulo Noticia",
          null,
          "Author Noticia",
          "https://google.com",
          "https://img2.rtve.es/imagenes/detalle-diario-clarin-2003/1591339409126.jpg",
          "Some Description",
          "Some Content",
          ZonedDateTime.now(ZoneId.of("-4"))
      ));

      Assertions.assertThrows(IllegalArgumentException.class, () -> new News(
          "Titulo Noticia",
          "Fuente Noticia",
          null,
          "https://google.com",
          "https://img2.rtve.es/imagenes/detalle-diario-clarin-2003/1591339409126.jpg",
          "Some Description",
          "Some Content",
          ZonedDateTime.now(ZoneId.of("-4"))
      ));

      Assertions.assertThrows(IllegalArgumentException.class, () -> new News(
          "Titulo Noticia",
          "Fuente Noticia",
          "Author Noticia",
          "https://google.com",
          "https://img2.rtve.es/imagenes/detalle-diario-clarin-2003/1591339409126.jpg",
          null,
          "Some Content",
          ZonedDateTime.now(ZoneId.of("-4"))
      ));

      Assertions.assertThrows(IllegalArgumentException.class, () -> new News(
          "Titulo Noticia",
          "Fuente Noticia",
          "Author Noticia",
          "https://google.com",
          "https://img2.rtve.es/imagenes/detalle-diario-clarin-2003/1591339409126.jpg",
          "Some Description",
          null,
          ZonedDateTime.now(ZoneId.of("-4"))
      ));

      Assertions.assertThrows(IllegalArgumentException.class, () -> new News(
          "Titulo Noticia",
          "Fuente Noticia",
          "Author Noticia",
          "https://google.com",
          "https://img2.rtve.es/imagenes/detalle-diario-clarin-2003/1591339409126.jpg",
          "Some Description",
          "Some Content",
          null
      ));




    }
  }
}
