package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

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

    @Override
    public BigInteger getAsBigInteger() {
        return getAsBigDecimal().toBigInteger();
    }

    @Override
    public BigDecimal getAsBigDecimal() {
        return BigDecimal.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataDouble that = (DataDouble) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
