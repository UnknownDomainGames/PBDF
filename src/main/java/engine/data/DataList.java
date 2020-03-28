package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
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
    public void write(DataOutput output) {

    }

    @Override
    public void read(DataInput input) {

    }

    @Override
    public DataElement deepClone() {
        DataList dataList = new DataList();
        forEach(dataElement -> dataList.add(dataElement.deepClone()));
        return dataList;
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
