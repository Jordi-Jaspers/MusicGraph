package com.example.jordijaspers.musicgraph.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jordijaspers.musicgraph.Database.SongInfo;
import com.example.jordijaspers.musicgraph.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Adapter Class for the recycleView
 */
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private static final String TAG = "SongAdapter";
    private Context mContext;

    private List<SongInfo> songInfoList;


    /**
     * Constructor of the adapter
     */
    public SongAdapter(Context mContext, List<SongInfo> songInfoList) {
        this.mContext = mContext;
        this.songInfoList = songInfoList;
    }

    /**
     * Creates the viewHolder for the adapter.
     *
     * @param viewGroup viewgroup
     * @param viewType viewtype
     * @return the created viewHolder.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_items, viewGroup, false);
        return new ViewHolder(view);
    }


    /**
     * binds the position of the holder.
     *
     * @param holder what holder to bind it to.
     * @param position index of the item.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SongInfo songInfo = songInfoList.get(position);

        holder.header.setText(songInfo.getSongName());
        holder.subheader1.setText("Artist: " + songInfo.getArtistName());
        holder.subheader2.setText("listeners: " + songInfo.getListeners());
        holder.imageView.setImageResource(R.drawable.no_image);

        //failsafe for nullpointer exception.
        if(!songInfo.getImageURL().isEmpty()) {
            Picasso.with(mContext).load(songInfo.getImageURL()).into(holder.imageView);
        }
    }

    /**
     * A getter for the amount of items in the list.
     *
     * @return numberOfItems
     */
    @Override
    public int getItemCount() {
        return songInfoList.size();
    }

    //------------------------------------------
    //SubClass starting.

    /**
     * Gets the Layout to bind the items to.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "ViewHolder";

        private TextView header;
        private TextView subheader1;
        private TextView subheader2;
        private ImageView imageView;

        private Toast mToast;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            header = itemView.findViewById(R.id.tv_item_header);
            subheader1 = itemView.findViewById(R.id.tv_sub_header1);
            subheader2 = itemView.findViewById(R.id.tv_sub_header2);
        }
    }
}
