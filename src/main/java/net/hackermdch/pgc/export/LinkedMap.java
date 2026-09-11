package net.hackermdch.pgc.export;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class LinkedMap<K, V> implements Map<K, V> {
    private final LinkedNode nodeFirst = new LinkedNode(null, null);
    private final LinkedNode nodeEnd = new LinkedNode(null, null);

    {
        nodeFirst.prev = nodeFirst.next = nodeEnd;
        nodeEnd.prev = nodeEnd.next = nodeFirst;
    }

    private class LinkedNode {
        K key;
        V value;
        LinkedNode next, prev;

        LinkedNode(K k, V v) {
            key = k;
            value = v;
        }
    }

    public class Iterator {
        private LinkedNode node = nodeFirst;

        public boolean hasNext() {
            return node.next != nodeEnd;
        }

        public Entry<K, V> next() {
            return new LinkedEntry(node = node.next);
        }

        public void insert(K key, V value) {
            var n = new LinkedNode(key, value);
            n.next = node;
            n.prev = node.prev;
            node.prev.next = n;
            node.prev = n;
        }
    }

    private class LinkedEntry implements Entry<K, V> {
        final LinkedNode node;

        LinkedEntry(LinkedNode node) {
            this.node = node;
        }

        @Override
        public K getKey() {
            return node.key;
        }

        @Override
        public V getValue() {
            return node.value;
        }

        @Override
        public V setValue(V value) {
            var old = node.value;
            node.value = value;
            return old;
        }
    }

    public Iterator iterator() {
        return new Iterator();
    }

    @Override
    public int size() {
        var count = 0;
        var node = nodeFirst;
        while (node.next != nodeEnd) {
            node = node.next;
            count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        var node = nodeFirst;
        while (node.next != nodeEnd) {
            node = node.next;
            if (node.key.equals(key)) return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        var node = nodeFirst;
        while (node.next != nodeEnd) {
            node = node.next;
            if (node.value.equals(value)) return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        var node = nodeFirst;
        while (node.next != nodeEnd) {
            node = node.next;
            if (node.key.equals(key)) return node.value;
        }
        return null;
    }

    @Override
    public @Nullable V put(K key, V value) {
        if (nodeFirst.next == nodeEnd) {
            nodeEnd.prev = new LinkedNode(key, value);
            nodeEnd.prev.prev = nodeFirst;
            nodeEnd.prev.next = nodeEnd;
            nodeFirst.next = nodeEnd.prev;
        } else {
            var node = nodeFirst;
            while (node.next != nodeEnd) {
                node = node.next;
                if (node.key.equals(key)) {
                    var old = node.value;
                    node.value = value;
                    return old;
                }
            }
            var n = new LinkedNode(key, value);
            n.prev = nodeEnd.prev;
            n.next = nodeEnd;
            nodeEnd.prev = nodeEnd.prev.next = n;
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        var node = nodeFirst;
        while (node.next != nodeEnd) {
            node = node.next;
            if (node.key.equals(key)) {
                var value = node.value;
                node.prev.next = node.next;
                node.prev = node.next = null;
                return value;
            }
        }
        return null;
    }

    @Override
    public void putAll(@NotNull Map<? extends K, ? extends V> m) {
        m.forEach(this::put);
    }

    @Override
    public void clear() {
        nodeFirst.prev = nodeFirst.next = nodeEnd;
        nodeEnd.prev = nodeEnd.next = nodeFirst;
    }

    @Override
    public @NotNull Set<K> keySet() {
        var builder = ImmutableSet.<K>builder();
        var node = nodeFirst;
        while (node.next != nodeEnd) {
            node = node.next;
            builder.add(node.key);
        }
        return builder.build();
    }

    @Override
    public @NotNull Collection<V> values() {
        var builder = ImmutableList.<V>builder();
        var node = nodeFirst;
        while (node.next != nodeEnd) {
            node = node.next;
            builder.add(node.value);
        }
        return builder.build();
    }

    @Override
    public @NotNull Set<Entry<K, V>> entrySet() {
        var builder = ImmutableSet.<Entry<K, V>>builder();
        var node = nodeFirst;
        while (node.next != nodeEnd) {
            node = node.next;
            builder.add(new LinkedEntry(node));
        }
        return builder.build();
    }
}
