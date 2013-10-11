package com.abhan.example;

import java.util.Set;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.abhan.example.treeviews.AbstractTreeViewAdapter;
import com.abhan.example.treeviews.TreeNodeInfo;
import com.abhan.example.treeviews.TreeStateManager;

class TwoLevelAdapter extends AbstractTreeViewAdapter<Long> {
	
	private static final String TAG = "TwoLevelAdapter";

    public TwoLevelAdapter(final TreeViewListDemo treeViewListDemo,
            final Set<Long> selected,
            final TreeStateManager<Long> treeStateManager,
            final int numberOfLevels) {
        super(treeViewListDemo, treeStateManager, numberOfLevels);
    }

    @Override
    public View getNewChildView(final TreeNodeInfo<Long> treeNodeInfo) {
        int level = treeNodeInfo.getLevel();
        LinearLayout viewLayout;
        if (level == 0) {
            viewLayout = (LinearLayout) getActivity().getLayoutInflater()
                    .inflate(R.layout.header, null);
            return updateView(viewLayout, treeNodeInfo);
        } else if (level == 1) {
            viewLayout = (LinearLayout) getActivity().getLayoutInflater()
                    .inflate(R.layout.groups, null);
            return updateView(viewLayout, treeNodeInfo);
        } else {
            viewLayout = (LinearLayout) getActivity().getLayoutInflater()
                    .inflate(R.layout.groups, null);
            return updateView(viewLayout, treeNodeInfo);
        }
    }

    @Override
    public LinearLayout updateView(final View view,
            final TreeNodeInfo<Long> treeNodeInfo) {

        int level = treeNodeInfo.getLevel();
        final LinearLayout viewLayout = (LinearLayout) view;
        if (level == 0) {
        	// Header
            final TextView txtHeaderTitle = (TextView) viewLayout
                    .findViewById(R.id.headerTitle);
            final TextView txtHeaderCount = (TextView) viewLayout
                    .findViewById(R.id.headerCount);
            long id = treeNodeInfo.getId();
            txtHeaderTitle.setText(TreeViewListDemo.Header[(int) id]);
            txtHeaderCount.setText(String.valueOf(id));
        } else {
        	// Group
            final TextView txtGroupTitle = (TextView) viewLayout
                    .findViewById(R.id.groupTitle);
            final TextView txtGroupCount = (TextView) viewLayout
                    .findViewById(R.id.groupCount);
            long id = treeNodeInfo.getId();
            txtGroupTitle.setText("Level " + id);
            txtGroupCount.setText(String.valueOf(id));
        }
        return viewLayout;
    }

    @Override
    public void handleItemClick(final View view, final Object id) {
        final Long longId = (Long) id;
        Log.d(TAG, "ClickedId: " + longId);
        final TreeNodeInfo<Long> info = getManager().getNodeInfo(longId);
        if (info.isWithChildren())
            super.handleItemClick(view, id);
    }

    @Override
    public long getItemId(final int position) {
        return getTreeId(position);
    }
}