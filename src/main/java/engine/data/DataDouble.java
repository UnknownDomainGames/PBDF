package engine.data;

import java.io.DataInput;
import java.io.DataOutput;

public class DataDouble implements DataNumber {
    @Override
    public DataType getType() {
        return DataType.DOUBLE;
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
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    @Override
    public byte byteValue() {
        return 0;
    }

    @Override
    public short shortValue() {
        return 0;
    }
}
