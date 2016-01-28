package com.focinfi.youzi.apis;

import com.focinfi.youzi.beans.TouristRegionBean;
import retrofit.Call;
import retrofit.http.GET;

import java.util.List;

/**
 * Created by Antony on 16/1/22.
 */
public interface YouziService {
    @GET("/tourist_regions")
    Call<List<TouristRegionBean>> listTouristRegionBean();
}
