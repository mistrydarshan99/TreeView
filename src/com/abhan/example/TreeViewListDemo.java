package com.abhan.example;

import java.util.HashSet;
import java.util.Set;
import android.app.Activity;
import android.os.Bundle;
import com.abhan.example.treeviews.InMemoryTreeStateManager;
import com.abhan.example.treeviews.TreeBuilder;
import com.abhan.example.treeviews.TreeStateManager;
import com.abhan.example.treeviews.TreeViewList;

public class TreeViewListDemo extends Activity {
	public static String Header[] = { "Level 1 - 1", "Level 1 - 2", "Level 1 - 3", "Level 1 - 4", "Level 1 - 5", "Level 1 - 6", "Level 1 - 7" };
    private final Set<Long> selected = new HashSet<Long>();
    private TreeViewList treeView;
    private static final int LEVEL_NUMBER = 4;
    private TreeStateManager<Long> manager = null;
    private TreeBuilder<Long> treeBuilder = null;
    private ThreeLevelAdapter threeLevelAdapter;
    private TwoLevelAdapter twoLevelAdapter;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treeviewlistdemo);
        manager = new InMemoryTreeStateManager<Long>();
        treeBuilder = new TreeBuilder<Long>(manager);
        treeView = (TreeViewList) findViewById(R.id.mainTreeView);
        treeView.setDivider(null);
//        bindTwoLevelData();
        bindThreeLevelData();
    }
    
    private void bindTwoLevelData() {
    	// Header
        treeBuilder.sequentiallyAddNextNode((long) 0, 0);
        treeBuilder.sequentiallyAddNextNode((long) 1, 0);
        treeBuilder.sequentiallyAddNextNode((long) 2, 0);
        treeBuilder.sequentiallyAddNextNode((long) 3, 0);
        treeBuilder.sequentiallyAddNextNode((long) 4, 0);
        treeBuilder.sequentiallyAddNextNode((long) 5, 0);
        treeBuilder.sequentiallyAddNextNode((long) 6, 0);

        // Group
        treeBuilder.addRelation((long) 1, (long) 11);
        treeBuilder.addRelation((long) 1, (long) 12);
        treeBuilder.addRelation((long) 2, (long) 21);
        treeBuilder.addRelation((long) 2, (long) 22);
        
        // Collapse All Header Here
        manager.collapseChildren((long) 0);
        manager.collapseChildren((long) 1);
        manager.collapseChildren((long) 2);
        manager.collapseChildren((long) 3);
        manager.collapseChildren((long) 4);
        manager.collapseChildren((long) 5);
        manager.collapseChildren((long) 6);
        
        twoLevelAdapter = new TwoLevelAdapter(this, selected, manager, LEVEL_NUMBER);
        treeView.setAdapter(twoLevelAdapter);
    }
    
    private void bindThreeLevelData() {
    	// Header
    	treeBuilder.sequentiallyAddNextNode((long) 0, 0);
        treeBuilder.sequentiallyAddNextNode((long) 1, 0);
        treeBuilder.sequentiallyAddNextNode((long) 2, 0);
        treeBuilder.sequentiallyAddNextNode((long) 3, 0);
        treeBuilder.sequentiallyAddNextNode((long) 4, 0);
        treeBuilder.sequentiallyAddNextNode((long) 5, 0);
        treeBuilder.sequentiallyAddNextNode((long) 6, 0);

        // Group
        treeBuilder.addRelation((long) 1, (long) 11);
        treeBuilder.addRelation((long) 1, (long) 12);
        treeBuilder.addRelation((long) 2, (long) 21);
        treeBuilder.addRelation((long) 2, (long) 22);
        
        // Child
        treeBuilder.addRelation((long) 11, (long) 31);
        treeBuilder.addRelation((long) 11, (long) 32);
        treeBuilder.addRelation((long) 11, (long) 33);
        treeBuilder.addRelation((long) 12, (long) 312);
        treeBuilder.addRelation((long) 21, (long) 321);
        treeBuilder.addRelation((long) 21, (long) 322);
        treeBuilder.addRelation((long) 22, (long) 331);
        
        // Collapse All Header Here
        manager.collapseChildren((long) 0);
        manager.collapseChildren((long) 1);
        manager.collapseChildren((long) 2);
        manager.collapseChildren((long) 3);
        manager.collapseChildren((long) 4);
        manager.collapseChildren((long) 5);
        manager.collapseChildren((long) 6);
        
        threeLevelAdapter = new ThreeLevelAdapter(this, selected, manager, LEVEL_NUMBER);
        treeView.setAdapter(threeLevelAdapter);
    }
}