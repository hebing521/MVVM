package test.mvvm.helper;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Company By SQ
 * Created Date By 2018/11/3 0003
 * Created Time By 下午 1:56
 * Provide Content By MVVM
 * Created by HeBing
 * Provide Content By test.mvvm.helper
 */
public class ImageHelper {

    @BindingAdapter({"imgUrl"})
    public static void loadImage(ImageView imageView,String url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @BindingAdapter({"resId"})
    public static void loadMapmapResource(ImageView iv,int resId){
        iv.setImageResource(resId);
    }
}
