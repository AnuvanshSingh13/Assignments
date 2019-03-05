package com.example.recyclerviewasignment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.recyclerviewasignment.Exercise3Activity.TYPE_IMAGE;
import static com.example.recyclerviewasignment.Exercise3Activity.TYPE_TEXT;
import static com.example.recyclerviewasignment.Exercise3Activity.TYPE_TEXT_WITH_IMAGE;


public class Exercise3Activity extends AppCompatActivity {
    public static final int TYPE_IMAGE = 0;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_TEXT_WITH_IMAGE = 2;

    private RecyclerView recyclerView;
    private List list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList();
        populateList();

        recyclerView = findViewById(R.id.recycler_view_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CustomRecyclerAdapter(list));
    }

    private void populateList() {
        list.add(new ModalClassRowImage(R.mipmap.ic_launcher, TYPE_IMAGE));
        list.add(new ModalClassRowText("This is text", TYPE_TEXT));
        list.add(new ModalClassRowImageText("This is title", R.mipmap.ic_launcher, TYPE_TEXT_WITH_IMAGE));
    }
}
class RowTextViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public RowTextViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_only);
    }
}

class RowImageViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;

    public RowImageViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_only);
    }
}

class RowImageTextViewHolder extends RecyclerView.ViewHolder {

    TextView textView;
    ImageView imageView;

    public RowImageTextViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_from_imgtxt);
        imageView = itemView.findViewById(R.id.image_from_imgtxt);
    }
}

class CustomRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List list;

    public CustomRecyclerAdapter(List list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == TYPE_TEXT) {
            View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_text, viewGroup, false);
            return new RowTextViewHolder(itemView);
        } else if (i == TYPE_IMAGE) {
            View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_image, viewGroup, false);
            return new RowImageViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_image_text, viewGroup, false);
            return new RowImageTextViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof RowImageViewHolder) {
            ModalClassRowImage modalClassRowImage = (ModalClassRowImage) list.get(i);
            ((RowImageViewHolder) viewHolder).imageView.setImageResource(modalClassRowImage.getImgRes());
        } else if (viewHolder instanceof RowTextViewHolder) {
            ModalClassRowText modalClassRowText = (ModalClassRowText) list.get(i);
            ((RowTextViewHolder) viewHolder).textView.setText(modalClassRowText.getText());
        } else {
            ModalClassRowImageText modalClassRowImageText = (ModalClassRowImageText) list.get(i);
            ((RowImageTextViewHolder) viewHolder).imageView.setImageResource(modalClassRowImageText.getImgRes());
            ((RowImageTextViewHolder) viewHolder).textView.setText(modalClassRowImageText.getText());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_IMAGE;
        if (position == 1)
            return TYPE_TEXT;
        else
            return TYPE_TEXT_WITH_IMAGE;
    }
}