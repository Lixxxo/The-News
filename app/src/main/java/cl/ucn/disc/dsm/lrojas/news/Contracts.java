/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cl.ucn.disc.dsm.lrojas.news;

import java.util.List;

/**
 * The Contracts of The News Project
 * @author Luis Rojas Olivera
 */
public interface Contracts {

  /**
   * @return all the News in the backend sorted by publishedAt
   */
  List<News> retrieveNews(int newsQuantity);

}
