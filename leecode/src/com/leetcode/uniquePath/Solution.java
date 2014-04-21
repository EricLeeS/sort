package com.leetcode.uniquePath;

import java.util.Stack;

public class Solution {

	public int uniquePaths(int m, int n) {

		row = m;

		col = n;

		if (m == 1 || n == 1) {

			System.out.println(1);

			return 1;

		} else {

			PreOrder(m, n);

			return count;

		}

	}

	public int row = 0;

	public int col = 0;

	public int count = 0;

	private void PreOrder(int row, int col) {

		// TODO Auto-generated method stub

		Stack<TreeNode> stack = new Stack<TreeNode>();

		int[] val = { 1, 1 };

		TreeNode root = new TreeNode(val);

		while (!stack.isEmpty() || isNull(root)) {

			if (isNull(root)) {

				stack.push(root);

				int first = root.val[0];

				int second = root.val[1];

				int firstleft = first + 1;

				int secondright = second + 1;

				if (firstleft == row && second == col) {

					count++;

				}

				if (first == row && secondright == col) {

					count++;

				}

				int[] lefttemp = { firstleft, second };

				int[] righttemp = { first, secondright };

				TreeNode left = new TreeNode(lefttemp);

				TreeNode right = new TreeNode(righttemp);

				root.left = left;

				root.right = right;

				root = root.left;

			} else {

				TreeNode node = stack.peek();

				root = node.right;

				stack.pop();

			}

		}

	}

	public boolean isNull(TreeNode node) {

		if (node.val[0] > row || node.val[1] > col) {

			return false;

		} else {

			return true;

		}

	}

	public class TreeNode {

		private TreeNode left;

		private TreeNode right;

		private int[] val;

		public TreeNode(int[] val) {

			this.val = val;

		}

	}

}