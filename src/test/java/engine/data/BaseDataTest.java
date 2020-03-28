package engine.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

abstract class BaseDataTest {

    @Test
    public void test() throws IOException {
        DataElement element = create();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        DataUtils.write(element, new DataOutputStream(output));
        DataElement read = DataUtils.read(new DataInputStream(new ByteArrayInputStream(output.toByteArray())));
        Assertions.assertEquals(element, read);
    }

    @Test
    public void testGzip() throws IOException {
        DataElement element = create();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (GZIPOutputStream outputStream = new GZIPOutputStream(output)) {
            DataUtils.write(element, new DataOutputStream(outputStream));
        }
        try (GZIPInputStream inputStream = new GZIPInputStream(new ByteArrayInputStream(output.toByteArray()))) {
            DataElement read = DataUtils.read(new DataInputStream(inputStream));
            Assertions.assertEquals(element, read);
        }
    }

    protected abstract DataElement create();
}
