package com.androidarchitectureproject;

import android.app.Application;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

/**
 * Created by @yaksonn on 22.3.2018.
 */

public class AndroidArchitectureApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initPicasso();
    }

    private void initPicasso(){
        // DISK CACHE
        // Disk cache of 2% storage space up to 50MB but no less than 5MB
        // 48 megabyte
        //Picasso picasso =  new Picasso.Builder(this).downloader(new OkHttp3Downloader(getCacheDir(), 48 * 1024 * 1024)).build();
        Picasso picasso =  new Picasso.Builder(this).downloader(new OkHttp3Downloader(getCacheDir())).build();
        Picasso.setSingletonInstance(picasso);
        /*
        // MEMORY CACHE
        //default cache size is %15 of available memory
        // LRU memory cache of 15% the available application RAM
        //LruCache() takes byte parameter. Here is 4 megabyte
        Picasso.Builder picassoBuilder = new Picasso.Builder(this).memoryCache(new LruCache(8 * 1024 * 1024));
        Picasso.setSingletonInstance(picassoBuilder.build());
        */
    }
}
