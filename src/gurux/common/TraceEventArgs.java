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

/** 
 * Argument class for IGXMedia connection and disconnection events.
*/
public class TraceEventArgs
{
    private java.util.Date privateTimestamp = new java.util.Date(0);    
    private TraceTypes privateType;
    private Object privateData;
    
    /** 
     Timestamp.
    */
    public final java.util.Date getTimestamp()
    {
        return privateTimestamp;
    }
    public final void setTimestamp(java.util.Date value)
    {
        privateTimestamp = value;
    }

    /** 
     Is data send or received and type of trace.
    */
    public final TraceTypes getType()
    {
        return privateType;
    }
    public final void setType(TraceTypes value)
    {
        privateType = value;
    }

    /** 
     Received/send data.
    */    
    public final Object getData()
    {
        return privateData;
    }
    public final void setData(Object value)
    {
        privateData = value;
    }

    /** 
     Convert data to string.

     @param ascii Is content get as ascii or hex string.
     @return Content of data as string.
    */
    public final String DataToString(boolean ascii)
    {
        if (getData() == null)
        {
            return "";
        }
        if (getData() instanceof byte[])
        {
            byte[] bytes = (byte[]) getData();
            if (ascii)
            {
                try 
                { 
                    return new String(bytes, "ASCII");
                } 
                catch (Exception ex) 
                {
                    Logger.getLogger(TraceEventArgs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return GXCommon.bytesToHex(bytes);
        }
        return String.valueOf(getData());
    }

    /** 
     Show trace event content as string.

     @return 
    */
    @Override
    public String toString()
    {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");        
        return df.format(getTimestamp()) + "\t" + 
                getType().toString() + "\t" + DataToString(false);
    }

    /** 
     Constructor
    */
    public TraceEventArgs(TraceTypes type, Object data)
    {
        setTimestamp(new java.util.Date());
        setType(type);
        setData(data);
    }

    /** 
     Constructor
    */
    public TraceEventArgs(TraceTypes type, byte[] data, int index, int length)
    {
        setTimestamp(new java.util.Date());
        setType(type);
        byte[] tmp = new byte[length];
        System.arraycopy(data, index, tmp, 0, length);
        setData(tmp);
    }
}