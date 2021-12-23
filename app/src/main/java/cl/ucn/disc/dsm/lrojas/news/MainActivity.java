/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cl.ucn.disc.dsm.lrojas.news;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {

  /**
   * The News Adapter
   */
  protected NewsAdapter newsAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    AppCompatDelegate.setDefaultNightMode(
        AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = findViewById(R.id.ab_mt_toolbar);
    setSupportActionBar(toolbar);

    // get the list (RecycleView)
    final RecyclerView recyclerView = findViewById(R.id.am_rv_news);

    // The type of layout of RecycleView
    recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    // Build the adapter
    this.newsAdapter = new NewsAdapter();
    // Union of Adapter + RecycleView
    recyclerView.setAdapter(this.newsAdapter);

    // Instance NewsViewModel
    NewsViewModel newsViewModel = ViewModelProvider
        .AndroidViewModelFactory  // The Factory
        .getInstance(this.getApplication()) // Singleton instance of Factory
        .create(NewsViewModel.class); // Call the Constructor of NewsViewModel

    // Observe List of News
    newsViewModel.getNews().observe(this, newsList -> {
      // Set the newsList (from view model)
      newsAdapter.setNewsList(newsList);
      // Refresh Recycler (ListView)
      newsAdapter.notifyDataSetChanged();
    });

  }

}