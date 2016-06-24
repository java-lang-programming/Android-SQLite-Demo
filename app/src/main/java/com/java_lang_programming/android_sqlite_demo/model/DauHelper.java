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

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.java_lang_programming.android_sqlite_demo.BuildConfig;
import com.java_lang_programming.android_sqlite_demo.util.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * An ModelHelper class for DauHelper
 */
public class DauHelper {

    public static final String TAG = "DauHelper";

    /**
     * return Dau List
     * @param context you should use ApplicationContext. ApplicationContext can get getApplicationContext().
     */
    public static List<Dau> getDauList(final Context context) {
        List<Dau> list = new ArrayList<Dau>();
        Dau dau = null;
        Cursor c = null;
        DBHelper dBHelper = null;
        try {
            dBHelper = new DBHelper(context);

            StringBuffer sql = new StringBuffer();
            sql.append("select ");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[0] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[1] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[2] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[3] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[4] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[5] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[6] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[7] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[8] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[9]);
            sql.append("from ");
            sql.append(" " + Dau.TABLE_NAME + " " + Dau.TABLE_NAME_OMISSION);

            if (BuildConfig.DEBUG) {
                Log.d(TAG, "sql" + sql.toString());
            }

            c = dBHelper.db.rawQuery(sql.toString(), null);

            boolean isResult = c.moveToFirst();

            while (isResult) {
                dau = new Dau();
                dau.id = c.getString(0);
                dau.dau_date = c.getString(1);
                dau.opening_price = c.getString(2);
                dau.high_price = c.getString(3);
                dau.low_price = c.getString(4);
                dau.closing_price = c.getString(5);
                dau.change_price = c.getString(6);
                dau.deleted_at = c.getString(7);
                dau.created_at = c.getString(8);
                dau.updated_at = c.getString(9);
                list.add(dau);
                isResult = c.moveToNext();
            }

        } catch (Exception e) {
            Log.e(TAG, "error occured!! cause : " + e.getMessage());
        } finally {

            if (c != null) {
                c.close();
            }

            if (dBHelper != null) {
                dBHelper.cleanup();
            }
        }
        return list;
    }

    /**
     * return Dau
     * @param context you should use ApplicationContext. ApplicationContext can get getApplicationContext().
     * @param id Dau's id
     */
    public static Dau getDau(final Context context, final String id) {
        Dau dau = null;
        Cursor c = null;
        DBHelper dBHelper = null;
        try {
            dBHelper = new DBHelper(context);

            StringBuffer sql = new StringBuffer();
            sql.append("select ");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[0] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[1] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[2] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[3] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[4] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[5] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[6] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[7] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[8] + ",");
            sql.append(" " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[9]);
            sql.append("from ");
            sql.append(" " + Dau.TABLE_NAME + " " + Dau.TABLE_NAME_OMISSION);
            sql.append(" where " + Dau.TABLE_NAME_OMISSION + "." + Dau.COL[0] + "=\"" +  id + "\"");
            if (BuildConfig.DEBUG) {
                Log.d(TAG, "sql" + sql.toString());
            }

            c = dBHelper.db.rawQuery(sql.toString(), null);

            boolean isResult = c.moveToFirst();

            if (isResult) {
                dau = new Dau();
                dau.id = c.getString(0);
                dau.dau_date = c.getString(1);
                dau.opening_price = c.getString(2);
                dau.high_price = c.getString(3);
                dau.low_price = c.getString(4);
                dau.closing_price = c.getString(5);
                dau.change_price = c.getString(6);
                dau.deleted_at = c.getString(7);
                dau.created_at = c.getString(8);
                dau.updated_at = c.getString(9);
                isResult = c.moveToNext();
            }

        } catch (Exception e) {
            Log.e(TAG, "error occured!! cause : " + e.getMessage());
        } finally {

            if (c != null) {
                c.close();
            }

            if (dBHelper != null) {
                dBHelper.cleanup();
            }
        }
        return dau;
    }

    /**
     * update
     * @param context you should use ApplicationContext. ApplicationContext can get getApplicationContext().
     * @param contentValues
     * @param id is primary key
     */
    public static void update(final Context context, final ContentValues contentValues, String id) {
        DBHelper dBHelper = new DBHelper(context);
        int result = dBHelper.db.update(Dau.TABLE_NAME, contentValues, Dau.COL[0] + "=" + id, null);
        dBHelper.cleanup();
    }

}