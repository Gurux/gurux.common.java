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
 ReceiveArgs class is used when data ir read synchronously.
*/
public class ReceiveParameters<T>
{
    private int privateWaitTime;
    private boolean privateAllData;   
    private T privateReply;
    private boolean privatePeek;   
    private Object privateEop;
    private int privateCount;
    private Type ReplyType;

    /** 
     Constructor.
    */
    public ReceiveParameters(Type type)
    {
        ReplyType = type;
        setPeek(false);
        setWaitTime(-1);
    }    
    /** 
     If true, returns the bytes from the buffer without removing.
    */
    public final boolean getPeek()
    {
        return privatePeek;
    }
    public final void setPeek(boolean value)
    {
        privatePeek = value;
    }

    /** 
     The end of packet (EOP) waited for.

    The EOP can, for example be a single byte ('0xA1'), 
     a string ("OK") or an array of bytes.        

    */
    public final Object getEop()
    {
        return privateEop;
    }
    public final void setEop(Object value)
    {
        privateEop = value;
    }

    /** 
     The number of reply data bytes to be read.

     Count can be between 0 and n bytes.

    */
    public final int getCount()
    {
        return privateCount;
    }
    public final void setCount(int value)
    {
        privateCount = value;
    }

    /** 
     Maximum time, in milliseconds, to wait for reply data. 
     WaitTime -1 (Default value) indicates infinite wait time.
    */
    public final int getWaitTime()
    {
        return privateWaitTime;
    }
    public final void setWaitTime(int value)
    {
        privateWaitTime = value;
    }

    /** 
     If True, all the reply data is moved to ReplyData.
    */
    public final boolean getAllData()
    {
        return privateAllData;
    }
    public final void setAllData(boolean value)
    {
        privateAllData = value;
    }

    /** 
     Received reply data.
    */
    public final T getReply()
    {
        return privateReply;
    }
    public final void setReply(T value)
    {
        privateReply = value;
    }
    
    public final Type getReplyType()
    {
        return ReplyType;
    }    
}