package com.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Math.max;

public class TreeNode {
    private Integer data;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int data) {
        this.data = data;
    }

    public static TreeNode createTree(LinkedList<Integer> linkedList) {
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        Integer data = linkedList.removeFirst();
        if(data != null) {
            TreeNode node = new TreeNode(data);
            node.leftChild = createTree(linkedList);
            node.rightChild = createTree(linkedList);
            return node;
        }
        return null;
    }

    public static void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.data + ",");
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }
    public static void inOrder(TreeNode node){
        if(node == null) {
            return;
        }
        inOrder(node.leftChild);
        System.out.print(node.data + ",");
        inOrder(node.rightChild);
    }
    public static void postOrder(TreeNode node){
        if(node == null) {
            return;
        }
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.print(node.data + ",");
    }
    public static void preOrderWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()){
            while(treeNode!=null){
                System.out.print(treeNode.data+",");
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }
    public static void inOrderWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()){
            while(treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                System.out.print(treeNode.data+",");
                treeNode = treeNode.rightChild;
            }
        }
    }
    public static void postOrderWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        TreeNode lastNode = root;
        while (treeNode != null || !stack.isEmpty()){
            while(treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            treeNode = stack.peek();
            if(treeNode.rightChild==null || treeNode.rightChild==lastNode){
                treeNode = stack.pop();
                System.out.print(treeNode.data+",");
                lastNode = treeNode;
                treeNode = null;
            }
            else{
                treeNode = treeNode.rightChild;
            }
        }
    }
    public static void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.data + ",");
            if(node.leftChild!=null) {
                queue.offer(node.leftChild);
            }
            if(node.rightChild!=null) {
                queue.offer(node.rightChild);
            }
        }
    }
    // 层次遍历递归 (有问题)
    private static void levelOrderWithRecursionHelper(TreeNode treeNode, int depth){
        if(treeNode == null || depth == 0){
            return;
        }
        if (depth==1) {
            System.out.print(treeNode.data + ",");
        }
        levelOrderWithRecursionHelper(treeNode.leftChild, depth-1);
        levelOrderWithRecursionHelper(treeNode.rightChild, depth-1);
    }
    public static void levelOrderWithRecursion(TreeNode root){
        if (root==null){
            return;
        }
        int depth = getTreeDepth(root);
        System.out.println(depth);
        levelOrderWithRecursionHelper(root, depth);
    }

    public static int getTreeDepth(TreeNode root){
        if (root==null) {
            return 0;
        }
        return 1 + max(getTreeDepth(root.leftChild), getTreeDepth(root.rightChild));
    }
}
