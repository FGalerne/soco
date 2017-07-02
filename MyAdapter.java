package com.flo.soco;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * Created by florian on 30/06/17.
 */

public class MyAdapter extends RecyclerView.ViewHolder {

    public List<Business> businessList;
    

    public MyAdapter(View itemView) {
        super(itemView);
    }
}
