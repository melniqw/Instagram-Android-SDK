/*******************************************************************************
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Alexey <menliqw> Melnikov.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/

package com.melniqw.instagramsdk;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class UserInPhoto implements Serializable {
    private static final long serialVersionUID = 1L;

    public User user = new User();
    public Position position = new Position();

    public class Position {
        public double x;
        public double y;

        public String toXML() {
            StringBuilder builder = new StringBuilder();
            builder.append("<x>" + x + "</x>" + "\n");
            builder.append("<y>" + x + "</y>" + "\n");
            return builder.toString();
        }
    }

    public String toXML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<user>" + user.toXML() + "</user>" + "\n");
        builder.append("<position>" + position.toXML() + "</position>" + "\n");
        return builder.toString();
    }

    public static UserInPhoto fromJSON(JSONObject o) throws JSONException {
        if(o == null) return null;
        UserInPhoto userInPhoto = new UserInPhoto();
        JSONObject positionJSON = o.optJSONObject("position");
        userInPhoto.position.x = positionJSON.optDouble("x");
        userInPhoto.position.y = positionJSON.optDouble("y");
        JSONObject userJSON = o.optJSONObject("user");
        userInPhoto.user = User.fromJSON(userJSON);
        return userInPhoto;
    }
}
