var exec = require('cordova/exec');

/**
 * Helpers
 */
function isString(value) {
    return (typeof value == 'string' || value instanceof String);
}

function isInt(value) {
    return !isNaN(parseInt(value, 10)) && (parseFloat(value, 10) == parseInt(value, 10));
}

/**
 * Constructor
 */
function EstimoteBeacons() {
}

EstimoteBeacons.prototype.startRangingBeaconsInRegion = function (successCallback) {
    if (typeof successCallback !== "function") {
        console.error("EstimoteBeacons.startRangingBeaconsInRegion failure: success callback parameter must be a function");
        return;
    }

    exec(successCallback,
        function () {
        },
        "EstimoteBeacons",
        "startRangingBeaconsInRegion",
        []
    );
};


EstimoteBeacons.prototype.getBeacons = function (successCallback) {
    if (typeof successCallback !== "function") {
        console.error("EstimoteBeacons.getBeacons failure: success callback parameter must be a function");
        return;
    }

    exec(successCallback,
        function () {
        },
        "EstimoteBeacons",
        "getBeacons",
        []
    );
};

var estimoteBeacons = new EstimoteBeacons();
module.exports = estimoteBeacons;