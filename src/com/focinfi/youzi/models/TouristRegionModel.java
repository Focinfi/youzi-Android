package com.focinfi.youzi.models;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;
import com.focinfi.youzi.App;
import com.focinfi.youzi.apis.YouziService;
import com.focinfi.youzi.beans.TouristRegionBean;
import com.focinfi.youzi.utils.NetworkStatus;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import retrofit.Call;
import retrofit.Retrofit;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antony on 16/1/22.
 */
public class TouristRegionModel implements ITouristRegionModel {
    private OkHttpClient client = new OkHttpClient();
    public TouristRegionBean mockTouristRegionBean = new TouristRegionBean();
    public List<TouristRegionBean> mockTouristRegionList = new ArrayList<TouristRegionBean>();

    @Override
    public TouristRegionBean find(String id, Context context) throws IOException {
        if (App.getSingleton().isTestMode()) {
            if (mockTouristRegionBean.getId() == null) {
                mockTouristRegionBean = mockLoad("1");
            }
        } else {
            return load(id);
        }

        return mockTouristRegionBean;
    }

    @Override
    public List<TouristRegionBean> findAll() throws IOException {
        if (App.getSingleton().isTestMode()) {
            if (mockTouristRegionList.isEmpty()) {
                mockTouristRegionList.add(mockLoad("1"));
            }
        } else {
            return loadAll();
        }

        return mockTouristRegionList;
    }

    public TouristRegionBean load(String id) throws IOException {
        Request request = new Request.Builder()
                .url("http://139.129.45.140:3000/tourist_regions/" + id)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            return gson.fromJson(response.body().string(), new TypeToken<TouristRegionBean>(){}.getType());
        } else {
            throw new IOException("Can not get data " + response);
        }
    }

    public List<TouristRegionBean> loadAll() throws IOException {
        Request request = new Request.Builder()
                .url("http://139.129.45.140:3000/tourist_regions")
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            Type type = new TypeToken<ArrayList<TouristRegionBean>>() {
            }.getType();
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            return gson.fromJson(response.body().string(), type);
        } else {
            throw new IOException("Can not get data " + response);
        }
    }

    public TouristRegionBean mockLoad(String id) {
        TouristRegionBean touristRegionBean = new TouristRegionBean();

        touristRegionBean.setId(id);
        touristRegionBean.setName("中山陵园风景区");
        touristRegionBean.setDesc("中山陵是中国近代伟大的民主革命先行者孙中山先生的陵寝，及其附属纪念建筑群，面积8万余平方米。中山陵自1926年春动工，至1929年夏建成，1961年成为首批全国重点文物保护单位，2006年列为首批国家重点风景名胜区和国家5A级旅游景区。<br>中山陵位于南京市玄武区紫金山南麓钟山风景区内，前临平川，背拥青嶂，东毗灵谷寺，西邻明孝陵，整个建筑群依山势而建，由南往北沿中轴线逐渐升高，主要建筑有博爱坊、墓道、陵门、石阶、碑亭、祭堂和墓室等，排列在一条中轴线上，体现了中国传统建筑的风格，从空中往下看，像一座平卧在绿绒毯上的“自由钟”。融汇中国古代与西方建筑之精华，庄严简朴，别创新格。<br>中山陵各建筑在型体组合、色彩运用、材料表现和细部处理上均取得极好的效果，音乐台、光华亭、流徽榭、仰止亭、藏经楼、行健亭、永丰社、永慕庐、中山书院等建筑众星捧月般环绕在陵墓周围，构成中山陵景区的主要景观，色调和谐统一更增强了庄严的气氛，既有深刻的含意，又有宏伟的气势，且均为建筑名家之杰作，极高的艺术价值，被誉为“中国近代建筑史上第一陵”。");
        touristRegionBean.setLevel("AAAAA");
        touristRegionBean.setOpenTime("08:30-17:00周一闭馆维护");
        touristRegionBean.setLocation("南京市玄武区石象路7号");
        touristRegionBean.setPrice(0);
        touristRegionBean.setLatitude(32.0586758184);
        touristRegionBean.setLongitude(118.8528011427);
        touristRegionBean.setVoiceUrl("http://7xq9t3.com1.z0.glb.clouddn.com/zhongshanling.mp3");
        touristRegionBean.setVideoUrl("http://player.youku.com/embed/XMzgzMDgyNzI=");

        List<String> pictureUrlsList = new ArrayList<String>();
        pictureUrlsList.add("http://7xq9t3.com1.z0.glb.clouddn.com/zhongshanling_01.png");
        pictureUrlsList.add("http://7xq9t3.com1.z0.glb.clouddn.com/zhongshanling_01.png");
        touristRegionBean.setPictureUrls(pictureUrlsList);
        return touristRegionBean;
    }
}
