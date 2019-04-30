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
 * Common interface for all Media components.
 * <p>
 * Using this interface GXCommunication library enables communication with
 * different medias.
 * </p>
 * 
 * @author Gurux Ltd.
 */
public interface IGXMedia2 extends IGXMedia {
    /**
     * @return How long data from the media is waited before received data is
     *         handled.
     */
    int getReceiveDelay();

    /**
     * @param value
     *            How long data from the media is waited before received data is
     *            handled.
     */
    void setReceiveDelay(int value);

    /**
     * @return Wait time for asynchronous messages.
     */
    int getAsyncWaitTime();

    /**
     * @param value
     *            Wait time for asynchronous messages.
     */
    void setAsyncWaitTime(int value);

    /**
     * @return Wait handle for asynchronous messages. It's null if asynchronous
     *         messages is not used.
     */
    Object getAsyncWaitHandle();
}
