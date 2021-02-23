import java.util.Map;

public class MyMap<K, V> {
    private HashEntry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 1 << 4;

    private int size = 0;

    public MyMap() {
        this(INITIAL_CAPACITY);
    }

    public MyMap(int capacity) {
        this.buckets = new HashEntry[capacity];
    }

    public void put(K key, V value) {
        HashEntry<K, V> entry = new HashEntry<>(key, value, null);
        int bucket = getHash(key) % getBucketSize();

        HashEntry<K, V> existing = buckets[bucket];
        if (existing == null) {
            buckets[bucket] = entry;
            size++;
        } else {
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }
            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = entry;
                size++;
            }
        }
    }

    public V get(K key) {
        HashEntry<K, V> bucket = buckets[getHash(key) % getBucketSize()];

        while (bucket != null) {
            if (bucket.key.equals(key)) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    private int getBucketSize() {
        return buckets.length;
    }

    public int size() {
        return size;
    }
}
