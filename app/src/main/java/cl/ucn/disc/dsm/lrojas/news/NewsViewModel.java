/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cl.ucn.disc.dsm.lrojas.news;

import android.app.Application;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cl.ucn.disc.dsm.lrojas.news.model.News;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.kwabenaberko.newsapilib.network.APIClient;
import com.kwabenaberko.newsapilib.network.APIService;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Response;


public class NewsViewModel extends AndroidViewModel {

  /**
   * The {@link List} of {@link News}
   */
  private MutableLiveData<List<News>> newsList;
  /**
   * The API KEY from newsapi.org.
   */
  final String API_KEY = "a80f0e7d2efb4580b1b049815f8456ac";

  /**
   * The News Api Client.
   */
  NewsApiClient newsApiClient = new NewsApiClient(API_KEY);


  /**
   * The constructor of the class
   * @param application the application to use
   */
  public NewsViewModel(@NonNull Application application){
    super(application);
  }

  public MutableLiveData<List<News>> getNews(){
    // Lazy load
    if (this.newsList == null){
      this.newsList = new MutableLiveData<>();
      this.loadRecentNews();
    }
    return this.newsList;
  }

  /**
   * Read the News from News-API-Java and saves it in memory
   */
  private void loadRecentNews() {

    // WARNING: JUST for testing
    final String API_KEY = "85b341510d8741c6b100b03f18ac5c9b";
    final String category = "general";
    final int pageSize = 50;
    final String language = "es";


    AsyncTask.execute(() ->{
      try {
        // 1. Create the APIService from APIClient
        final APIService apiService = APIClient.getAPIService();

        // 2. Build http request params
        final Map<String, String> reqParams = new HashMap<>();
        // The API key
        reqParams.put("apiKey", API_KEY);
        // Filter by category
        reqParams.put("category", category);
        // Filter by country
        reqParams.put("language", language);
        // The number of results per page (20 = min, 100 = max)
        reqParams.put("pageSize", String.valueOf(pageSize));

        // 3. Call the Request
        Response<ArticleResponse> articlesResponse =
            apiService.getTopHeadlines(reqParams).execute();

        // Success !
        if(articlesResponse.isSuccessful()){

          List<Article> articles = articlesResponse.body().getArticles();

          List<News> news = new ArrayList<>();
          // Conversion for List<Article> -> List<News>
          for (Article article: articles) {
            News n = toNews(article);
              news.add(n);
          }

          // 4. Save into the local list
          this.newsList.postValue(news);

        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    });


  }


  /**
   * Convert article to News
   *
   * @param article to convert
   * @return the News converted
   */
  private static News toNews(final Article article){

    // Protection: author
    if(article.getAuthor() == null || article.getAuthor().length() < 3){
      article.setAuthor("**[No Author]**");
    }
    // Protection: title
    if(article.getTitle() == null || article.getTitle().length() < 3){
      article.setTitle("**[No Tittle]**");
    }
    // Protection: description
    if(article.getDescription() == null || article.getDescription().length() < 3){
      article.setDescription("**[No Description]**");
    }

    ZonedDateTime publishedAt = ZonedDateTime
        .parse(article.getPublishedAt())
        // Correct from UTC to LocalTime (Chile summer);
        .withZoneSameInstant(ZoneId.of("-3"));

    // Construct News from Article
    return new News(
        article.getTitle(),
        article.getSource().getName(),
        article.getAuthor(),
        article.getUrl(),
        article.getUrlToImage(),
        article.getDescription(),
        article.getDescription(),
        publishedAt
    );
  }
}
