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

import java.lang.reflect.Type;

/**
 * ReceiveArgs class is used when data is read synchronously.
 * 
 * @author Gurux Ltd.
 *
 * @param <T>
 *            Data type.
 */
public class ReceiveParameters<T> {
    /**
     * How long reply message is waited.
     */
    private int waitTime;

    /**
     * Is all data read when End of packet is found.
     */
    private boolean allData;
    /**
     * Received data.
     */
    private T reply;
    /**
     * Is data peek.
     */
    private boolean peek;
    /**
     * End of packet waited for.
     */
    private Object eop;
    /**
     * Minimum count of bytes waited for.
     */
    private int count;
    /**
     * Reply type.
     */
    private Type replyType;

    /**
     * Constructor.
     * 
     * @param type
     *            Reply type.
     */
    public ReceiveParameters(final Type type) {
        replyType = type;
        setPeek(false);
        setWaitTime(-1);
    }

    /**
     * If true, returns the bytes from the buffer without removing.
     * 
     * @return True, if bytes are not remove from the buffer.
     */
    public final boolean getPeek() {
        return peek;
    }

    /**
     * Set that bytes are read from the buffer without removing.
     * 
     * @param value
     *            True, if bytes are not remove from the buffer.
     */
    public final void setPeek(final boolean value) {
        peek = value;
    }

    /**
     * The end of packet (EOP) waited for.
     * 
     * The EOP can, for example be a single byte ('0xA1'), a string ("OK") or an
     * array of bytes.
     * 
     * @return end of packet.
     */
    public final Object getEop() {
        return eop;
    }

    /**
     * The end of packet (EOP) waited for.
     * 
     * @param value
     *            End of packet.
     */
    public final void setEop(final Object value) {
        eop = value;
    }

    /**
     * The number of reply data bytes to be read.
     * 
     * @return Count can be between 0 and n bytes.
     * 
     */
    public final int getCount() {
        return count;
    }

    /**
     * The number of reply data bytes to be read.
     * 
     * @param value
     *            Count can be between 0 and n bytes.
     */
    public final void setCount(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Count");
        }
        count = value;
    }

    /**
     * Maximum time, in milliseconds, to wait for reply data. WaitTime -1
     * (Default value) indicates infinite wait time.
     * 
     * @return Maximum wait time.
     */
    public final int getWaitTime() {
        return waitTime;
    }

    /**
     * Maximum time, in milliseconds, to wait for reply data. WaitTime -1
     * (Default value) indicates infinite wait time.
     * 
     * @param value
     *            Maximum wait time.
     */
    public final void setWaitTime(final int value) {
        waitTime = value;
    }

    /**
     * If True, all the reply data is moved from the buffer to reply data.
     * 
     * @return Is all data read from the buffer.
     */
    public final boolean getAllData() {
        return allData;
    }

    /**
     * If True, all the reply data is moved from the buffer to reply data.
     * 
     * @param value
     *            Is all data read from the buffer.
     */
    public final void setAllData(final boolean value) {
        allData = value;
    }

    /**
     * Get received reply data.
     * 
     * @return Received data.
     */
    public final T getReply() {
        return reply;
    }

    /**
     * Set received data.
     * 
     * @param value
     *            Received data.
     */
    @SuppressWarnings("unchecked")
    public final void setReply(final Object value) {
        reply = (T) value;
    }

    /**
     * Get reply data type.
     * 
     * @return Reply data type. Example String or byte array.
     */
    public final Type getReplyType() {
        return replyType;
    }
}