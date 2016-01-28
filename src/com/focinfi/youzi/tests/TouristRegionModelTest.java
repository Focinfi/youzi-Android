package com.focinfi.youzi.tests;

import android.app.Activity;
import android.content.Context;
import com.focinfi.youzi.beans.TouristRegionBean;
import com.focinfi.youzi.models.TouristRegionModel;

import java.io.IOException;

/**
 * Created by Antony on 16/1/22.
 */
public class TouristRegionModelTest extends Activity {

    public static TouristRegionModel touristRegionModel = new TouristRegionModel();

    public static void main(String args[]) throws IOException {
        String response = touristRegionModel.loadAll().get(0).getDesc();
        System.out.println(response);
//        System.out.print(new TouristRegionBean());
    }
}
