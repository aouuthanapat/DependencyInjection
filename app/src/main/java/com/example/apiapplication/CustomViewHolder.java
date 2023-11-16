package com.example.apiapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    // ну это класс для одного элемента recyclerView и тут всё автоматически заполняется
    // название текст картинка....
    TextView text_title, text_source;
    ImageView img_headline;
    CardView cardView;
    ProgressBar progressBar;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        text_title = itemView.findViewById(R.id.text_title);
        text_source = itemView.findViewById(R.id.text_source);
        img_headline = itemView.findViewById(R.id.img_headline);
        cardView = itemView.findViewById(R.id.main_container);
        progressBar = itemView.findViewById(R.id.progressBar);
    }
    public void showProgressBar(boolean show) {
        // Показать или скрыть ProgressBar
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }
    public void showImageView (boolean show) {
        img_headline.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
