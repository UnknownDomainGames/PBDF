package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
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

    public DataElement put(String key, boolean value) {
        return put(key, new DataBoolean(value));
    }

    public DataElement put(String key, String value) {
        return put(key, new DataString(value));
    }

    public DataElement put(String key, int value) {
        return put(key, new DataInt(value));
    }

    public DataElement put(String key, long value) {
        return put(key, new DataLong(value));
    }

    public DataElement put(String key, float value) {
        return put(key, new DataFloat(value));
    }

    public DataElement put(String key, double value) {
        return put(key, new DataDouble(value));
    }

    public DataElement put(String key, byte value) {
        return put(key, new DataByte(value));
    }

    public DataElement put(String key, short value) {
        return put(key, new DataShort(value));
    }

    public DataElement put(String key, UUID value) {
        return put(key, new DataInt128(value));
    }

    public DataElement put(String key, byte[] value) {
        return put(key, new DataByteArray(value));
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
    public void write(DataOutput output) throws IOException {
        for (Entry<String, DataElement> entry : entrySet()) {
            String key = entry.getKey();
            DataElement value = entry.getValue();
            output.writeByte(value.getType().getId());
            output.writeUTF(key);
            value.write(output);
        }
        output.writeByte(DataType.END.getId());
    }

    @Override
    public void read(DataInput input) throws IOException {
        DataType type;
        while ((type = DataType.valueOf(input.readByte())) != DataType.END) {
            String key = input.readUTF();
            DataElement value = type.create();
            value.read(input);
            put(key, value);
        }
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
        return backingMap.hashCode();
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
