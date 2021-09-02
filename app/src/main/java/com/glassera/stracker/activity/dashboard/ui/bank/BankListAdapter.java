package com.glassera.stracker.activity.dashboard.ui.bank;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.glassera.stracker.R;
import com.glassera.stracker.service.dto.BankDto;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankListAdapter extends BaseExpandableListAdapter {

    private static final String TAG = "BankListAdapter";
    private Context context;
    private List<BankDto> bankInfo;

    public BankListAdapter(Context context, List<BankDto> bankInfo) {
        this.context = context;
        this.bankInfo = bankInfo;
    }

    @Override
    public int getGroupCount() {
        return bankInfo.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 6;
    }

    @Override
    public BankDto getGroup(int groupPosition) {
        return this.bankInfo.get(groupPosition);
    }

    @Override
    public Map.Entry<String, String> getChild(int groupPosition, int childPosition) {
        switch(childPosition) {
            case 0:
                return new AbstractMap.SimpleEntry<>("Bank Name", this.bankInfo.get(groupPosition).getName());
            case 1:
                return new AbstractMap.SimpleEntry<>("Account Type", this.bankInfo.get(groupPosition).getType());
            case 2:
                return new AbstractMap.SimpleEntry<>("Account no.", this.bankInfo.get(groupPosition).getAccountNo());
            case 3:
                return new AbstractMap.SimpleEntry<>("Routing no.", this.bankInfo.get(groupPosition).getRoutingNo());
            case 4:
                return new AbstractMap.SimpleEntry<>("Nominee(s)", this.bankInfo.get(groupPosition).getNominee());
            case 5:
                return new AbstractMap.SimpleEntry<>("Remarks", this.bankInfo.get(groupPosition).getNotes());
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
        BankDto bankDto = getGroup(groupPosition);
        String bankName = bankDto.getName() + " (" + bankDto.getType() + ")";
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.row_item, null);
        }
        TextView listTitleTextView = convertView
                .findViewById(R.id.row_text);
        listTitleTextView.setText(bankName);
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
