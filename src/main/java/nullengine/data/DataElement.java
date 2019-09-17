package nullengine.data;

import java.io.DataInput;
import java.io.DataOutput;

public interface DataElement {

    DataType getType();

    DataElement deepClone();

    void write(DataOutput output);

    void read(DataInput input);

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

    default DataObject getAsObject() {
        throw new UnsupportedOperationException();
    }

    default DataList getAsList() {
        throw new UnsupportedOperationException();
    }

    default String getAsString() {
        throw new UnsupportedOperationException();
    }

    default boolean getAsBoolean() {
        throw new UnsupportedOperationException();
    }

    default Number getAsNumber() {
        throw new UnsupportedOperationException();
    }

    default int getAsInt() {
        throw new UnsupportedOperationException();
    }

    default long getAsLong() {
        throw new UnsupportedOperationException();
    }

    default float getAsFloat() {
        throw new UnsupportedOperationException();
    }

    default double getAsDouble() {
        throw new UnsupportedOperationException();
    }

    default byte getAsByte() {
        throw new UnsupportedOperationException();
    }

    default short getAsShort() {
        throw new UnsupportedOperationException();
    }
}
