package com.wxl.configserver;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

public class GetTreeByPreOrderAndInOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        readTree(getTree(pre, in));
    }


    public static void readTree(TreeNode treeNode) {
        if(treeNode!=null){
            if (treeNode.left != null) {
                readTree(treeNode.left);
            }
            if (treeNode.right != null) {
                readTree(treeNode.right);
            }
            System.out.print(treeNode.val);
        }
    }


    public static TreeNode getTree(int[] pre, int[] in) {
        // 递归结束后返回空节点
        if (pre.length == 0 || in.length == 0)
            return null;
        // 得到根节点值
        int rootValue = pre[0];
        int root = -1;
        // 记录根节点下标
        for (int i = 0; i < in.length; i++) {
            if (rootValue == in[i]) {
                root = i;
                break;
            }
        }
        // 如果根节点不在此段 则说明跳出
        if (root == -1) {
            return null;
        }
        // 得到左前序数组
        int[] leftPre = new int[root];
        for (int i = 1, j = 0; i < root + 1; j++, i++) {
            leftPre[j] = pre[i];
        }
        // 得到右前序数组
        int[] rightPre = new int[pre.length-root-1];
        for (int i = root + 1, j = 0; i < pre.length; j++, i++) {
            rightPre[j] = pre[i];
        }
        // 得到左边
        int[] left = new int[root];
        for (int i = 0; i < left.length; i++) {
            left[i] = in[i];
        }
        // 得到右边
        int[] right = new int[in.length - root - 1];
        for (int i = root + 1, j = 0; i < in.length; i++, j++) {
            right[j] = in[i];
        }

        // 递归左边
        TreeNode leftNode = getTree(leftPre, left);
        // 递归右边
        TreeNode rightNode =  getTree(rightPre, right);

        // 记录根节点值，插入树
        TreeNode rootNode = new TreeNode(rootValue);
        rootNode.left = leftNode;
        rootNode.right = rightNode;

        return rootNode;
    }

}
