package com.example.apiapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiapplication.Models.NewsHeadlines;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private final Context context;
    private final List<NewsHeadlines> headlines;
    private final SelectListener listener;

    public CustomAdapter(Context context, List<NewsHeadlines> headlines, SelectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener = listener;
        // конструктор адаптера
        // listener включает интерфейс SelectListener который уведомляет об активации элементов списка
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_items, parent, false));
        // ViewHolder - один элемент из списка и заполняет макет из headline_list_items
    }


    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        NewsHeadlines currentHeadline = headlines.get(position);

        holder.text_title.setText(currentHeadline.getTitle());
        holder.text_source.setText(currentHeadline.getSource().getName());

        // Показать ProgressBar перед загрузкой
        holder.showProgressBar(true);

        // Загрузка изображения (пример с Picasso)
        if (currentHeadline.getUrlToImage() != null) {
            Picasso.get().load(currentHeadline.getUrlToImage()).into(holder.img_headline, new Callback() {
                @Override
                public void onSuccess() {
                    holder.showImageView(true);
                    holder.showProgressBar(false);
                }

                @Override
                public void onError(Exception e) {
                    holder.showProgressBar(false);
                    holder.showImageView(true);
                    // Дополнительная обработка ошибки, если это необходимо
                }
            });
        } else {
            // Если у новости нет изображения, скройте ProgressBar
            holder.showProgressBar(false);
            // Установите изображение "not_available"
            holder.img_headline.setImageResource(R.drawable.not_available);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnNewsClicked(currentHeadline);
            }
        });
    }

    @Override
    public int getItemCount() {
        return headlines.size();
        // при выходе из экрана с подробной информацией возвращает size recyclerView
    }
}
