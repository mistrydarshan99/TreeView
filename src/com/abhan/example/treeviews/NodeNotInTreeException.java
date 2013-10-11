package com.abhan.example.treeviews;

public class NodeNotInTreeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NodeNotInTreeException(final String id) {
        super("The tree does not contain the node specified: " + id);
    }
}