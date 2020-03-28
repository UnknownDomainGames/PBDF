package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class DataInt implements DataNumber {
    private int value;

    public DataInt() {
    }

    public DataInt(int value) {
        this.value = value;
    }

    @Override
    public DataType getType() {
        return DataType.INT;
    }

    @Override
    public void write(DataOutput output) throws IOException {
        output.writeInt(value);
    }

    @Override
    public void read(DataInput input) throws IOException {
        value = input.readInt();
    }

    @Override
    public DataElement deepClone() {
        return new DataInt();
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
        DataInt dataInt = (DataInt) o;
        return value == dataInt.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
