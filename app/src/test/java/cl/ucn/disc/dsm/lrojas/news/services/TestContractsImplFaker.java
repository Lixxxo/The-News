/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cl.ucn.disc.dsm.lrojas.news.services;

import cl.ucn.disc.dsm.lrojas.news.model.News;
import cl.ucn.disc.dsm.lrojas.news.services.Contracts;
import cl.ucn.disc.dsm.lrojas.news.services.ContractsImplFaker;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestContractsImplFaker {


  @Test
  public void testConstructor(){

  }

  @Test void testRetrieveNews(){
    final Contracts contracts = new ContractsImplFaker();

    Assertions.assertNotNull(contracts, "Contracts was null");
    final int N = 10;
    final List<News> listNews = contracts.retrieveNews(N);
    Assertions.assertNotNull(listNews, "List was null");
    Assertions.assertEquals(N, listNews.size(), "Wrong number of elements");
  }
}
