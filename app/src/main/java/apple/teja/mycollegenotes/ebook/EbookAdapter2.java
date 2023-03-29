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

public class EbookAdapter2 extends RecyclerView.Adapter<EbookAdapter2.EbookViewHolder> {
    private final Context context;

    public EbookAdapter2(Context context, List<EbookData2> list) {
        this.context = context;
        this.list = list;
    }

    private List<EbookData2> list;
    private EbookViewHolder holder;
    private int position;



    @NonNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.ebook_item_layout2,parent,false);

        return new EbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EbookViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.ebookName2.setText(list.get(position).getName2());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,pdfviewer2.class);
                intent.putExtra("pdfUrl",list.get(position).getPdfUrl2());
                context.startActivity(intent);
            }
        });

        holder.ebookDownload2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getPdfUrl2()));
                context.startActivity(intent);
            }
        });

        holder.pdf2.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_notif2));

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public void setList(List<EbookData2> list) {
        this.list = list;
    }

    public static class EbookViewHolder extends RecyclerView.ViewHolder {

        private final TextView ebookName2;
        private final ImageView ebookDownload2;

        private final CardView pdf2;

        public EbookViewHolder(@NonNull View itemView) {
            super(itemView);

            pdf2=itemView.findViewById(R.id.pdf2);

            ebookDownload2 = itemView.findViewById(R.id.ebookDownload2);
            ebookName2 =itemView.findViewById(R.id.ebookName2);
        }
    }
}
