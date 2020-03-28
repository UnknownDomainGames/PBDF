package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.*;

public class DataObject implements Map<String, DataElement>, DataElement {

    private final Map<String, DataElement> backingMap = new HashMap<>();

    public DataObject() {
    }

    public DataObject(Map<String, DataElement> map) {
        backingMap.putAll(map);
    }

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
    public boolean isObject() {
        return true;
    }

    @Override
    public DataObject getAsDataObject() {
        return this;
    }

    @Override
    public void write(DataOutput output) {

    }

    @Override
    public void read(DataInput input) {

    }

    @Override
    public DataElement deepClone() {
        DataObject dataObject = new DataObject();
        forEach((key, value) -> dataObject.put(key, value.deepClone()));
        return dataObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataObject that = (DataObject) o;
        return backingMap.equals(that.backingMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(backingMap);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        for (Entry<String, DataElement> entry : entrySet()) {
            builder.append("\"").append(entry.getKey()).append("\": ").append(entry.getValue()).append(", ");
        }
        if (!isEmpty()) {
            builder.delete(builder.length() - 2, builder.length());
        }
        return builder.append("}").toString();
    }
}