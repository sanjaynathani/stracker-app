package com.glassera.stracker.activity.dashboard.ui.liability;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.glassera.stracker.R;
import com.glassera.stracker.service.dto.LiabilityDto;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class LiabilityListAdapter extends BaseExpandableListAdapter {

    private static final String TAG = "LiabilityListAdapter";
    private Context context;
    private List<LiabilityDto> liabilityInfo;

    public LiabilityListAdapter(Context context, List<LiabilityDto> liabilityInfo) {
        this.context = context;
        this.liabilityInfo = liabilityInfo;
    }

    @Override
    public int getGroupCount() {
        return liabilityInfo.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 5;
    }

    @Override
    public LiabilityDto getGroup(int groupPosition) {
        return this.liabilityInfo.get(groupPosition);
    }

    @Override
    public Map.Entry<String, String> getChild(int groupPosition, int childPosition) {
        switch(childPosition) {
            case 0:
                return new AbstractMap.SimpleEntry<>("Organization Name", this.liabilityInfo.get(groupPosition).getName());
            case 1:
                return new AbstractMap.SimpleEntry<>("Liability Type", this.liabilityInfo.get(groupPosition).getType());
            case 2:
                return new AbstractMap.SimpleEntry<>("Account No.", this.liabilityInfo.get(groupPosition).getAccount());
            case 3:
                return new AbstractMap.SimpleEntry<>("Website", this.liabilityInfo.get(groupPosition).getContact());
            case 4:
                return new AbstractMap.SimpleEntry<>("Remarks", this.liabilityInfo.get(groupPosition).getNotes());
        }
        return null;
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

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LiabilityDto liabilityDto = getGroup(groupPosition);
        String orgName = liabilityDto.getName() + " (" + liabilityDto.getType() + ")";
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.row_item, null);
        }
        TextView listTitleTextView = convertView
                .findViewById(R.id.row_text);
        listTitleTextView.setText(orgName);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final Map.Entry<String, String> expandedListText = getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.row_detail, null);
        }
        TextView detailLabel = convertView
                .findViewById(R.id.detail_label);
        TextView detailValue = convertView
                .findViewById(R.id.detail_value);
        detailLabel.setText(expandedListText.getKey() + ": ");
        detailValue.setText(expandedListText.getValue());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
