package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

public interface DataElement {

    DataType getType();

    void write(DataOutput output) throws IOException;

    void read(DataInput input) throws IOException;

    DataElement deepClone();

    default boolean is(DataType type) {
        return getType() == type;
    }

    default boolean isObject() {
        return false;
    }

    default boolean isList() {
        return false;
    }

    default boolean isString() {
        return false;
    }

    default boolean isBoolean() {
        return false;
    }

    default boolean isNumber() {
        return false;
    }

    default DataObject getAsDataObject() {
        throw new UnsupportedOperationException("object");
    }

    default DataList getAsDataList() {
        throw new UnsupportedOperationException("list");
    }

    default String getAsString() {
        throw new UnsupportedOperationException("string");
    }

    default boolean getAsBoolean() {
        throw new UnsupportedOperationException("boolean");
    }

    default DataNumber getAsDataNumber() {
        throw new UnsupportedOperationException("number");
    }

    default Number getAsNumber() {
        throw new UnsupportedOperationException("number");
    }

    default int getAsInt() {
        throw new UnsupportedOperationException("int");
    }

    default long getAsLong() {
        throw new UnsupportedOperationException("long");
    }

    default float getAsFloat() {
        throw new UnsupportedOperationException("float");
    }

    default double getAsDouble() {
        throw new UnsupportedOperationException("double");
    }

    default byte getAsByte() {
        throw new UnsupportedOperationException("byte");
    }

    default short getAsShort() {
        throw new UnsupportedOperationException("short");
    }

    default BigInteger getAsBigInteger() {
        throw new UnsupportedOperationException("bigInteger");
    }

    default UUID getAsUUID() {
        throw new UnsupportedOperationException("uuid");
    }

    default BigDecimal getAsBigDecimal() {
        throw new UnsupportedOperationException("bigDecimal");
    }

    default DataByteArray getAsDataByteArray() {
        throw new UnsupportedOperationException("byteArray");
    }
}
