$(document).ready(function(){
	$('#btnStart').click(startServer);
});

function startServer(){
	$.ajax({
		type : "POST",
		cache : false,
		url : "/console",
		data : {type: "command", value: "START_SERVER"},
		success : function(data) {
			if('SUCCESS' == data){
				alert('启动成功！');
			}
		}
	});
}