package com.botany.mint.exercice;

import java.util.Map;
import java.util.Objects;

/**
 * @author wangzh
 */
public class HashMap<K, V> {

    final float loadFactor;

    public HashMap(float loadFactor) {
        this.loadFactor = loadFactor;
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash; // ?
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public final int hashCode() {return Objects.hashCode(key) ^ Objects.hashCode(value); }

        @Override
        public final K getKey() {
            return key;
        }

        @Override
        public final V getValue() {
            return value;
        }

        @Override
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public final boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue())) {
                    return true;
                }
            }
            return false;
        }
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          this.val = x;
      }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1, c2 = l2, sentinel = new ListNode(0), d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1) {
            d.next = new ListNode(1);
        }
        return sentinel.next;
    }
}
