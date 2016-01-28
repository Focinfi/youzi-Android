package com.focinfi.youzi.models;

import android.content.Context;
import com.focinfi.youzi.beans.TouristRegionBean;
import retrofit.Call;

import java.io.IOException;
import java.util.List;

/**
 * Created by Antony on 16/1/22.
 */
public interface ITouristRegionModel {
    TouristRegionBean find(String id, Context context) throws IOException;
    List<TouristRegionBean> findAll() throws IOException;
}
