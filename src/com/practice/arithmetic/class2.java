package com.practice.arithmetic;

import org.w3c.dom.Node;

/**
 * @author ZhiDong
 * <p>
 * 2020/12/23
 */
public class class2 {
    /**
     * 单项链表
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    /**
     * 双端链表
     */
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    /**
     * 翻转链表
     * a -> b -> null
     * a -> null
     * b  a -> null
     * <p>
     * null <- a <- b
     * 整体思路就是 遍历链表 把当前节点的next指针指向前一个节点
     *
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            // a -> b -> null
            // a -> null
            // pre
            // head ->  head.next
            // head.next -> head
            // 吧下一个节点的信息存起来
            next = head.next;
//            下一个节点 指向前一个指针
            head.next = pre;
            pre = head;
            head = next;
            //********************
            next = head.next;
            pre = head;
            next = next;
            head.next = pre;
        }
        return pre;
    }

    /**
     * null <- -> a -> <- b <- -> null
     *
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
