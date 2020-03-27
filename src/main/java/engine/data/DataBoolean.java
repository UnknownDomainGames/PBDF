package engine.data;

import java.io.DataInput;
import java.io.DataOutput;

public class DataBoolean implements DataElement {
    @Override
    public DataType getType() {
        return DataType.BOOLEAN;
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
