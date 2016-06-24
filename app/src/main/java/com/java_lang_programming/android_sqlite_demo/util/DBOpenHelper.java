/**
 * Copyright (C) 2016 Programming Java Android Development Project
 * Programming Java is
 *
 *      http://java-lang-programming.com/
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

package com.java_lang_programming.android_sqlite_demo.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by msuzuki on 2016/06/24.
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    public Context m_context;
    public static final String TAG = "DBOpenHelper";
    public static final String DB_NAME = "android_sqlite_demo";
    public static final int DB_VERSION = 1;

    public DBOpenHelper(final Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.m_context = context;
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {
        Log.d(TAG, "onCreate version : " + db.getVersion());
        this.execFileSQL(db, "create_table.sql");
    }

    @Override
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
        Log.d(TAG, "onUpgrade version : " + db.getVersion());
        Log.d(TAG, "onUpgrade oldVersion : " + oldVersion);
        Log.d(TAG, "onUpgrade newVersion : " + newVersion);
        // 1 → 2
        if (oldVersion == 1 && newVersion == 2) {
            this.execFileSQL(db, "change_table_1.0.3.sql"); // v1.0.0
        }

        if (oldVersion == 1 && newVersion == 3) {
            this.execFileSQL(db, "change_table_1.0.3.sql"); // v1.0.0
            this.execFileSQL(db, "create_table_1.2.0.sql"); // v1.0.0
        }

        if (oldVersion == 2 && newVersion == 3) {
            this.execFileSQL(db, "create_table_1.2.0.sql"); // v1.0.0
        }
    }

    /**
     * assetsフォルダのSQLファイルを実行する
     * @param db
     * @param fileName
     */
    private void execFileSQL(SQLiteDatabase db, String fileName){
        InputStream in = null;
        InputStreamReader inReader = null;
        BufferedReader reader = null;
        try {
            // 文字コード(UTF-8)を指定して、ファイルを読み込み
            in = m_context.getAssets().open(fileName);
            inReader = new InputStreamReader(in, "UTF-8");
            reader = new BufferedReader(inReader);

            // ファイル内の全ての行を処理
            String s;
            while((s = reader.readLine()) != null){
                // 先頭と末尾の空白除去
                s = s.trim();

                // 文字が存在する場合（空白行は処理しない）
                if (0 < s.length()){
                    // SQL実行
                    db.execSQL(s);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inReader != null) {
                try {
                    inReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * insertを実行します
     * @param context
     * @param cvList
     * @return
     */
    public static boolean insertTransactionExcute(final Context context, final String tableName,
                                                  ArrayList<ContentValues> cvList) {

        // テーブルデータ削除
        DBHelper dbhelper = null;
        try {
            dbhelper = new DBHelper(context);
            // トランザクション開始
            dbhelper.db.beginTransaction();

            long result = -1;
            for (ContentValues cv : cvList) {
                result = dbhelper.db.insert(tableName, null, cv);
                if (result == -1) {
                    return false;
                }
            }

            // コミット
            dbhelper.db.setTransactionSuccessful();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {

            if (dbhelper != null) {
                dbhelper.cleanup();
            }
        }

        return true;
    }
}
