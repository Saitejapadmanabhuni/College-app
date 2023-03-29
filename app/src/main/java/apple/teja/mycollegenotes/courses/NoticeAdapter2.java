package apple.teja.mycollegenotes.courses;

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

public class NoticeAdapter2 extends RecyclerView.Adapter<NoticeAdapter2.NoticeViewAdapter> {

    private final Context context;
    private final ArrayList<NoticeData2> list;



    public NoticeAdapter2(Context context, ArrayList<NoticeData2> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.courses_layout, parent, false);
        return new NoticeViewAdapter(view);
    }


    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, int position) {

        final NoticeData2 currentItem = list.get(position);


        holder.deleteNoticeTitle.setText(currentItem.getTitle());

        try {
            if (currentItem.getImage() != null) {
                Picasso.get().load(currentItem.getImage()).into(holder.deleteNoticeImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.coursescard.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_courses));

        holder.deleteNoticeTitle.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_courses));

        holder.deleteNoticeImage.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_courses));



    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class NoticeViewAdapter extends RecyclerView.ViewHolder {


        private final ImageView deleteNoticeImage;
        private final TextView deleteNoticeTitle;

        private final CardView coursescard;




        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);

            deleteNoticeTitle = itemView.findViewById(R.id.deleteNoticeTitle);
            deleteNoticeImage = itemView.findViewById(R.id.deleteNoticeImage);
            coursescard = itemView.findViewById(R.id.coursescard);




        }


    }



}
