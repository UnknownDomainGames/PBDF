package nullengine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.AbstractList;
import java.util.List;

public class DataList extends AbstractList<DataElement> implements DataElement, List<DataElement> {
    @Override
    public DataType getType() {
        return DataType.LIST;
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

    @Override
    public DataElement get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
