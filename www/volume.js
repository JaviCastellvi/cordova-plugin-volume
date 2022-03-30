var exec = require('cordova/exec');

exports.adjustRaise = function( success, error) {
  exec(success, error, 'Volume', 'adjustRaise', []);
};

exports.adjustLower = function( success, error) {
  exec(success, error, 'Volume', 'adjustLower', []);
};

exports.getVolume = function( success, error) {
  exec(success, error, 'Volume', 'getVolume', []);
};

exports.setVolume= function(value, success, error) {
    exec(success, error, 'Volume', 'setVolume', [value]);
};

exports.mute4AudioSetting = function( success, error) {
  exec(success, error, 'Volume', 'mute4AudioSetting', []);
};

