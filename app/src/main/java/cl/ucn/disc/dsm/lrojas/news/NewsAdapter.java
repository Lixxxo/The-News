package cl.ucn.disc.dsm.lrojas.news;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cl.ucn.disc.dsm.lrojas.news.model.News;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;


public final class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

  private List<News> newsList = new ArrayList<>();

  /**
   * The Constructor
   */
  public NewsAdapter(){
    // Nothing here
  }

  /**
   * Populate newsList
   * @param newsList
   */
  public void setNewsList(final List<News> newsList) {
    this.newsList = newsList;
  }

  /**
   * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent an
   * item.
   * <p>
   * This new ViewHolder should be constructed with a new View that can represent the items of the
   * given type. You can either create a new View manually or inflate it from an XML layout file.
   * <p>
   * The new ViewHolder will be used to display items of the adapter using {@link
   * #onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display different items
   * in the data set, it is a good idea to cache references to sub views of the View to avoid
   * unnecessary {@link View#findViewById(int)} calls.
   *
   * @param parent   The ViewGroup into which the new View will be added after it is bound to an
   *                 adapter position.
   * @param viewType The view type of the new View.
   * @return A new ViewHolder that holds a View of the given view type.
   * @see #getItemViewType(int)
   * @see #onBindViewHolder(ViewHolder, int)
   */
  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    // Step 1: Get the inflater
    final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    // Step 2: Inflate the row of Contact
    final View newsView = layoutInflater.inflate(R.layout.row_news, parent, false);
    // Step 3: Build the ViewHolder
    return new ViewHolder(newsView);
  }

  /**
   * Called by RecyclerView to display the data at the specified position. This method should update
   * the contents of the {@link ViewHolder#itemView} to reflect the item at the given position.
   * <p>
   * Note that unlike {@link ListView}, RecyclerView will not call this method again if the position
   * of the item changes in the data set unless the item itself is invalidated or the new position
   * cannot be determined. For this reason, you should only use the <code>position</code> parameter
   * while acquiring the related data item inside this method and should not keep a copy of it. If
   * you need the position of an item later on (e.g. in a click listener), use {@link
   * ViewHolder#getAdapterPosition()} which will have the updated adapter position.
   * <p>
   * Override {@link #onBindViewHolder(ViewHolder, int, List)} instead if Adapter can handle
   * efficient partial bind.
   *
   * @param holder   The ViewHolder which should be updated to represent the contents of the item at
   *                 the given position in the data set.
   * @param position The position of the item within the adapter's data set.
   */
  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    // Get news at position
    final News news = this.newsList.get(position);

    holder.title.setText(news.getTitle());
    holder.source.setText(news.getSource());
    holder.author.setText(news.getAuthor());
    //holder.url.setText(news.getUrl());
    //holder.urlImage.setImageResource(news.getUrlImage().);
    holder.description.setText(news.getDescription());
    //holder.content.setText(news.getContent());
    holder.publishedAt.setText(
        news.getPublishedAt().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM)));

  }

  /**
   * Returns the total number of items in the data set held by the adapter.
   *
   * @return The total number of items in this adapter.
   */
  @Override
  public int getItemCount() {
    return this.newsList.size();
  }

  /**
   * The ViewHolder
   */
  protected static class ViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView source;
    private TextView author;
    private TextView url;
    private ImageView urlImage;
    private TextView description;
    private TextView content;
    private TextView publishedAt;

    public ViewHolder(View view){
      super(view);
      this.title = view.findViewById(R.id.rn_tv_title);
      this.source = view.findViewById(R.id.rn_tv_source);
      this.author = view.findViewById(R.id.rn_tv_author);
      this.url = view.findViewById(R.id.rn_tv_url);
      this.urlImage = view.findViewById(R.id.rn_tv_urlImage);
      this.description = view.findViewById(R.id.rn_tv_description);
      this.content = view.findViewById(R.id.rn_tv_content);
      this.publishedAt = view.findViewById(R.id.rn_tv_publishedAt);
    }
  }
}
