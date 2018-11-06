package test.mvvm.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.jcodecraeer.xrecyclerview.ProgressStyle;

/**
 * Company By SQ
 * Created Date By 2018/11/3 0003
 * Created Time By 上午 10:44
 * Provide Content By MVVM
 * Created by HeBing
 * Provide Content By test.mvvm.helper
 */
public class DialogHelper {

    private ProgressDialog progressDialog;

    public static DialogHelper getInstance() {
        return LoadDialogHolder.instance;
    }

    private static class LoadDialogHolder {
        static DialogHelper instance = new DialogHelper();
    }

    /**
     * 展示加载框
     * @param context
     * @param msg
     */
    public void show(Context context,String msg){
        close();
        createDialog(context,msg);
        if(progressDialog!=null && !progressDialog.isShowing()){
            progressDialog.show();
        }
    }

    private void createDialog(Context context, String msg) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage(msg);
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                progressDialog = null;
            }
        });
    }

    /**
     * 关闭加载框
     */
    public void close(){
        if(progressDialog!=null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }


}
