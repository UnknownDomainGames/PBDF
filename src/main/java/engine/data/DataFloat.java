package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataFloat implements DataNumber {
    private float value;

    public DataFloat() {
    }

    public DataFloat(float value) {
        this.value = value;
    }

    @Override
    public DataType getType() {
        return DataType.FLOAT;
    }

    @Override
    public void write(DataOutput output) throws IOException {
        output.writeFloat(value);
    }

    @Override
    public void read(DataInput input) throws IOException {
        value = input.readFloat();
    }

    @Override
    public DataElement deepClone() {
        return new DataFloat(value);
    }

    @Override
    public Number getAsNumber() {
        return value;
    }

    @Override
    public int getAsInt() {
        return (int) value;
    }

    @Override
    public long getAsLong() {
        return (long) value;
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
        return (short) value;
    }
}
