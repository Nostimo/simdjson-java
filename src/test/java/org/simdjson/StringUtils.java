package org.simdjson;

import jdk.incubator.vector.ByteVector;

import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

class StringUtils {

    static String padWithSpaces(String str) {
        byte[] strBytes = toUtf8(str);
        byte[] padded = new byte[strBytes.length + 64];
        Arrays.fill(padded, (byte) ' ');
        System.arraycopy(strBytes, 0, padded, 0, strBytes.length);
        return new String(padded, UTF_8);
    }

    static ByteVector chunk0(String str) {
        return ByteVector.fromArray(ByteVector.SPECIES_256, toUtf8(str), 0);
    }

    static ByteVector chunk1(String str) {
        return ByteVector.fromArray(ByteVector.SPECIES_256, toUtf8(str), 32);
    }

    static byte[] toUtf8(String str) {
        return str.getBytes(UTF_8);
    }
}