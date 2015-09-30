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

import gurux.common.enums.MediaState;

/**
 * An argument class for media state changed event.
 * 
 * @author Gurux Ltd.
 */
public class MediaStateEventArgs {
    /**
     * Media state.
     */
    private MediaState state;
    /**
     * Is connection accepted.
     */
    private boolean accept;

    /**
     * Constructor.
     */
    public MediaStateEventArgs() {
        setAccept(true);
    }

    /**
     * Constructor.
     * 
     * @param mediaState
     *            New media state.
     */
    public MediaStateEventArgs(final MediaState mediaState) {
        super();
        setState(mediaState);
    }

    /**
     * State information from media state.
     * 
     * @return Media state.
     */
    public final MediaState getState() {
        return state;
    }

    /**
     * State information from media state.
     * 
     * @param value
     *            Media state.
     */
    public final void setState(final MediaState value) {
        state = value;
    }

    /**
     * Get is media connection accepted.
     * 
     * @return Is connection accepted.
     */
    public final boolean getAccept() {
        return accept;
    }

    /**
     * Set is media connection accepted.
     * 
     * @param value
     *            Is connection accepted.
     */
    public final void setAccept(final boolean value) {
        accept = value;
    }
}