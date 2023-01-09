var dorita980 = require('dorita980');

var myRobotViaLocal = new dorita980.Local('MyUsernameBlid', 'MyPassword', '192.168.1.121'); // robot IP address

myRobotViaLocal.on('connect', init);

function init () {
  myRobotViaLocal.clean()
  .then(() => myRobotViaLocal.end()) // disconnect to leave free the channel for the mobile app.
  .catch(console.log);
}