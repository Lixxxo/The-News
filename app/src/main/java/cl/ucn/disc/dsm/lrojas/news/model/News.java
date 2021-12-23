/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cl.ucn.disc.dsm.lrojas.news.model;
import java.time.ZonedDateTime;
import lombok.Getter;
import net.openhft.hashing.LongHashFunction;

/**
 * The News class
 *
 * @author Luis Rojas Olivera
 */
public final class News {
  /**
   * The Constructor of News
   * @param title can't be null.
   * @param source can't be null.
   * @param author can't be null.
   * @param url can be null.
   * @param urlImage can be null.
   * @param description can't be null.
   * @param content can't be null.
   * @param publishedAt can't be null.
   */
  public News(
      final String title,
      final String source,
      final String author,
      final String url,
      final String urlImage,
      final String description,
      final String content,
      final ZonedDateTime publishedAt) {

    // Title
    if(title == null || title.length() < 2){
      throw  new IllegalArgumentException("Tittle required");
    }
    this.title = title;

    // Source
    if(source == null || source.length() < 2){
      throw  new IllegalArgumentException("Source required");
    }
    this.source = source;

    // Author
    if(author == null || author.length() < 2){
      throw  new IllegalArgumentException("Author required");
    }
    this.author = author;


    // ID: Hashing(Tittle + | + source + | + author
    this.id = LongHashFunction.xx().hashChars(title + "|" + source + "|" + author);

    this.url = url;
    this.urlImage = urlImage;

    // Description
    if(description == null || description.length() < 2){
      throw  new IllegalArgumentException("Description required");
    }
    this.description = description;

    // Content
    if(content == null || content.length() < 2){
      throw  new IllegalArgumentException("Content required");
    }
    this.content = content;

    // Published at
    if(publishedAt == null){
      throw  new IllegalArgumentException("Published at required");
    }
    this.publishedAt = publishedAt;
  }

  /**
   * ID unique.
   */
  @Getter
  private final Long id;

  /**
   * The Tittle.
   */
  @Getter
  private final String title;

  /**
   * the Source.
   */
  @Getter
  private final String source;

  /**
   * the Author.
   */
  @Getter
  private final String author;

  /**
   * the URL.
   */
  @Getter
  private final String url;

  /**
   * the URL Image.
   */
  @Getter
  private final String urlImage;

  /**
   * the Description.
   */
  @Getter
  private final String description;

  /**
   * the Content.
   */
  @Getter
  private final String content;

  /**
   * the published at date.
   */
  @Getter
  private final ZonedDateTime publishedAt;

}
