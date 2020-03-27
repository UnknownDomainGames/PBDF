package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataInt128 implements DataNumber {
    private long mostSignificantBits;
    private long leastSignificantBits;

    public DataInt128() {
    }

    public DataInt128(long mostSignificantBits, long leastSignificantBits) {
        this.mostSignificantBits = mostSignificantBits;
        this.leastSignificantBits = leastSignificantBits;
    }

    @Override
    public DataType getType() {
        return DataType.INT128;
    }

    @Override
    public void write(DataOutput output) throws IOException {
        output.writeLong(mostSignificantBits);
        output.writeLong(leastSignificantBits);
    }

    @Override
    public void read(DataInput input) throws IOException {
        mostSignificantBits = input.readLong();
        leastSignificantBits = input.readLong();
    }

    @Override
    public DataElement deepClone() {
        return new DataInt128(mostSignificantBits, leastSignificantBits);
    }

    @Override
    public Number getAsNumber() {
        return null;
    }

    @Override
    public int getAsInt() {
        return 0;
    }

    @Override
    public long getAsLong() {
        return 0;
    }

    @Override
    public float getAsFloat() {
        return 0;
    }

    @Override
    public double getAsDouble() {
        return 0;
    }

    @Override
    public byte getAsByte() {
        return 0;
    }

    @Override
    public short getAsShort() {
        return 0;
    }
}
