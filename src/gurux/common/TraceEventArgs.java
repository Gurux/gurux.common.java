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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import gurux.common.enums.TraceTypes;

/**
 * Argument class for IGXMedia connection and disconnection events.
 * 
 * @author Gurux Ltd.
 */
public class TraceEventArgs {
    /**
     * Time stamp when data is send or received.
     */
    private java.util.Date timestamp = new java.util.Date(0);
    /**
     * Trace type.
     */
    private TraceTypes traceType;
    /**
     * Send or received data.
     */
    private Object traceData;

    /**
     * Constructor.
     * 
     * @param type
     *            Trace type.
     * @param data
     *            Send or received data.
     */
    public TraceEventArgs(final TraceTypes type, final Object data) {
        setTimestamp(new java.util.Date());
        setType(type);
        setData(data);
    }

    /**
     * Constructor.
     * 
     * @param type
     *            Trace type.
     * @param data
     *            Send or received data.
     * @param index
     *            Index where data copy is started.
     * @param length
     *            How many bytes are included to data.
     */
    public TraceEventArgs(final TraceTypes type, final byte[] data,
            final int index, final int length) {
        setTimestamp(new java.util.Date());
        setType(type);
        byte[] tmp = new byte[length];
        System.arraycopy(data, index, tmp, 0, length);
        setData(tmp);
    }

    /**
     * Get time stamp.
     * 
     * @return Time stamp.
     */
    public final java.util.Date getTimestamp() {
        return timestamp;
    }

    /**
     * Set time stamp.
     * 
     * @param value
     *            new time stamp.
     */
    public final void setTimestamp(final java.util.Date value) {
        timestamp = value;
    }

    /**
     * Get is data send or received and type of trace.
     * 
     * @return Trace type.
     */
    public final TraceTypes getType() {
        return traceType;
    }

    /**
     * Set is data send or received and type of trace.
     * 
     * @param value
     *            Trace type.
     */
    public final void setType(final TraceTypes value) {
        traceType = value;
    }

    /**
     * Get received or send data.
     * 
     * @return Sent or received data.
     */
    public final Object getData() {
        return traceData;
    }

    /**
     * Set received or send data.
     * 
     * @param value
     *            Sent or received data.
     */
    public final void setData(final Object value) {
        traceData = value;
    }

    /**
     * Convert data to string.
     * 
     * @param ascii
     *            Is content get as ASCII or hex string.
     * @return Content of data as string.
     */
    public final String dataToString(final boolean ascii) {
        if (getData() == null) {
            return "";
        }
        if (getData() instanceof byte[]) {
            byte[] bytes = (byte[]) getData();
            if (ascii) {
                try {
                    return new String(bytes, "ASCII");
                } catch (Exception ex) {
                    Logger.getLogger(TraceEventArgs.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            return GXCommon.bytesToHex(bytes);
        }
        return String.valueOf(getData());
    }

    @Override
    public final String toString() {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(getTimestamp()) + "\t" + getType().toString() + "\t"
                + dataToString(false);
    }
}