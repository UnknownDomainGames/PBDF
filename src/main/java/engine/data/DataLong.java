package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class DataLong implements DataNumber {
    private long value;

    public DataLong() {
    }

    public DataLong(long value) {
        this.value = value;
    }

    @Override
    public DataType getType() {
        return DataType.LONG;
    }

    @Override
    public void write(DataOutput output) throws IOException {
        output.writeLong(value);
    }

    @Override
    public void read(DataInput input) throws IOException {
        value = input.readLong();
    }

    @Override
    public DataElement deepClone() {
        return new DataLong(value);
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
        return (short) value;
    }

    @Override
    public BigInteger getAsBigInteger() {
        return BigInteger.valueOf(value);
    }

    @Override
    public BigDecimal getAsBigDecimal() {
        return BigDecimal.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataLong dataLong = (DataLong) o;
        return value == dataLong.value;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
