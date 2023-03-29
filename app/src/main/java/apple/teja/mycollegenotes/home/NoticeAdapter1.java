package apple.teja.mycollegenotes.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

public class NoticeAdapter1 extends RecyclerView.Adapter<NoticeAdapter1.NoticeViewAdapter> {

    private final Context context;

    private int limit=3;
    private final ArrayList<NoticeData1> list;


    public NoticeAdapter1(Context context, ArrayList<NoticeData1> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_layout, parent, false);
        return new NoticeViewAdapter(view);
    }


    @Override
    public void onBindViewHolder(NoticeViewAdapter holder, @SuppressLint("RecyclerView") int position) {

        final NoticeData1 currentItem = list.get(position);


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

        holder.sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String shareBody = "Hi! Download Mrits from Play-store to stay updated on latest college updates "+"https://play.google.com/store/apps/details?id=apple.teja.mycollegenotes"
                        +"   New  " +
                        "Notice updated check it out!"+currentItem.getTitle();
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, "Send To"));

            }
        });


        holder.notificationcard.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_notif));

        holder.notificationcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(v.getContext(),Notification.class);
                intent.putExtra("title",currentItem.getTitle());
                intent.putExtra("image",currentItem.getImage());
                intent.putExtra("date",currentItem.getDate());
                intent.putExtra("time",currentItem.getTime());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {

      if(list.size()>limit){
          return limit;
      }
      else {
          return list.size();
      }
    }


    public static class NoticeViewAdapter extends RecyclerView.ViewHolder {


        private final ImageView deleteNoticeImage,sharebtn;
        private final TextView deleteNoticeTitle;
        private final TextView date;
        private final TextView time;

        private final CardView notificationcard;





        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);

            deleteNoticeTitle = itemView.findViewById(R.id.deleteNoticeTitle);
            deleteNoticeImage = itemView.findViewById(R.id.deleteNoticeImage);

            sharebtn=itemView.findViewById(R.id.sharebtn);

            notificationcard = itemView.findViewById(R.id.notificationcard);
            time = itemView.findViewById(R.id.time);
            date = itemView.findViewById(R.id.date);
        }
    }

}
