package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

public class DataList extends AbstractList<DataElement> implements DataElement, List<DataElement>, RandomAccess {
    private final List<DataElement> backingList = new ArrayList<>();

    public DataList() {
    }

    public DataList(List<DataElement> list) {
        backingList.addAll(list);
    }

    @Override
    public DataElement get(int index) {
        return backingList.get(index);
    }

    @Override
    public DataElement set(int index, DataElement element) {
        return backingList.set(index, element);
    }

    @Override
    public void add(int index, DataElement element) {
        backingList.add(index, element);
    }

    @Override
    public DataElement remove(int index) {
        return backingList.remove(index);
    }

    @Override
    public int size() {
        return backingList.size();
    }

    @Override
    public DataType getType() {
        return DataType.LIST;
    }

    @Override
    public boolean isList() {
        return true;
    }

    @Override
    public DataList getAsDataList() {
        return this;
    }

    @Override
    public void write(DataOutput output) throws IOException {
        for (DataElement element : this) {
            output.writeByte(element.getType().getId());
            element.write(output);
        }
        output.writeByte(DataType.END.getId());
    }

    @Override
    public void read(DataInput input) throws IOException {
        DataType type;
        while ((type = DataType.valueOf(input.readByte())) != DataType.END) {
            DataElement element = type.create();
            element.read(input);
            add(element);
        }
    }

    @Override
    public DataElement deepClone() {
        DataList dataList = new DataList();
        forEach(dataElement -> dataList.add(dataElement.deepClone()));
        return dataList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DataList that = (DataList) o;
        return backingList.equals(that.backingList);
    }

    @Override
    public int hashCode() {
        return backingList.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (DataElement element : this) {
            builder.append(element).append(", ");
        }
        if (!isEmpty()) {
            builder.delete(builder.length() - 2, builder.length());
        }
        return builder.append("]").toString();
    }
}
