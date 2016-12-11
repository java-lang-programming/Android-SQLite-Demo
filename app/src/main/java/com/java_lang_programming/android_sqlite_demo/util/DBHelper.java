/**
 * Copyright (C) 2016 Programming Java Android Development Project
 * Programming Java is
 * <p>
 * http://java-lang-programming.com/
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.java_lang_programming.android_sqlite_demo.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import java.io.File;

/**
 * DBHelper is a class that helps SQLite operation.
 */
public class DBHelper {
    public static final String TAG = "DBHelper";

    public SQLiteDatabase db;
    private final DBOpenHelper dbOpenHelper;

    public DBHelper(final Context context) {
        this.dbOpenHelper = new DBOpenHelper(context);
        establishDb();
    }

    private void establishDb() {
        if (this.db == null) {
            this.db = this.dbOpenHelper.getWritableDatabase();
        }
    }

    public void beginTransaction() {
        if (this.db != null) {
            this.db.beginTransaction();
        }
    }

    public void setTransactionSuccessful() {
        if (this.db != null) {
            this.db.setTransactionSuccessful();
        }
    }

    public void endTransaction() {
        if (this.db != null) {
            this.db.endTransaction();
        }
    }

    public void cleanup() {
        if (this.db != null) {
            this.db.close();
            this.db = null;
        }
    }

    /**
     * True if Database can be deleted. False if not available
     *
     * @param context
     * @return
     */
    public boolean isDatabaseDelete(final Context context) {
        boolean result = false;
        if (this.db != null) {
            File file = context.getDatabasePath(dbOpenHelper.getDatabaseName());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                result = this.db.deleteDatabase(file);
            }
        }
        return result;
    }

}
