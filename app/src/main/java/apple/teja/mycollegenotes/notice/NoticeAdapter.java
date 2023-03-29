package apple.teja.mycollegenotes.notice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import apple.teja.mycollegenotes.R;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter> {

    private final Context context;
    private final ArrayList<NoticeData> list;


    public NoticeAdapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newsfeed_layout, parent, false);
        return new NoticeViewAdapter(view);
    }



    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, int position) {

        final NoticeData currentItem = list.get(position);


        holder.deleteNoticeTitle.setText(currentItem.getTitle());
        holder.date.setText(currentItem.getDate());
        holder.time.setText(currentItem.getTime());


        try {
            if (currentItem.getImage() != null) {
                Picasso.get().load(currentItem.getImage()).into(holder.deleteNoticeImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.cardnoti.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_notification));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class NoticeViewAdapter extends RecyclerView.ViewHolder {


        private final ImageView deleteNoticeImage;
        private final TextView deleteNoticeTitle;
        private final TextView date;
        private final TextView time;
        private final CardView cardnoti;

        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);

            deleteNoticeTitle = itemView.findViewById(R.id.deleteNoticeTitle);
            deleteNoticeImage = itemView.findViewById(R.id.deleteNoticeImage);
           cardnoti = itemView.findViewById(R.id.cardnoti);


            time = itemView.findViewById(R.id.time);
            date = itemView.findViewById(R.id.date);

        }
    }

}
