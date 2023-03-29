package apple.teja.mycollegenotes.ebook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import apple.teja.mycollegenotes.R;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.EbookViewHolder> {
    private final Context context;


    public EbookAdapter(Context context, List<EbookData> list) {
        this.context = context;
        this.list = list;
    }

    private List<EbookData> list;
    private EbookViewHolder holder;
    private int position;



    @NonNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);

        return new EbookViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull EbookViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        this.position = position;

        holder.ebookName.setText(list.get(position).getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,pdfviewer.class);
                intent.putExtra("pdfUrl",list.get(position).getPdfUrl());
                context.startActivity(intent);
            }
        });



        holder.ebookDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getPdfUrl()));
                context.startActivity(intent);
            }
        });


        holder.pdf1.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_notif2));

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public void setList(List<EbookData> list) {
        this.list = list;
    }



    public static class EbookViewHolder extends RecyclerView.ViewHolder {

        private final TextView ebookName;
        private final CardView pdf1;
        private final ImageView ebookDownload;

        public EbookViewHolder(@NonNull View itemView) {
            super(itemView);

            ebookDownload = itemView.findViewById(R.id.ebookDownload);
            pdf1=itemView.findViewById(R.id.pdf1);
            ebookName =itemView.findViewById(R.id.ebookName);
        }
    }
}
