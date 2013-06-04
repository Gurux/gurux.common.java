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

public interface IGXMediaListener 
{
    /** 
        Represents the method that will handle the error event of a Gurux component.

        @param sender The source of the event.
        @param ex An Exception object that contains the event data.
    */
    void onError(Object sender, RuntimeException ex);

    /** 
     Media component sends received data through this method.

     @param sender The source of the event.
     @param e Event arguments.
    */
    void onReceived(Object sender, ReceiveEventArgs e);    

    /** 
     Media component sends notification, when its state changes.

     @param sender The source of the event.    
     @param e Event arguments.
    */
    void onMediaStateChange(Object sender, MediaStateEventArgs e);

    /** 
     Called when the Media is sending or receiving data.

     @param sender
     @param e
     @see IGXMedia.Trace Traceseealso>
    */
    void onTrace(Object sender, TraceEventArgs e);    
    
    // Summary:
    //     Represents the method that will handle the System.ComponentModel.INotifyPropertyChanged.PropertyChanged
    //     event raised when a property is changed on a component.
    //
    // Parameters:
    //   sender:
    //     The source of the event.
    //
    //   e:
    //     A System.ComponentModel.PropertyChangedEventArgs that contains the event
    //     data.
    void onPropertyChanged(Object sender, PropertyChangedEventArgs e);
}