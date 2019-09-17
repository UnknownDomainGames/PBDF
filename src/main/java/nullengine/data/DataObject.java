package nullengine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DataObject implements Map<String, DataElement>, DataElement {

    private final Map<String, DataElement> backingMap = new HashMap<>();

    @Override
    public int size() {
        return backingMap.size();
    }

    @Override
    public boolean isEmpty() {
        return backingMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return backingMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return backingMap.containsValue(value);
    }

    @Override
    public DataElement get(Object key) {
        return backingMap.get(key);
    }

    @Override
    public DataElement put(String key, DataElement value) {
        return backingMap.put(key, value);
    }

    @Override
    public DataElement remove(Object key) {
        return backingMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends DataElement> m) {
        backingMap.putAll(m);
    }

    @Override
    public void clear() {
        backingMap.clear();
    }

    @Override
    public Set<String> keySet() {
        return backingMap.keySet();
    }

    @Override
    public Collection<DataElement> values() {
        return backingMap.values();
    }

    @Override
    public Set<Entry<String, DataElement>> entrySet() {
        return backingMap.entrySet();
    }

    @Override
    public DataType getType() {
        return DataType.OBJECT;
    }

    @Override
    public DataElement deepClone() {
        return null;
    }

    @Override
    public void write(DataOutput output) {

    }

    @Override
    public void read(DataInput input) {

    }
}
