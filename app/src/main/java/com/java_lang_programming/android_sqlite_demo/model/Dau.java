/**
 * Copyright (C) 2016 Programming Java Android Development Project
 * Programming Java is
 *
 *      http://java-lang-programming.com/
 *
 * Model Generator version : 1.0.4
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

import android.text.TextUtils;

/**
 * An Model class for Dau
 */
public class Dau {

    public static final String TAG = "Dau";
    // table name
    public static final String TABLE_NAME = "Dau";
    // table name aliases
    public static final String TABLE_NAME_OMISSION = "D";
    // カラム配列
    public static final String [] COL = new String [] {"id","dau_date","opening_price","high_price","low_price","closing_price","change_price","deleted_at","created_at","updated_at"};

    // id
    public String id;
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

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("Dau [");
        if (!TextUtils.isEmpty(id)) {
            str.append(" id=" + id);
        }
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
        if (!TextUtils.isEmpty(deleted_at)) {
            str.append(", deleted_at=" + deleted_at);
        }
        if (!TextUtils.isEmpty(created_at)) {
            str.append(", created_at=" + created_at);
        }
        if (!TextUtils.isEmpty(updated_at)) {
            str.append(", updated_at=" + updated_at);
        }
        str.append("]");
        return str.toString();
    }
}