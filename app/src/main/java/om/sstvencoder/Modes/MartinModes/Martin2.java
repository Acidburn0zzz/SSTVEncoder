/*
Copyright 2014 Olga Miller <olga.rgb@googlemail.com>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package om.sstvencoder.Modes.MartinModes;

import android.graphics.Bitmap;

import om.sstvencoder.Modes.ModeSize;

@ModeSize(getWidth = 320, getHeight = 256)
public class Martin2 extends Martin {
    public Martin2(Bitmap bitmap) {
        super(bitmap);
        mVISCode = 40;

        mColorScanDurationMs = 73.216;
        mColorScanSamples = convertMsToSamples(mColorScanDurationMs);
    }
}
