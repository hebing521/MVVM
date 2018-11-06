package test.mvvm.bean;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Company By SQ
 * Created Date By 2018/11/3 0003
 * Created Time By 上午 10:05
 * Provide Content By MVVM
 * Created by HeBing
 * Provide Content By test.mvvm.bean
 */
public abstract class BaseAdapter<T,VH extends RecyclerView.ViewHolder> extends  RecyclerView.Adapter<VH> {
    public Context mContext;
    public List<T> mList;//数据源
    public LayoutInflater inflater;

    public BaseAdapter(Context mContext) {
        this.mContext = mContext;
        this.mList = new ArrayList<>();
        inflater = (LayoutInflater) mContext.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return onCreateVH(viewGroup,i);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        onBindVH(vh,i);
    }

    /**
     * 创建 View  Holder
     * @param parent
     * @param viewType
     * @return
     */
    public abstract VH onCreateVH(ViewGroup parent,int viewType);


    /**
     * 绑定 View Holder
     * @param vh
     * @param position
     */
    public abstract void onBindVH(VH vh,int position);

    /**
     * 刷新数据
     * @param list
     */
    public void refreshData(List<T> list){
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * 加载更多
     * @param list
     */
    public void loadMore(List<T> list){
        mList.addAll(list);
        notifyDataSetChanged();
    }
}
