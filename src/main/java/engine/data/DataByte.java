package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class DataByte implements DataNumber {
    private byte value;

    public DataByte() {
    }

    public DataByte(byte value) {
        this.value = value;
    }

    @Override
    public DataType getType() {
        return DataType.BYTE;
    }

    @Override
    public DataElement deepClone() {
        return new DataByte(value);
    }

    @Override
    public void write(DataOutput output) throws IOException {
        output.write(value);
    }

    @Override
    public void read(DataInput input) throws IOException {
        value = input.readByte();
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
        return value;
    }

    @Override
    public short getAsShort() {
        return value;
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
        DataByte dataByte = (DataByte) o;
        return value == dataByte.value;
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
