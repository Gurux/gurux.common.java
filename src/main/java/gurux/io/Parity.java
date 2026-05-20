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
 * Specifies parity modes for serial communication.
 * <p>
 * Parity adds an optional error-checking bit to each transmitted character.
 * </p>
 * 
 * @author Gurux Ltd.
 */
public enum Parity {
    /**
     * No parity bit is used.
     */
    NONE,
    /**
     * The parity bit is set so that the total number of set bits is odd.
     */
    ODD,
    /**
     * The parity bit is set so that the total number of set bits is even.
     */
    EVEN,
    /**
     * The parity bit is always set to {@code 1}.
     */
    MARK,
    /**
     * The parity bit is always set to {@code 0}.
     */
    SPACE;
}
