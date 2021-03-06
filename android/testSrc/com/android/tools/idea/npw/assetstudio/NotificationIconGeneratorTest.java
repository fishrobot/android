/*
 * Copyright (C) 2017 The Android Open Source Project
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
package com.android.tools.idea.npw.assetstudio;

import com.android.tools.idea.npw.assetstudio.NotificationIconGenerator.NotificationOptions;
import com.intellij.openapi.util.Disposer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class NotificationIconGeneratorTest {

  private static void checkGraphic(String baseName, int minSdk, String folderName, int expectedCount) throws IOException {
    NotificationOptions options = new NotificationOptions();

    NotificationIconGenerator generator = new NotificationIconGenerator(minSdk);
    BitmapGeneratorTests.checkGraphic(expectedCount, folderName, baseName, generator, options);
    Disposer.dispose(generator);
  }

  @SuppressWarnings("SameParameterValue")
  private static void checkGraphic(String baseName) throws IOException {
    checkGraphic(baseName, 1, "notification", 12);
  }

  @Test
  public void testNotification1() throws Exception {
    checkGraphic("ic_stat_1");
  }

  @Test
  public void testNotification2() throws Exception {
    checkGraphic("ic_stat_1", 9 /* minSdk */, "notification-v9+", 8 /* fileCount */);
  }

  @Test
  public void testNotification3() throws Exception {
    checkGraphic("ic_stat_1", 11, "notification-v11+", 4);
  }
}
