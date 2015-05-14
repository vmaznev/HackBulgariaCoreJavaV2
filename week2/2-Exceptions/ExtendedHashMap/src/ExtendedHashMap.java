import java.util.HashMap;

public class ExtendedHashMap<K, V> extends HashMap<K, V> {

    private static final long serialVersionUID = 1L;
    
    private boolean allowNullKeys;
    
    public ExtendedHashMap() {
        this.allowNullKeys = false;
    };
    
    public ExtendedHashMap(boolean allowNullKeys) {
        this.allowNullKeys = allowNullKeys;
    }

    @Override
    public V put(K key, V value) {
        if((this.allowNullKeys == false) && (key == null)) {
            throw new NullHashMapKeyException("Null Keys Not Allowed...!");
        }
        return super.put(key, value);
    }
    
    @Override
    public V get(Object key) {
        if((this.allowNullKeys == false) && (key == null)) {
            throw new NullHashMapKeyException("Null Keys Not Allowed...!");
        }
        return super.get(key);
    }   
    
}
