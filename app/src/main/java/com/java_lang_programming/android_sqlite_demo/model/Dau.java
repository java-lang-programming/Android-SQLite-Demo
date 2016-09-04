/**
 * Copyright (C) 2016 Programming Java Android Development Project
 * Programming Java is
 *
 *      http://java-lang-programming.com/
 *
 * Model Generator version : 1.3.1
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.java_lang_programming.android_sqlite_demo.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * An Model class for Dau
 */
public class Dau implements Parcelable {

    public static final String TAG = "Dau";
    // table name
    public static final String TABLE_NAME = "dau";
    // table name aliases
    public static final String TABLE_NAME_OMISSION = "d";
    // column list constant
    public static final List<String> COL = Collections
            .unmodifiableList(new LinkedList<String>() {
                {
                    add("id");
                    add("dau_date");
                    add("opening_price");
                    add("high_price");
                    add("low_price");
                    add("closing_price");
                    add("change_price");
                    add("deleted_at");
                    add("created_at");
                    add("updated_at");

                }
            });


    // id
    public int id;
    // dau_date
    public String dau_date;
    // opening_price
    public String opening_price;
    // high_price
    public String high_price;
    // low_price
    public String low_price;
    // closing_price
    public String closing_price;
    // change_price
    public String change_price;
    // deleted_at
    public String deleted_at;
    // created_at
    public String created_at;
    // updated_at
    public String updated_at;

    public Dau() {}
    public static final Parcelable.Creator<Dau> CREATOR
            = new Parcelable.Creator<Dau>() {
        public Dau createFromParcel(Parcel in) {
            return new Dau(in);
        }

        public Dau[] newArray(int size) {
            return new Dau[size];
        }
    };

    private Dau(Parcel in) {
        id = in.readInt();
        dau_date = in.readString();
        opening_price = in.readString();
        high_price = in.readString();
        low_price = in.readString();
        closing_price = in.readString();
        change_price = in.readString();
        deleted_at = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(id);
        out.writeString(dau_date);
        out.writeString(opening_price);
        out.writeString(high_price);
        out.writeString(low_price);
        out.writeString(closing_price);
        out.writeString(change_price);
        out.writeString(deleted_at);
        out.writeString(created_at);
        out.writeString(updated_at);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("Dau [");
        str.append(" id=" + id);
        if (!TextUtils.isEmpty(dau_date)) {
            str.append(", dau_date=" + dau_date);
        }
        if (!TextUtils.isEmpty(opening_price)) {
            str.append(", opening_price=" + opening_price);
        }
        if (!TextUtils.isEmpty(high_price)) {
            str.append(", high_price=" + high_price);
        }
        if (!TextUtils.isEmpty(low_price)) {
            str.append(", low_price=" + low_price);
        }
        if (!TextUtils.isEmpty(closing_price)) {
            str.append(", closing_price=" + closing_price);
        }
        if (!TextUtils.isEmpty(change_price)) {
            str.append(", change_price=" + change_price);
        }
        str.append(", deleted_at=" + deleted_at);
        str.append(", created_at=" + created_at);
        str.append(", updated_at=" + updated_at);
        str.append("]");
        return str.toString();
    }
}