import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HashEntry<K, V> {
    final K key;
    V value;
    HashEntry<K, V> next;
}
