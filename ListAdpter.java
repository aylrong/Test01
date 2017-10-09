package twocloo.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2cloo on 2017/5/19.
 */

public class ListAdpter extends BaseAdapter{

    private Context mContext;
    private List<Bean> infos;
    public ListAdpter(Context mContext){
        this.mContext = mContext;
        infos = new ArrayList<>();
    }
    public void addData(List<Bean> list){
        infos.addAll(list);
    }
    public List<Bean> getData(){
        return this.infos;
    }
    @Override
    public int getCount() {
        return infos.size();
    }

    @Override
    public Object getItem(int position) {
        return infos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item,null);
        TextView titleTv = (TextView) convertView.findViewById(R.id.title);
        titleTv.setText(infos.get(position).getTypeName());
        LinearLayout mLinView = (LinearLayout) convertView.findViewById(R.id.line);
        List<ProductVOListBean> mList = new ArrayList<>();
        mList = infos.get(position).getProductVOList();
        if(mList.size()>0){
            mLinView.removeAllViews();
            for(int i= 0;i < mList.size();i++){
                View viewitem = LayoutInflater.from(mContext).inflate(
                        R.layout.title_linear, null);
                TextView proname = (TextView) viewitem.findViewById(R.id.name);
                proname.setText(infos.get(position).getProductVOList().get(i).getName());
                TextView prorate = (TextView) viewitem.findViewById(R.id.date);
                prorate.setText(infos.get(position).getProductVOList().get(i).getId());
                mLinView.addView(viewitem);
            }
        }
        return convertView;
    }
}
