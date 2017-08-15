package com.example.baidumappoi;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.location.Poi;

import java.util.List;

/**
 * Created by els on 17-6-2.
 */

public class PoiAdapter extends RecyclerView.Adapter<PoiAdapter.ViewHolder> {

    private List<Poi> mPoiList;

    private Activity mContext;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View poiView;
        TextView poiName;

        public ViewHolder(View view) {
            super(view);
            poiView = view;
            poiName = (TextView) view.findViewById(R.id.poi_name);
        }
    }

    public PoiAdapter(List<Poi> poiList, Activity context) {
        mPoiList = poiList;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.poi_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        holder.poiView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Poi poi = mPoiList.get(position);

                Intent intent = new Intent();
                intent.putExtra("location", poi.getName());
                mContext.setResult(Activity.RESULT_OK, intent);
                mContext.finish();
//                Toast.makeText(parent.getContext(), poi.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Poi poi = mPoiList.get(position);
        holder.poiName.setText(poi.getName());
    }

    @Override
    public int getItemCount() {
        return mPoiList.size();
    }
}
