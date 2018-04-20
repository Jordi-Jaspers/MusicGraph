package com.example.jordijaspers.musicgraph.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jordijaspers.musicgraph.Database.SongInfo;
import com.example.jordijaspers.musicgraph.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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

        holder.header.setText("Song: " + songInfo.getSongName());
        holder.subheader1.setText("Artist: " + songInfo.getArtistName());
        holder.subheader2.setText("listeners: " + songInfo.getListeners());

//        ImageLoadingTask task = new ImageLoadingTask();
//        task.execute();
//
//        holder.imageView.setImageBitmap(task.doInBackground(artistInfo.getImageURL()));
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
            int clickedPosition = getAdapterPosition();

            if (mToast != null){
                mToast.cancel();
            }

            String toastMessage = "Item #" + clickedPosition + "Clicked";
            mToast = Toast.makeText(mContext, toastMessage,  Toast.LENGTH_LONG);
            mToast.show();
            //MAKE INTENT TO SHOW DETAILWINDOW.
        }
    }

    //------------------------------------------
    //SubClass starting.

    public static class ImageLoadingTask extends AsyncTask<String, Void , Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            URL url = null;
            try {
                String str = strings[0];
                url = new URL(str);
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                return bmp;
            } catch (MalformedURLException exception) {
                Log.e(TAG, "DoInBackground: MalformedURLException Error: ", exception);
            } catch (IOException exception) {
                Log.e(TAG, "DoInBackground: IOException Error: ", exception);
            }
            return null;
        }

    }

}
