package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataByteArray implements DataElement {
    @Override
    public DataType getType() {
        return DataType.BYTE_ARRAY;
    }

    @Override
    public void write(DataOutput output) throws IOException {

    }

    @Override
    public void read(DataInput input) throws IOException {

    }

    @Override
    public DataElement deepClone() {
        return null;
    }
}
