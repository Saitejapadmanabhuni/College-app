package apple.teja.mycollegenotes.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import apple.teja.mycollegenotes.R;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewAdapter> {


    private final Context context;

    public GalleryAdapter(Context context, List<String> images) {
        this.context = context;
        this.images = images;
    }

    private final List <String> images;


    @NonNull
    @Override
    public GalleryViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gallery_image, parent, false);
        return new GalleryViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewAdapter holder, @SuppressLint("RecyclerView") int position) {

       Glide.with(context).load(images.get(position)).into(holder.imageView2);

        holder.imgcard.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_notification));

    }

    @Override
    public int getItemCount() {

        return images.size();
    }


    public static class GalleryViewAdapter extends RecyclerView.ViewHolder {

        final ImageView imageView2;

        final CardView imgcard;

        public GalleryViewAdapter(@NonNull View itemView) {
            super(itemView);

            imageView2 = itemView.findViewById(R.id.image2);
            imgcard = itemView.findViewById(R.id.imgcard);

        }
    }
}
