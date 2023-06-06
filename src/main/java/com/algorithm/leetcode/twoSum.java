package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Stream;

public class twoSum {

    public static void main(String args[]) {
        LinkedList<Integer> linkedList = new LinkedList<>(Stream.of(3,2,9,null,null,10,null,null,8,null,4).toList());
        System.out.println(linkedList);
        TreeNode treeNode = TreeNode.createTree(linkedList);

        TreeNode.preOrder(treeNode);
        System.out.println();
        TreeNode.inOrder(treeNode);
        System.out.println();
        TreeNode.postOrder(treeNode);
        System.out.println();
        //TreeNode.preOrderWithStack(treeNode);
        //System.out.println();


        //TreeNode.inOrderWithStack(treeNode);
        //System.out.println();
        TreeNode.postOrderWithStack(treeNode);
        System.out.println();
        TreeNode.levelOrder(treeNode);
        System.out.println();
        TreeNode.levelOrderWithRecursion(treeNode);
    }
}




