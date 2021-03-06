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

package om.sstvencoder.ImageFormats;

import android.graphics.Bitmap;

public class YUY2 extends Yuv {
    public YUY2(Bitmap bitmap, int format) {
        super(bitmap, format);
    }

    protected void convertBitmapToYuv(Bitmap bitmap) {
        mYuv = new byte[2 * mWidth * mHeight];

        for (int pos = 0, h = 0; h < mHeight; ++h) {
            for (int w = 0; w < mWidth; w += 2) {
                mYuv[pos++] = (byte) convertToY(bitmap.getPixel(w, h));
                int u0 = convertToU(bitmap.getPixel(w, h));
                int u1 = convertToU(bitmap.getPixel(w + 1, h));
                mYuv[pos++] = (byte) ((u0 + u1) / 2);
                mYuv[pos++] = (byte) convertToY(bitmap.getPixel(w + 1, h));
                int v0 = convertToV(bitmap.getPixel(w, h));
                int v1 = convertToV(bitmap.getPixel(w + 1, h));
                mYuv[pos++] = (byte) ((v0 + v1) / 2);
            }
        }
    }

    public int getY(int x, int y) {
        return 255 & mYuv[2 * mWidth * y + 2 * x];
    }

    public int getU(int x, int y) {
        return 255 & mYuv[2 * mWidth * y + (((x & ~1) << 1) | 1)];
    }

    public int getV(int x, int y) {
        return 255 & mYuv[2 * mWidth * y + ((x << 1) | 3)];
    }
}
