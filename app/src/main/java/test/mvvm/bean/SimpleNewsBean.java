package test.mvvm.bean;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Company By SQ
 * Created Date By 2018/11/3 0003
 * Created Time By 上午 9:45
 * Provide Content By MVVM
 * Created by HeBing
 * Provide Content By test.mvvm.bean
 */
public class SimpleNewsBean {
    public ObservableInt color = new ObservableInt();
    public ObservableField<String> thumbnail = new ObservableField<>();
    public ObservableField<String> description = new ObservableField<>();
    public ObservableInt id = new ObservableInt();
    public ObservableField<String> name = new ObservableField<>();
    public ObservableBoolean isGood = new ObservableBoolean(); //是否点赞
}
