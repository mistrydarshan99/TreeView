package com.abhan.example.treeviews;

public class TreeBuilder<T> {
    private final TreeStateManager<T> manager;

    private T lastAddedId = null;
    private int lastLevel = -1;

    public TreeBuilder(final TreeStateManager<T> manager) {
        this.manager = manager;
    }

    public void clear() {
        manager.clear();
        lastAddedId = null;
        lastLevel = -1;
    }

    public synchronized void addRelation(final T parent, final T child) {
        manager.addAfterChild(parent, child, null);
        lastAddedId = child;
        lastLevel = manager.getLevel(child);
    }

    public synchronized void sequentiallyAddNextNode(final T id, final int level) {
        if (lastAddedId == null) {
            addNodeToParentOneLevelDown(null, id, level);
        } else {
            if (level <= lastLevel) {
                final T parent = findParentAtLevel(lastAddedId, level - 1);
                addNodeToParentOneLevelDown(parent, id, level);
            } else {
                addNodeToParentOneLevelDown(lastAddedId, id, level);
            }
        }
    }

    private T findParentAtLevel(final T node, final int levelToFind) {
        T parent = manager.getParent(node);
        while (parent != null) {
            if (manager.getLevel(parent) == levelToFind) {
                break;
            }
            parent = manager.getParent(parent);
        }
        return parent;
    }

    private void addNodeToParentOneLevelDown(final T parent, final T id,
            final int level) {
        if (parent == null && level != 0) {
            throw new TreeConfigurationException("Trying to add new id " + id
                    + " to top level with level != 0 (" + level + ")");
        }
        if (parent != null && manager.getLevel(parent) != level - 1) {
            throw new TreeConfigurationException("Trying to add new id " + id
                    + " <" + level + "> to " + parent + " <"
                    + manager.getLevel(parent)
                    + ">. The difference in levels up is bigger than 1.");
        }
        manager.addAfterChild(parent, id, null);
        setLastAdded(id, level);
    }

    private void setLastAdded(final T id, final int level) {
        lastAddedId = id;
        lastLevel = level;
    }
}