class MyMap<K, V> {
    private HashEntry[] buckets;
    private static final int INITIAL_CAPACITY = 1 << 4;

    private int size = 0;

    MyMap() {
        this(INITIAL_CAPACITY);
    }

    private MyMap(int capacity) {
        this.buckets = new HashEntry[capacity];
    }

    void put(K key, V value) {
        HashEntry<K, V> entry = new HashEntry<>(key, value, null);
        int bucket = getHash(key) % getBucketSize();

        HashEntry existing = buckets[bucket];
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

    V get(K key) {
        HashEntry bucket = buckets[getHash(key) % getBucketSize()];

        while (bucket != null) {
            if (bucket.key.equals(key)) {
                return (V) bucket.value;
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

    int size() {
        return size;
    }
}
