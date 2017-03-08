package com.mpp.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mpp.project.business.CheckoutRecordEntry;

import java.util.List;

public class CheckoutRecordAdapter extends BaseAdapter {
    private List<CheckoutRecordEntry> list;
    private LayoutInflater mInflater;

    public CheckoutRecordAdapter(Context mContext, List<CheckoutRecordEntry> list) {
        this.list = list;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        final CheckoutRecordEntry entry = list.get(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_checkout_record, null);

            holder.tv_isbn = (TextView) convertView.findViewById(R.id.tv_isbn);
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tv_borrowDate = (TextView) convertView.findViewById(R.id.tv_borrowDate);
            holder.tv_dueDate = (TextView) convertView.findViewById(R.id.tv_dueDate);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_title.setText("Title:" + entry.getBook().getTitle());
        holder.tv_isbn.setText("ISBN:" + entry.getBook().getIsbn());
        holder.tv_borrowDate.setText("CheckoutDate: " + entry.getCheckoutDate());
        holder.tv_dueDate.setText("DueDate: " + entry.getDueDate());
        return convertView;
    }

    static class ViewHolder {
        TextView tv_title;
        TextView tv_isbn;
        TextView tv_borrowDate;
        TextView tv_dueDate;
    }

}

