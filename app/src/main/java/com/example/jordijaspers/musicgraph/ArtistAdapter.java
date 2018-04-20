package com.example.jordijaspers.musicgraph;

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

import com.example.jordijaspers.musicgraph.Database.ArtistInfo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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

        holder.artistName.setText(artistInfo.getArtistName());
        holder.listeners.setText(String.valueOf(artistInfo.getListeners()));
        holder.website.setText(artistInfo.getWebsite());

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
        return artistInfoList.size();
    }

    //------------------------------------------
    //SubClass starting.

    /**
     * Gets the Layout to bind the items to.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final String TAG = "ViewHolder";

        private TextView artistName;
        private TextView website;
        private TextView listeners;
        private ImageView imageView;

        private Toast mToast;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            website = itemView.findViewById(R.id.tv_item_URL);
            listeners = itemView.findViewById(R.id.tv_item_listeners);
            artistName = itemView.findViewById(R.id.tv_item_header);

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
