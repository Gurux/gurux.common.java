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
 * This class is used to communicate with native serial port class. This is
 * reserved for inner use. DO NOT USE.
 * 
 * @author Gurux Ltd.
 */
public final class NativeCode {

    /**
     * This is utility class and user can't create it.
     */
    private NativeCode() {

    }

    /**
     * Returns available serial ports.
     * 
     * @return Collection of available serial port names.
     */
    public static native String[] getPortNames();

    /**
     * Open serial port.
     * 
     * @param port
     *            Name of serial port.
     * @param closing
     *            Returns handle to the event that is used when connection to
     *            the serial port is closed.
     * 
     * 
     * @return Serial port handle.
     */
    public static native int openSerialPort(final String port,
            final long[] closing);

    /**
     * Close serial port.
     * 
     * @param hComPort
     *            Handle to the serial port to close.
     * @param closing
     *            Handle to the event that is used when connection to the serial
     *            port is closed.
     */
    public static native void closeSerialPort(final long hComPort,
            final long closing);

    /**
     * Get baud rate.
     * 
     * @param hComPort
     *            Handle to the serial port
     * @return Current baud rate.
     */
    public static native int getBaudRate(final long hComPort);

    /**
     * Set baud rate.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @param value
     *            Baud rate.
     */
    public static native void setBaudRate(final long hComPort, final int value);

    /**
     * Get data bits.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @return Amount of data bits.
     */
    public static native int getDataBits(final long hComPort);

    /**
     * Set amount of data bits.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @param value
     *            Amount of data bits.
     */
    public static native void setDataBits(final long hComPort, final int value);

    /**
     * Get parity.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @return Parity.
     */
    public static native int getParity(final long hComPort);

    /**
     * Set parity.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @param value
     *            parity.
     */
    public static native void setParity(final long hComPort, final int value);

    /**
     * Get stop bits.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @return Amount of stop bits.
     */
    public static native int getStopBits(final long hComPort);

    /**
     * Set stop bits.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @param value
     *            Amount of stop bits.
     */
    public static native void setStopBits(final long hComPort, final int value);

    /**
     * Get break state.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @return Is serial port in break state.
     */
    public static native boolean getBreakState(final long hComPort);

    /**
     * Set break state.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @param value
     *            Is serial port in break state.
     */
    public static native void setBreakState(final long hComPort,
            final boolean value);

    /**
     * Get Request To Send state.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @return True if RTS is set.
     */
    public static native boolean getRtsEnable(final long hComPort);

    /**
     * Set Request To Send state.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @param value
     *            Is RTS set.
     */
    public static native void setRtsEnable(final long hComPort,
            final boolean value);

    /**
     * Is Data Terminal ready set.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @return True, if DTR is set.
     */
    public static native boolean getDtrEnable(final long hComPort);

    /**
     * Is Data Terminal ready set.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @param value
     *            True, if DTR is set.
     */
    public static native void setDtrEnable(final long hComPort,
            final boolean value);

    /**
     * Get Get Data Set Ready holding flag.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @return True, if DST holding is set.
     */
    public static native boolean getDsrHolding(final long hComPort);

    /**
     * Returns amount of bytes to read.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @return Amount of bytes to read.
     */
    public static native int getBytesToRead(final long hComPort);

    /**
     * Returns amount of bytes to write.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @return Amount of bytes to write.
     */
    public static native int getBytesToWrite(final long hComPort);

    /**
     * Read data from serial port to the buffer.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @param readTimeout
     *            How long data read can take.
     * @param closing
     *            Handle to the event that is used when connection to the serial
     *            port is closed.
     * @return bytes to read.
     */
    public static native byte[] read(final long hComPort, final int readTimeout,
            final long closing);

    /**
     * Write data to the serial port.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @param data
     *            Data to write.
     * @param writeTimeout
     *            How long data write can take.
     * 
     */
    public static native void write(final long hComPort, final byte[] data,
            final int writeTimeout);

    /**
     * Returns Clear To Send holding flag.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @return State of CTS.
     */
    public static native boolean getCtsHolding(final long hComPort);

    /**
     * Gets the state of the Carrier Detect line for the port.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @return State of DC.
     */
    public static native boolean getCDHolding(final long hComPort);

    /**
     * Gets the handshaking protocol for serial port transmission of data.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @return Handshake.
     */
    public static native int getHandshake(final long hComPort);

    /**
     * Sets the handshaking protocol for serial port transmission of data.
     * 
     * @param hComPort
     *            Handle to the serial port.
     * @param value
     *            Handshake.
     */
    public static native void setHandshake(final long hComPort,
            final int value);
}
