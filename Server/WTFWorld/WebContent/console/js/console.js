var isServerRunning = false;

$(document).ready(function(){
	$('#btnStart').click(startServer);
	$('#btnStop').click(stopServer);
	queryServerIsRunning();
});

function startServer(){
	$('#btnStart').val('启动中');
	$('#btnStart').attr('disabled', 'disabled');
	$.ajax({
		type : "POST",
		cache : false,
		url : "/console/ConsoleController",
		data : {type: "command", value: "START_SERVER"},
		success : function(data) {
			if('SUCCESS' == data){
				isServerRunning = true;
				$('#btnStart').val('启动');
				$('#btnStart').attr('disabled', 'disabled');
				$('#btnStop').removeAttr('disabled');
			}
		}
	});
}

function stopServer(){
	$('#btnStop').val('停止中');
	$('#btnStop').attr('disabled', 'disabled');
	$.ajax({
		type : "POST",
		cache : false,
		url : "/console/ConsoleController",
		data : {type: "command", value: "STOP_SERVER"},
		success : function(data) {
			if('SUCCESS' == data){
				isServerRunning = true;
				$('#btnStop').val('停止');
				$('#btnStop').attr('disabled', 'disabled');
				$('#btnStart').removeAttr('disabled');
			}
		}
	});
}

function queryServerIsRunning(){
	$.ajax({
		type : "POST",
		cache : false,
		url : "/console/ConsoleController",
		data : {type: "query", value: "IS_SERVER_RUNNING"},
		success : function(data) {
			if('true' == data){
				isServerRunning = true;
				$('#btnStart').attr('disabled', 'disabled');
				$('#btnStop').removeAttr('disabled');
			}else if('false' == data){
				isServerRunning = false;
				$('#btnStop').attr('disabled', 'disabled');
				$('#btnStart').removeAttr('disabled');
			}
		}
	});
}