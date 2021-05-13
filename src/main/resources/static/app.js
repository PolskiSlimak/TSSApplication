var stompClient = null;

function connect() {
    var relativePath = location.pathname;
    var socket = new SockJS(relativePath + 'chat');
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
    response.innerHTML = messageOutput.toString();
}
window.addEventListener("load", connect, false);
setInterval(function(){ stompClient.send("/app/chat"); }, 5000);