var stompClient = null;
var chart = null;
function connect() {
    var relativePath = location.pathname;
    var socket = new SockJS(relativePath + 'time');
    chart = new Chart(document.getElementById("chart"), {
        type: 'bar',
        data: {
            labels: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15],
            datasets: [{
                backgroundColor: '#bc4555',
                label: 'Numbers',
                data: [1],
            }]
        },
    });
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        stompClient.subscribe('/topic/messages', function(messageOutput) {
            updateChart(messageOutput.body);
        });
    });
}
function updateChart(chartData) {
    var splitter = chartData.split(",");
    splitter[0] = 2;
    splitter[14] = 7;
    var x = [];
    for (var i = 0; i < 15; i++) {
        x[i] = parseInt(splitter[i]);
    }
    chart.data.datasets[0].data = x;
    chart.update();
}
window.addEventListener("load", connect, false);
setInterval(function(){ stompClient.send("/app/time"); }, 5000);