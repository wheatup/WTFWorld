wh.Server.address = 'ws://localhost:8080/server';
//wh.Server.connect();
wh.Event.bind('$OPEN', function(){
   wh.Server.send('$MESSAGE', {'text': 'haha'});
});

wh.Event.bind('$MESSAGE', function(data){
   console.log('收到消息：');
   console.log(data);
});
