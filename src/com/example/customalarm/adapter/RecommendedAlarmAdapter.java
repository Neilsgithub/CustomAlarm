package com.example.customalarm.adapter;

import java.util.ArrayList;

import com.example.customalarm.core.Alarm;
import com.example.customalarm.ui.AlarmSplitter;
import com.example.customalarm.ui.RecommendedAlarmItem;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class RecommendedAlarmAdapter extends BaseBaseAdapter<Alarm> {
	private Context mContext;

	public RecommendedAlarmAdapter(Context context) {
		mContext = context;
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO 自动生成的方法存根
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO 自动生成的方法存根
		return position;
	}

	@Override
	public int getItemViewType(int position) {
		// TODO 自动生成的方法存根
		return list.get(position).getIsSplitter() ? 1 : 0;
	}

	@Override
	public int getViewTypeCount() {
		// TODO 自动生成的方法存根
		return 2;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			if (getItemViewType(position) == 1) {
				// splitter
				convertView = new AlarmSplitter(mContext);
				holder.splitter = (AlarmSplitter) convertView;
			} else {
				convertView = new RecommendedAlarmItem(mContext);
				holder.itemView = (RecommendedAlarmItem) convertView;
			}
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		if (getItemViewType(position) == 1) {
			holder.splitter.setTagTip(list.get(position).getTag());
			// holder.splitter.setLeftImage(null);
			// holder.splitter.setRightImage(null);
		} else {
			Bundle bundle = Alarm.alarm2Bundle(list.get(position));
			holder.itemView.setDataBundle(bundle);
		}
		return convertView;
	}

	public class ViewHolder {
		public RecommendedAlarmItem itemView;
		public AlarmSplitter splitter;
	}

}