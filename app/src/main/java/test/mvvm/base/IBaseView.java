package test.mvvm.base;

/**
 * Company By SQ
 * Created Date By 2018/11/3 0003
 * Created Time By 上午 9:47
 * Provide Content By MVVM
 * Created by HeBing
 * Provide Content By test.mvvm.base
 */
public interface IBaseView {


    /**
     * 开始加载
     * @param loadType 加载的类型 0：第一次加载  1：下拉加载  2：上拉加载更多
     */
    void loadStart(int loadType);


    /**
     * 加载完成
     */
    void loadComplete();


    /**
     * 加载失败
     * @param message
     */
    void loadFailure(String message);
}

