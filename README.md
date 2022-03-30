# [Cordova Volume Plugin](https://github.com/JaviCastellvi/cordova-plugin-volume)

This plugin provides a simple way to interact with the volume of your device.

* This plugin is built for `cordova@^3.6`.

* This plugin currently supports only Android.


## Plugin setup


1. `cordova plugin add cordova-plugin-volume`


## Javascript interface

    // After device ready, create a local alias
    var volume = cordova.plugins.volume;

    volume.adjustRaise(success, error);
    volume.adjustLower(success, error);
    // value should be float in range from 0 to 1.
    volume.setVolume(value, success, error);
    // success([-1,0-1]) float 0-1 is a volume level, -1 represents a system default
    volume.getVolume(success, error);
    // prevents sleep
    volume.mute4AudioSetting();

* Check [source](https://github.com/JaviCastellvi/cordova-plugin-volume/blob/master/www/volume.js) for additional configuration.


## Communication

- If you **need help**, use [Stack Overflow](http://stackoverflow.com/questions/tagged/cordova). (Tag `cordova`)
- If you'd like to **ask a general question**, use [Stack Overflow](http://stackoverflow.com/questions/tagged/cordova).
- If you **found a bug**, open an issue.
- If you **have a feature request**, open an issue.
- If you **want to contribute**, submit a pull request.


## Contributing

Patches welcome! Send a pull request. Since this is not a part of Cordova Core (which requires a CLA), this should be easier.

Please submit all pull requests the against master branch. If your pull request contains JavaScript patches or features, you should include relevant unit tests. Thanks!


## Authors

**Javi Castellvi**

+ https://github.com/JaviCastellvi


## Copyright and license

    The MIT License (MIT)

    Copyright (c) 2022 Javi Castellvi

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
