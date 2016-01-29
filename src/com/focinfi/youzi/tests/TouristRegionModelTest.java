package com.focinfi.youzi.tests;

import android.app.Activity;
import android.content.Context;
import com.focinfi.youzi.App;
import com.focinfi.youzi.beans.TouristRegionBean;
import com.focinfi.youzi.models.TouristRegionModel;

import java.io.IOException;

/**
 * Created by Antony on 16/1/22.
 */
public class TouristRegionModelTest extends Activity {

    public static TouristRegionModel touristRegionModel = new TouristRegionModel();

    public static void main(String args[]) throws IOException {
        TouristRegionBean touristRegionBean = touristRegionModel.mockTouristRegionBean;
        if(touristRegionBean.getName() == null){
            System.out.println("bean is null");
        }
//        System.out.print(new TouristRegionBean());
    }
}
