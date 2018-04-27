package com.example.jordijaspers.musicgraph.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jordijaspers.musicgraph.Database.ArtistInfo;
import com.example.jordijaspers.musicgraph.DetailActivity;
import com.example.jordijaspers.musicgraph.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Adapter Class for the recycleView
 */
public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ViewHolder> {

    private static final String TAG = "ArtistAdapter";
    private Context mContext;

    private List<ArtistInfo> artistInfoList;


    /**
     * Constructor of the adapter
     */
    public ArtistAdapter(Context mContext, List<ArtistInfo> artistInfoList) {
        this.mContext = mContext;
        this.artistInfoList = artistInfoList;
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
        ArtistInfo artistInfo = artistInfoList.get(position);

        holder.header.setText(artistInfo.getArtistName());
        holder.subheader1.setText("Listeners: " + artistInfo.getListeners());
        holder.subheader2.setText("");

        holder.imageView.setImageResource(R.drawable.no_image);

        if(!artistInfo.getImageURL().isEmpty()) {
            Picasso.with(mContext).load(artistInfo.getImageURL()).into(holder.imageView);
        }

    }

    /**
     * A getter for the amount of items in the list.
     *
     * @return numberOfItems
     */
    @Override
    public int getItemCount() {
        return artistInfoList.size();
    }

    //------------------------------------------
    //SubClass starting.

    /**
     * Gets the Layout to bind the items to.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if (mToast != null){
                mToast.cancel();
            }

            String toastMessage = "Artist " + header.getText() + " Clicked";
            mToast = Toast.makeText(mContext, toastMessage,  Toast.LENGTH_SHORT);
            mToast.show();

            if(isNetworkAvailable()) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("ArtistName", header.getText());
                mContext.startActivity(intent);
            }
            else{
                mToast = Toast.makeText(mContext, "No Internet Connection: try again later.",  Toast.LENGTH_LONG);
            }
        }

        public boolean isNetworkAvailable() {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            assert connectivityManager != null;
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
    }
}
