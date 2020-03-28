package engine.data;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface DataNumber extends DataElement {

    @Override
    default boolean isNumber() {
        return true;
    }

    @Override
    default DataNumber getAsDataNumber() {
        return this;
    }

    Number getAsNumber();

    int getAsInt();

    long getAsLong();

    float getAsFloat();

    double getAsDouble();

    byte getAsByte();

    short getAsShort();

    BigInteger getAsBigInteger();

    BigDecimal getAsBigDecimal();
}
