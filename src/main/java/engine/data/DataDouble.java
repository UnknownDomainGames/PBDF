package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataDouble implements DataNumber {
    private double value;

    public DataDouble() {
    }

    public DataDouble(double value) {
        this.value = value;
    }

    @Override
    public DataType getType() {
        return DataType.DOUBLE;
    }

    @Override
    public void write(DataOutput output) throws IOException {
        output.writeDouble(value);
    }

    @Override
    public void read(DataInput input) throws IOException {
        value = input.readDouble();
    }

    @Override
    public DataElement deepClone() {
        return new DataDouble(value);
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
        return (float) value;
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
