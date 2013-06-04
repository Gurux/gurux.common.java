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
 Argument class for IGXMedia data received events.
*/
public class ReceiveEventArgs
{
    private Object privateData;
    private String privateSenderInfo;
    
    /** 
     Constructor
    */
    public ReceiveEventArgs()
    {

    }

    /** 
     Constructor
    */
    public ReceiveEventArgs(Object data, String senderInfo)
    {
        setData(data);
        setSenderInfo(senderInfo);
    }

    /** 
     Pointer to the (safe array) byte buffer containing the data, 
     which is received from the device.
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
     Media depend sender information.
    */
    public final String getSenderInfo()
    {
        return privateSenderInfo;
    }
    public final void setSenderInfo(String value)
    {
        privateSenderInfo = value;
    }
}