//
// --------------------------------------------------------------------------
//  Gurux Ltd
// 
//
//
// Filename:        $HeadURL$
//
// Version:         $Revision$,
//                  $Date$
//                  $Author$
//
// Copyright (c) Gurux Ltd
//
//---------------------------------------------------------------------------
//
//  DESCRIPTION
//
// This file is a part of Gurux Device Framework.
//
// Gurux Device Framework is Open Source software; you can redistribute it
// and/or modify it under the terms of the GNU General Public License 
// as published by the Free Software Foundation; version 2 of the License.
// Gurux Device Framework is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of 
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
// See the GNU General Public License for more details.
//
// More information of Gurux products: http://www.gurux.org
//
// This code is licensed under the GNU General Public License v2. 
// Full text may be retrieved at http://www.gnu.org/licenses/gpl-2.0.txt
//---------------------------------------------------------------------------

package gurux.common;

import java.io.UnsupportedEncodingException;

/**
 * Common methods for device communicating.
 * 
 * @author Gurux Ltd.
 */
public final class GXCommon {

    /**
     * This is utility class and user can't create it.
     */
    private GXCommon() {

    }

    /**
     * Amount of chars one byte is taken in string.
     */
    static final int HEX_SIZE = 3;

    /**
     * Value of Hex A in decimal.
     */
    static final int HEX_A_DECIMAL_VALUE = 10;

    /**
     * Maximum size of byte.
     */
    static final int MAX_BYTE_SIZE = 0xFF;

    /**
     * Amount of bytes in short.
     */
    static final int SHORT_BYTES = 2;
    /**
     * Amount of bytes in integer.
     */
    static final int INTEGER_BYTES = 4;
    /**
     * Amount of bytes in long.
     */
    static final int LONG_BYTES = 4;

    /**
     * Low part of the byte.
     */
    static final int LOW_BYTE_PART = 0x0F;

    /**
     * Half a byte.
     */
    static final int NIBBLE = 4;

    /**
     * Returns high part or the byte.
     * 
     * @param value
     *            Byte value.
     * @return High part of the byte.
     */
    public static byte getHighByte(final int value) {
        return (byte) (value >>> NIBBLE);
    }

    /**
     * Get low part of the byte.
     * 
     * @param value
     *            Byte value.
     * @return Low part of the byte.
     */
    public static byte getLowByte(final int value) {
        return (byte) (value & LOW_BYTE_PART);
    }

    /**
     * Convert byte array to Hex string.
     * 
     * @param bytes
     *            Bytes to convert.
     * @return Hex string.
     */
    public static String bytesToHex(final byte[] bytes) {
        // Return empty string if array is empty.
        if (bytes == null || bytes.length == 0) {
            return "";
        }
        final char[] hexArray = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] hexChars = new char[bytes.length * HEX_SIZE];
        int tmp;
        for (int pos = 0; pos != bytes.length; ++pos) {
            tmp = bytes[pos] & MAX_BYTE_SIZE;
            hexChars[pos * HEX_SIZE] = hexArray[getHighByte(tmp)];
            hexChars[pos * HEX_SIZE + 1] = hexArray[getLowByte(tmp)];
            hexChars[pos * HEX_SIZE + 2] = ' ';
        }
        return new String(hexChars, 0, hexChars.length - 1);
    }

    /**
     * Convert char hex value to byte value.
     * 
     * @param c
     *            Character to convert hex.
     * @return Byte value of hex char value.
     */
    private static byte getValue(final byte c) {
        byte value;
        // Id char.
        if (c > '9') {
            if (c > 'Z') {
                value = (byte) (c - 'a');
            } else {
                value = (byte) (c - 'A');
            }
            value += HEX_A_DECIMAL_VALUE;
        } else {
            // If number.
            value = (byte) (c - '0');
        }
        return value;
    }

    /**
     * Convert string to byte array.
     * 
     * @param value
     *            Hex string.
     * @return byte array.
     */
    public static byte[] hexToBytes(final String value) {
        byte[] buffer = new byte[value.length() / 2];
        int lastValue = -1;
        int index = 0;
        try {
            for (byte ch : value.getBytes("ASCII")) {
                if (ch >= '0' && ch < 'g') {
                    if (lastValue == -1) {
                        lastValue = getValue(ch);
                    } else if (lastValue != -1) {
                        buffer[index] =
                                (byte) (lastValue << NIBBLE | getValue(ch));
                        lastValue = -1;
                        ++index;
                    }
                } else if (lastValue != -1) {
                    buffer[index] = getValue(ch);
                    lastValue = -1;
                    ++index;
                }
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
        byte[] tmp = new byte[index];
        System.arraycopy(buffer, 0, tmp, 0, index);
        return tmp;
    }
}
