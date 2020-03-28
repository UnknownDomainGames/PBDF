package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

public class DataInt128 implements DataNumber {
    private long mostSignificantBits;
    private long leastSignificantBits;

    public DataInt128() {
    }

    public DataInt128(UUID uuid) {
        this(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
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
    public Number getAsNumber() {
        return getAsBigInteger();
    }

    @Override
    public int getAsInt() {
        return (int) leastSignificantBits;
    }

    @Override
    public long getAsLong() {
        return leastSignificantBits;
    }

    @Override
    public float getAsFloat() {
        return leastSignificantBits;
    }

    @Override
    public double getAsDouble() {
        return leastSignificantBits;
    }

    @Override
    public byte getAsByte() {
        return (byte) leastSignificantBits;
    }

    @Override
    public short getAsShort() {
        return (short) leastSignificantBits;
    }

    @Override
    public BigInteger getAsBigInteger() {
        BigInteger unsignedLeastSigBits = leastSignificantBits >= 0 ?
                BigInteger.valueOf(leastSignificantBits) :
                BigInteger.valueOf(leastSignificantBits & Long.MAX_VALUE).setBit(64);
        return BigInteger.valueOf(mostSignificantBits).shiftLeft(64).add(unsignedLeastSigBits);
    }

    @Override
    public BigDecimal getAsBigDecimal() {
        return new BigDecimal(getAsBigInteger());
    }

    @Override
    public UUID getAsUUID() {
        return new UUID(mostSignificantBits, leastSignificantBits);
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
}
