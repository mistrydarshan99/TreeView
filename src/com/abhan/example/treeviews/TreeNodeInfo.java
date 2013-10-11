package com.abhan.example.treeviews;

public class TreeNodeInfo<T> {
    private final T id;
    private final int level;
    private final boolean withChildren;
    private final boolean visible;
    private final boolean expanded;

    public TreeNodeInfo(final T id, final int level,
            final boolean withChildren, final boolean visible,
            final boolean expanded) {
        super();
        this.id = id;
        this.level = level;
        this.withChildren = withChildren;
        this.visible = visible;
        this.expanded = expanded;
    }

    public T getId() {
        return id;
    }

    public boolean isWithChildren() {
        return withChildren;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "TreeNodeInfo [id=" + id + ", level=" + level
                + ", withChildren=" + withChildren + ", visible=" + visible
                + ", expanded=" + expanded + "]";
    }
}