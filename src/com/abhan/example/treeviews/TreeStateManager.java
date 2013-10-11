package com.abhan.example.treeviews;

import java.io.Serializable;
import java.util.List;
import android.database.DataSetObserver;

public interface TreeStateManager<T> extends Serializable {
	
	Integer[] getHierarchyDescription(T id);
	
	int getLevel(T id);
	
	TreeNodeInfo<T> getNodeInfo(T id);
	
	List<T> getChildren(T id);
	
	T getParent(T id);
	
	void addBeforeChild(T parent, T newChild, T beforeChild);
	
	void addAfterChild(T parent, T newChild, T afterChild);
	
	void removeNodeRecursively(T id);
	
	void expandDirectChildren(T id);
	
	void expandEverythingBelow(T id);
	
	void collapseChildren(T id);
	
	T getNextSibling(T id);
	
	T getPreviousSibling(T id);
	
	boolean isInTree(T id);
	
	int getVisibleCount();
	
	List<T> getVisibleList();
	
	void registerDataSetObserver(final DataSetObserver observer);
	
	void unregisterDataSetObserver(final DataSetObserver observer);
	
	void clear();
	
	void refresh();
}