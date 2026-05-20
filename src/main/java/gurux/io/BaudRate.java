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

package gurux.io;

/**
 * Enumerates supported serial communication baud rates.
 * <p>
 * Each enum constant stores its numeric rate (for example, {@code 9600}) and
 * can be converted to and from its integer representation using
 * {@link #getValue()} and {@link #forValue(int)}.
 * </p>
 * 
 * @author Gurux Ltd.
 */
public enum BaudRate {
    /**
     * 921600 baud.
     */
    BAUD_RATE_921600(921600),
    /**
     * 460800 baud.
     */
    BAUD_RATE_460800(460800),
    /**
     * 230400 baud.
     */
    BAUD_RATE_230400(230400),
    /**
     * 115200 baud.
     */
    BAUD_RATE_115200(115200),
    /**
     * 57600 baud.
     */
    BAUD_RATE_57600(57600),
    /**
     * 38,400 baud.
     */
    BAUD_RATE_38400(38400),
    /**
     * 19,200 baud.
     */
    BAUD_RATE_19200(19200),
    /**
     * 9,600 baud.
     */
    BAUD_RATE_9600(9600),
    /**
     * 4,800 baud.
     */
    BAUD_RATE_4800(4800),

    /**
     * 2,400 baud.
     */
    BAUD_RATE_2400(2400),

    /**
     * 1,800 baud.
     */
    BAUD_RATE_1800(1800),

    /**
     * 600 baud.
     */
    BAUD_RATE_600(600),

    /**
     * 300 baud.
     */
    BAUD_RATE_300(300);

    /**
     * Integer representation of the baud rate.
     */
    private int intValue;
    /**
     * Cached mapping from integer baud rates to enum constants.
     */
    private static java.util.HashMap<Integer, BaudRate> mappings;

    /**
     * Returns the mapping from integer values to enum constants.
     * 
     * @return Mapping of numeric baud rates to {@link BaudRate} values.
     */
    private static java.util.HashMap<Integer, BaudRate> getMappings() {
        if (mappings == null) {
            synchronized (BaudRate.class) {
                if (mappings == null) {
                    mappings = new java.util.HashMap<Integer, BaudRate>();
                }
            }
        }
        return mappings;
    }

    /**
     * Creates an enum constant and registers it in the integer lookup table.
     * 
     * @param value
     *              Numeric baud rate.
     */
    BaudRate(final int value) {
        intValue = value;
        getMappings().put(value, this);
    }

    /**
     * Returns the numeric baud rate represented by this enum constant.
     * 
     * @return Baud rate value.
     */
    public int getValue() {
        return intValue;
    }

    /**
     * Returns the enum constant matching the specified numeric baud rate.
     * 
     * @param value
     *              Numeric baud rate.
     * @return Matching {@link BaudRate} value.
     * @throws IllegalArgumentException
     *                                  If {@code value} does not match any defined
     *                                  baud rate.
     */
    public static BaudRate forValue(final int value) {
        BaudRate ret = getMappings().get(value);
        if (ret == null) {
            throw new IllegalArgumentException("Invalid Baudrate enum value.");
        }
        return ret;
    }

    /**
     * Parses a string into a {@link BaudRate} value.
     * <p>
      * The value must be a decimal integer baud rate, for example {@code "9600"}.
     * </p>
     * 
     * @param value
     *              String representation of baud rate.
     * @return Matching {@link BaudRate} value.
     * @throws IllegalArgumentException
     *                                  If {@code value} is null, empty, or cannot
      *                                  be mapped to a defined baud rate.
     */
    public static BaudRate forValue(final String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Baudrate string value cannot be null or empty.");
        }
        String trimmed = value.trim();
        return forValue(Integer.parseInt(trimmed));
    }
}