package com.example.assignmentlistview;

import android.annotation.SuppressLint;
import android.widget.BaseExpandableListAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String> groupData;
    HashMap<String, List<String>> childData;
    public ExpandableListAdapter(Context context, List<String> groupData, HashMap<String, List<String>> childData) {
        this.context = context;
        this.groupData = groupData;
        this.childData = childData;
    }
    @Override
    public int getGroupCount() {
        return groupData.size();
    }
    @Override
    public int getChildrenCount(int groupPosition) {
        return Objects.requireNonNull(childData.get(groupData.get(groupPosition))).size();
    }
    @Override
    public Object getGroup(int groupPosition) {
        return groupData.get(groupPosition);
    }
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return Objects.requireNonNull(childData.get(groupData.get(groupPosition))).get(childPosition);
    }
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }
    @SuppressLint("InflateParams")
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerText = (String) getGroup(groupPosition);
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.group_layout, null);
        }
        TextView textView = convertView.findViewById(R.id.groupText);
        textView.setText(headerText);
        return convertView;
    }
    @SuppressLint("InflateParams")
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childText = (String) getChild(groupPosition, childPosition);
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_layout, null);
        }
        TextView textView = convertView.findViewById(R.id.childText);
        textView.setText(childText);
        return convertView;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }



}
