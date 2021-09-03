package com.glassera.stracker.activity.dashboard.ui.bankcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.glassera.stracker.R;
import com.glassera.stracker.service.dto.BankCardDto;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class BankCardListAdapter extends BaseExpandableListAdapter {

    private static final String TAG = "BankCardListAdapter";
    private Context context;
    private List<BankCardDto> bankCardInfo;

    public BankCardListAdapter(Context context, List<BankCardDto> bankCardInfo) {
        this.context = context;
        this.bankCardInfo = bankCardInfo;
    }

    @Override
    public int getGroupCount() {
        return bankCardInfo.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 7;
    }

    @Override
    public BankCardDto getGroup(int groupPosition) {
        return this.bankCardInfo.get(groupPosition);
    }

    @Override
    public Map.Entry<String, String> getChild(int groupPosition, int childPosition) {
        switch(childPosition) {
            case 0:
                return new AbstractMap.SimpleEntry<>("Bank Name", this.bankCardInfo.get(groupPosition).getName());
            case 1:
                return new AbstractMap.SimpleEntry<>("Card Type", this.bankCardInfo.get(groupPosition).getType());
            case 2:
                return new AbstractMap.SimpleEntry<>("Card No.", this.bankCardInfo.get(groupPosition).getCardNo());
            case 3:
                return new AbstractMap.SimpleEntry<>("CVV", this.bankCardInfo.get(groupPosition).getCvv());
            case 4:
                return new AbstractMap.SimpleEntry<>("Expiry Date", this.bankCardInfo.get(groupPosition).getExpiryDate());
            case 5:
                return new AbstractMap.SimpleEntry<>("Website", this.bankCardInfo.get(groupPosition).getContact());
            case 6:
                return new AbstractMap.SimpleEntry<>("Remarks", this.bankCardInfo.get(groupPosition).getNotes());
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
        BankCardDto bankCardDto = getGroup(groupPosition);
        String bankName = bankCardDto.getName() + " (" + bankCardDto.getType() + ")";
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
