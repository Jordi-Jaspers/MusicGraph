package com.example.jordijaspers.musicgraph;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Adapter Class for the recycleView
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private  static final String TAG = "Adapter";
    private Cursor mCursor;
    private Context mContext;
    private int numberOfItems;
    private TextView results;

    /**
     * Constructor of the adapter
     * @param totalItems max numbers of items in the list.
     */
    public Adapter(int totalItems, Context context, Cursor cursor) {
        this.mContext = context;
        this.mCursor = cursor;
        this.numberOfItems = totalItems;
    }

    public void getResults(String JSONString) throws JSONException {
        JSONObject JSONInput = new JSONObject(JSONString);
        JSONObject results =  JSONInvoer.getJSONObject("results");
        JSONObject artistMatches = results.getJSONObject("artistMatches");
        JSONArray artists = artistmatches.getJSONArray("artist");
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

        LayoutInflater inflater = LayoutInflater.from(mContext);
        int layoutIdForListItem = R.layout.list_items;
        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);

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
        if (!cursor.moveToPosition(position)){
           return;
        }
        //put items here....
    }

    /**
     * A getter for the amount of items in the list.
     *
     * @return numberOfItems
     */
    @Override
    public int getItemCount() {
        if (cursor == null){
            return 0;
        }

        return numberOfItems;
    }

    public void swapCursor (Cursor newCursor){
        if (cursor != null){
            Log.i(TAG, "swapCursor: Closing the first cursor.");
            cursor.close();
        }
        else if (newCursor != null){
            Log.i(TAG, "swapCursor: Forcing the recycleView to refresh.");
            this.notifyDataSetChanged();
        }
        Log.i(TAG, "swapCursor: Swapping cursor.");
        cursor = newCursor;
    }

    //------------------------------------------
    //SubClass starting.

    /**
     * Gets the Layout to bind the items to.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final String TAG = "ViewHolder";
        private TextView listItemView;

        private Toast mToast;

        public ViewHolder(View itemView) {
            super(itemView);
            listItemView = (TextView) itemView.findViewById(R.id.tv_item);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();

            if (mToast != null){
                mToast.cancel();
            }

            String toastMessage = "Item #" + clickedPosition + "Clicked";
            mToast = Toast.makeText(context, toastMessage,  Toast.LENGTH_LONG);
            mToast.show();
        }
    }
}
