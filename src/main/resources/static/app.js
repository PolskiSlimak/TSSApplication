var stompClient = null;

function connect() {
    var relativePath = location.pathname;
    var socket = new SockJS(relativePath + 'time');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/messages', function(messageOutput) {
            showMessageOutput(messageOutput.body);
        });
    });
}
function showMessageOutput(messageOutput) {
    var response = document.getElementById('response');
    var text = "Current time: " + messageOutput.toString();
    response.innerHTML = text;
}
window.addEventListener("load", connect, false);
setInterval(function(){ stompClient.send("/app/time"); }, 1000);