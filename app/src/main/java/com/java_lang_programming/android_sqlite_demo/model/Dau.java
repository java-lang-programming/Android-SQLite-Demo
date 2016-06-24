/**
 * Copyright (C) 2016 Programming Java Android Development Project
 * Programming Java is
 *
 *      http://java-lang-programming.com/
 *
 * Model Generator version : 1.0.2
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
}