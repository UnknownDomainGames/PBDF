package nullengine.data;

import java.io.DataInput;
import java.io.DataOutput;

public class DataString implements DataElement {
    @Override
    public DataType getType() {
        return DataType.STRING;
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
