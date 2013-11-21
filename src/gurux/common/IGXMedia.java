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

/** 
Common interface for all Media components.<br/>
Using this interface GXCommunication library enables communication with
different medias.
*/
public interface IGXMedia
{
    /*
     * Start to listen media events.
     */
    void addListener(IGXMediaListener listener);

    /*
     * Stop to listen media events.
     */
    void removeListener(IGXMediaListener listener);

    /** 
     Copies the content of the media to target media.
    */
    void copy(Object target);

    /** 
     Returns name of the media.


     Media name is used to identify media connection, so two different media connection can not return same media name.

    */
    String getName();

    /** 
     Trace level of the IGXMedia for System.Diagnostic.Trace.Writes.

    * @see IGXMediaListener#OnTrace
    */
    TraceLevel getTrace();
    void setTrace(TraceLevel value);

    /** 
     Opens the media.
    */
    void open() throws Exception;

    /** 
     Checks if the connection is established.

     @return True, if the connection is established.		
    */
    boolean isOpen();

    /** 
     Closes the active connection.

     @see Open Open
    */
    void close();

    /** 
     Sends data asynchronously. <br/>
     No reply from the receiver, whether or not the operation was successful, is expected.

     @param data Data to send to the device.
     @param receiver Media depend information of the receiver (optional).
     @see Receive Receive
    */
    void send(Object data, String receiver) throws Exception;

    /** 
     Returns media type as a string.
    */
    String getMediaType();

    /** 
     Media settings as a XML string.
    */
    String getSettings();
    void setSettings(String value);

    /** 
     Locking this property makes the connection synchronized and stops sending OnReceived events.
    */
    Object getSynchronous();

    /** 
     Checks if the connection is in synchronous mode.

     @return True, if the connection is in synchronous mode.		
    */
    boolean getIsSynchronous();

    /** 
     Waits for more reply data After SendSync if whole packet is not received yet.

     @param args Receive data arguments.
     @return True, if the send operation was successful.
     @see Send SendSync
     @see Synchronous Synchronous
    */
    <T> boolean receive(ReceiveParameters<T> args);

    /** 
     Resets synchronous buffer.
    */
    void resetSynchronousBuffer();

    /** 
     Sent byte count.

     @see BytesReceived BytesReceived
     @see ResetByteCounters ResetByteCounters            
    */
    long getBytesSent();

    /** 
     Received byte count.

     @see BytesSent BytesSent
     @see ResetByteCounters ResetByteCounters            
    */
    long getBytesReceived();

    /** 
     Resets BytesReceived and BytesSent counters.

     @see BytesSent BytesSent
     @see BytesReceived BytesReceived            
    */
    void resetByteCounters();

    /** 
     Validate Media settings for connection open. Returns table of media properties that must be set before media is valid to open. Return NULL if media is capable to open with these settings.

     @return List of media properties that must set before connection can be established.
    */
    void validate();

    /** 
     Data is buffered until EOP is received.
    */
    Object getEop();
    void setEop(Object value);

    /** 
     Visible controls on the properties dialog.
    */
    int getConfigurableSettings();
    void setConfigurableSettings(int value);
}
