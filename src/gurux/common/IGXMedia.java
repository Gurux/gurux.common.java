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

import gurux.common.enums.TraceLevel;

/**
 * Common interface for all Media components.
 * <p>
 * Using this interface GXCommunication library enables communication with
 * different medias.
 * </p>
 * 
 * @author Gurux Ltd.
 */
public interface IGXMedia {

    /**
     * Start to listen media events.
     * 
     * @param listener
     *            Listener class.
     */
    void addListener(IGXMediaListener listener);

    /**
     * Stop to listen media events.
     * 
     * @param listener
     *            Listener class.
     */
    void removeListener(IGXMediaListener listener);

    /**
     * Copies the content of the media to target media.
     * 
     * @param target
     *            Target media.
     */
    void copy(Object target);

    /**
     * Returns name of the media. Media name is used to identify media
     * connection, so two different media connection can not return same media
     * name.
     * 
     * @return Media name.
     */
    String getName();

    /**
     * Trace level of the IGXMedia.
     * 
     * @return Trace level.
     * @see IGXMediaListener#onTrace
     */
    TraceLevel getTrace();

    /**
     * Set new trace level.
     * 
     * @param value
     *            Trace level.
     */
    void setTrace(TraceLevel value);

    /**
     * Opens the media.
     * 
     * @throws Exception
     *             Occurred exception.
     */
    void open() throws Exception;

    /**
     * Checks if the connection is established.
     * 
     * @return True, if the connection is established.
     */
    boolean isOpen();

    /**
     * Closes the active connection.
     * 
     * @see IGXMedia#open open
     */
    void close();

    /**
     * Sends data asynchronously. No reply from the receiver, whether or not the
     * operation was successful, is expected.
     * 
     * @param data
     *            Data to send to the device.
     * @param receiver
     *            Media depend information of the receiver (optional).
     * @throws Exception
     *             Occurred exception.
     * @see IGXMedia#receive receive
     */
    void send(Object data, String receiver) throws Exception;

    /**
     * Returns media type as a string.
     * 
     * @return Type of the media.
     */
    String getMediaType();

    /**
     * Get media settings.
     * 
     * @return Media settings as a XML string.
     */
    String getSettings();

    /**
     * Set media settings.
     * 
     * @param value
     *            Media settings as a XML string.
     */
    void setSettings(String value);

    /**
     * Locking this property makes the connection synchronized and stops sending
     * OnReceived events.
     * 
     * @return Locking object.
     */
    Object getSynchronous();

    /**
     * Checks if the connection is in synchronous mode.
     * 
     * @return True, if the connection is in synchronous mode.
     */
    boolean getIsSynchronous();

    /**
     * Waits for more reply data After SendSync if whole packet is not received
     * yet.
     * 
     * @param <T>
     *            Media type.
     * @param args
     *            Receive data arguments.
     * @return True, if the send operation was successful.
     * @see IGXMedia#send send
     * @see IGXMedia#getIsSynchronous getIsSynchronous
     */
    <T> boolean receive(ReceiveParameters<T> args);

    /**
     * Resets synchronous buffer.
     */
    void resetSynchronousBuffer();

    /**
     * Sent byte count.
     * 
     * @return Bytes sent.
     * @see IGXMedia#getBytesReceived() getBytesReceived()
     * @see IGXMedia#resetByteCounters() resetByteCounters()
     */
    long getBytesSent();

    /**
     * Received byte count.
     * 
     * @return Bytes received.
     * @see IGXMedia#getBytesSent() getBytesSent()
     * @see IGXMedia#resetByteCounters() resetByteCounters()
     */
    long getBytesReceived();

    /**
     * Resets BytesReceived and BytesSent counters.
     * 
     * @see IGXMedia#getBytesSent() getBytesSent()
     * @see IGXMedia#getBytesReceived() getBytesReceived()
     */
    void resetByteCounters();

    /**
     * Validate Media settings for connection open. Returns table of media
     * properties that must be set before media is valid to open.
     */
    void validate();

    /**
     * Get used end of packet.
     * 
     * @return Used end of packet.
     */
    Object getEop();

    /**
     * Set End of packet.
     * 
     * @param value
     *            Used end of packet.
     */
    void setEop(Object value);

    /**
     * Get visible controls on the properties dialog.
     * 
     * @return Visible controls.
     */
    int getConfigurableSettings();

    /**
     * Set visible controls on the properties dialog.
     * 
     * @param value
     *            Visible controls.
     */
    void setConfigurableSettings(int value);

    /**
     * Shows the media Properties dialog.
     * 
     * @param parent
     *            Parent window.
     * @return Returns true if user has accepted changes.
     */
    boolean properties(javax.swing.JFrame parent);
}
