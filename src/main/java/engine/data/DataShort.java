package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataShort implements DataNumber {
    private short value;

    public DataShort() {
    }

    public DataShort(short value) {
        this.value = value;
    }

    @Override
    public DataType getType() {
        return DataType.SHORT;
    }


    @Override
    public void write(DataOutput output) throws IOException {
        output.writeShort(value);
    }

    @Override
    public void read(DataInput input) throws IOException {
        value = input.readShort();
    }

    @Override
    public DataElement deepClone() {
        return new DataShort(value);
    }

    @Override
    public Number getAsNumber() {
        return value;
    }

    @Override
    public int getAsInt() {
        return value;
    }

    @Override
    public long getAsLong() {
        return value;
    }

    @Override
    public float getAsFloat() {
        return value;
    }

    @Override
    public double getAsDouble() {
        return value;
    }

    @Override
    public byte getAsByte() {
        return (byte) value;
    }

    @Override
    public short getAsShort() {
        return value;
    }
}
