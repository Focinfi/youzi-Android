package com.focinfi.youzi.presenters;

import android.content.Context;
import com.focinfi.youzi.beans.TouristRegionBean;
import com.focinfi.youzi.models.ITouristRegionModel;
import com.focinfi.youzi.models.TouristRegionModel;
import com.focinfi.youzi.views.ITouristRegionView;

import java.io.IOException;

/**
 * Created by Antony on 16/1/22.
 */
public class TouristRegionPresenter {
    private ITouristRegionView touristRegionView;
    private ITouristRegionModel touristRegionModel;

    public TouristRegionPresenter(ITouristRegionView view) {
        touristRegionView = view;
        touristRegionModel = new TouristRegionModel();
    }

    public TouristRegionBean findTouristRegion(String id,  Context context) throws IOException {
        return touristRegionModel.find(id, context);
    }
}
