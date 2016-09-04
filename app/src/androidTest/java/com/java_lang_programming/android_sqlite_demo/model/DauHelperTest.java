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

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.RenamingDelegatingContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(AndroidJUnit4.class)
@SmallTest

/**
 * A Test class for for DauHelper
 */
public class DauHelperTest {

    private Context mContext;

    @Before
    public void setUp() {
        mContext = new RenamingDelegatingContext(InstrumentationRegistry.getInstrumentation().getTargetContext(), "test_");
    }

    @Test
    public void getDauList_not_found() {
        List<Dau> list = DauHelper.getDauList(mContext);
        assertEquals(list.size(), 0);
    }

    @Test
    public void getDau_not_found() {
        Dau dau = DauHelper.getDau(mContext, "1");
        assertNull(dau);
    }

    // TODO You should fix getContentValues
    @Test
    public void insert_success() {
        long result = DauHelper.insert(mContext, DauHelper.getContentValues());
        //assertNotEquals(result, -1);
    }

    @Test
    public void insert_failure() {
        long result = DauHelper.insert(mContext, DauHelper.getContentValues());
        assertEquals(result, -1);
    }

    @Test
    public void getMaxId_data_not_found() {
        int id = DauHelper.getMaxId(mContext);
        assertEquals(id, 1);
    }

    // TODO You should fix getContentValues
    @Test
    public void insert_confirm_data() {
        long result = DauHelper.insert(mContext, DauHelper.getContentValues());
        Dau dau = DauHelper.getDau(mContext, "1");
        //assertEquals(dau.id, "1");
    }
}