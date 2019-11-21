//
// --------------------------------------------------------------------------
//  Gurux Ltd
// 
//
//
// Filename:        $HeadURL:  $
//
// Version:         $Revision: $,
//                  $Date:  $
//                  $Author: $
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
// More information of Gurux DLMS/COSEM Director: http://www.gurux.org/GXDLMSDirector
//
// This code is licensed under the GNU General Public License v2. 
// Full text may be retrieved at http://www.gnu.org/licenses/gpl-2.0.txt
//---------------------------------------------------------------------------

package gurux.common;

/**
 * This class is used to save command line parameters.
 */
public class GXCmdParameter {
    /**
     * Command line parameter tag.
     */
    private char tag;

    /**
     * Command line parameter value.
     */
    private String parameter;

    /**
     * Parameter is missing.
     */
    private boolean missing;

    /**
     * @return Command line parameter tag.
     */
    public final char getTag() {
        return tag;
    }

    /**
     * @param value
     *            Command line parameter tag.
     */
    public final void setTag(final char value) {
        tag = value;
    }

    /**
     * @return Command line parameter value.
     */
    public final String getValue() {
        return parameter;
    }

    /**
     * @param value
     *            Command line parameter value.
     */
    public final void setValue(final String value) {
        parameter = value;
    }

    /**
     * @return Parameter is missing.
     */
    public final boolean isMissing() {
        return missing;
    }

    /**
     * @param value
     *            Parameter is missing.
     */
    public final void setMissing(boolean value) {
        missing = value;
    }

    /**
     * @return Command line parameter as a string.
     */
    @Override
    public String toString() {
        if (isMissing()) {
            return getTag() + " is missing.";
        }
        if (getValue() == null) {
            return (new Character(getTag())).toString();
        }
        return getTag() + "=" + getValue();
    }
}