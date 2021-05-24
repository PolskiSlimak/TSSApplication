var stompClient = null;
var chart = null;
function connect() {
    createChart();
    var relativePath = location.pathname;
    var socket = new SockJS(relativePath + 'chart');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function() {
        stompClient.subscribe('/topic/messages', function(messageOutput) {
            updateChart(JSON.parse(messageOutput.body));
        });
    });
}
function createChart() {
    chart = new Chart(document.getElementById("chart"), {
        type: 'bar',
        data: {
            labels: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15],
            datasets: [{
                backgroundColor: '#bc4555',
                label: 'Numbers',
                data: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15],
            }]
        },
    });
}
function updateChart(chartReceived) {
    var chartData = chart.data;
    var chartDataSet = chartData.datasets[0];
    chartDataSet.data = chartReceived.numbers;
    chart.update();
}
function showFormForEdit(id) {
    var formStyle = document.getElementById("edit-form").style.display;
    if (formStyle === "none") {
        setFormData(id);
    } else if (formStyle === "inline-block") {
        document.getElementById("edit-form").style.display = "none";
    }

}
function setFormData(id) {
    var url = location.href;
    var xhr = new XMLHttpRequest();
    xhr.open('get', url +'employee/' + id);
    xhr.send();
    xhr.onload = function() {
        var employee = JSON.parse(xhr.response);
        document.getElementById("edit-form").style.display = "inline-block";
        document.getElementById("employeeId").value = employee.employeeId;
        document.getElementById("firstName-edit").value = employee.firstName;
        document.getElementById("lastName-edit").value = employee.lastName;
        document.getElementById("hireDate-edit").value = employee.hireDate;
        document.getElementById("department").value = employee.department;
        document.getElementById("job").value = employee.job;
    };
}
window.addEventListener("load", connect, false);
setInterval(function(){ stompClient.send("/app/chart"); }, 5000);