	$(document).ready(function() {
//		 $( "#dialog" ).dialog('close');
//		 
//		    $( "#opener" ).click(function() {
//		      $( "#dialog" ).dialog( "open" );
//		    });
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		var jobNum = "22";
		var calendar = $('#calendar').fullCalendar({
			header: {
				left: 'prev,next, today',
				center: 'title'
				,
				right: ''
			},
			buttonText:{
				prev:     '<<',
				next:     '>>',
				prevYear: '上一年',
				nextYear: '下一年',
				today:    '今天',
				month:    '月'
// 				,
// 				week:     '周',
// 				day:      '日'
				},
			monthNames:['一月','二月', '三月', '四月', '五月', '六月', '七月',
						'八月', '九月', '十月', '十一月', '十二月'],
//			selectable: true,
//			selectHelper: true,
//			select: function(start, end, allDay) {
//				var title = prompt('Event Title:');
//				if (title) {
//					calendar.fullCalendar('renderEvent',
//						{
//							title: title,
//							start: start,
//							end: end,
//							allDay: allDay
//						},
//						true // make the event "stick"
//					);
//				}
//				calendar.fullCalendar('unselect');
//			},
			editable: true,
			firstDay:1,
			weekMode:'fixed',
//			theme:true,
//			events: "/calendar/calendar/get.html"
		    events:  
//		    	"http://192.168.26.105:8090/jwgl/kebiao/banjiKebiao",
		    	function(start, end , callback){//生成日历
		          //alert(calendar.fullCalendar('getDate'));
		        var events = [];
		        $.ajax({
		            'url':"kebiao/banjiXueqiKebiao",
		            'data': {                
		                start:$.fullCalendar.formatDate(start,"yyyy-MM-dd HH:mm:ss"),
		                end:$.fullCalendar.formatDate(end,"yyyy-MM-dd HH:mm:ss"),
		                jobNum:jobNum
		            },
		            'dataType': 'json',
		            'type': 'post',
		            'error': function(data){
		                alert("初始化失败");
		                 return false;
		             },
		            'success': function(doc) {
		                $(doc).each(function(i) {
		                    if(doc[i].type == '1'){
		                    	events.push({
			                        id: doc[i].id,
			                        title: doc[i].title,
			                        start: new Date(doc[i].start),
			                        end: new Date(doc[i].end)
			                    });  
		                    }else if(doc[i].type == '2'){
		                    	events.push({
			                        id: doc[i].id,
			                        title: doc[i].title,
			                        start: new Date(doc[i].start),
			                        end: new Date(doc[i].end),
			                        backgroundColor:'#eb8686',
			                        editable:false,
			                        allDay: false
			                    }); 
		                    }
		                });
		                callback(events);//
		            }
		        });                        
		      },
		      dayClick: function(date, allDay, jsEvent, view) {// 单机日历内空白 新增事件
		    	  $("#jobNum").val("22");
		    	  $("#startTime").val(date);
		    	  $("#endTime").val(date);
		    	  $("#title").val("");
		    	  $( "#dialog" ).dialog({
	                    autoOpen: false,
	                    height: 300,
	                    width: 450,
	                    title: '新增事件', // 此处声明title，会将reservebox中的title属性覆盖
	                    modal: true,
	                    position: "center",
	                    draggable: true// 可拖拽
	                });
	                $( "#dialog" ).dialog( "open" );
	            return false;

	      }
		      ,
	      eventClick: function(calEvent, jsEvent, view) {
	    	  $("#jobNum").val("22");
	    	  $("#id").val(calEvent.id);
	    	  $("#startTime").val(calEvent.start);
	    	  if(calEvent.end != null && calEvent.end != ""){
	    		  alert("aaa");
	    		  $("#endTime").val(calEvent.end);
	    	  }
	    	  $("#title").val(calEvent.title);
	    	  $( "#dialog" ).dialog({
                    autoOpen: false,
                    height: 300,
                    width: 450,
                    title: '修改事件', // 此处声明title，会将reservebox中的title属性覆盖
                    modal: true,
                    position: "center",
                    draggable: true// 可拖拽
                });
                $( "#dialog" ).dialog( "open" );
	    	  },
	    	  eventMouseover: function(calEvent, jsEvent, view) {
					var fstart  = $.fullCalendar.formatDate(calEvent.start, "yyyy/MM/dd HH:mm");
					var fend  = $.fullCalendar.formatDate(calEvent.end, "HH:mm");	
					$(this).attr('title', fstart + " - " + fend + " " + calEvent.title);
					$(this).css('font-weight', 'normal');				
//					$(this).tooltip({
//						effect:'toggle',
//						cancelDefault: true
//					});
			  },
			  eventMouseout: function(calEvent, jsEvent, view) {
					$(this).css('font-weight', 'normal');
			  },

	      
		});
	   
	});
	
function saveEvent(){
	var id = $.trim($("#id").val());
	if($.trim($("#title").val()) == null || $.trim($("#title").val()) == ""){
		alert('请输入内容');
		return false;
	}
	if(id != null && id != ""){
		var options = { 
				url : '/calendar/calendar/modify',
				type : "POST",//提交方式 
				success : function(result) {//调用Action后返回过来的数据 
					  if(result == 1){
						  $("#dialog").dialog('close');
						  try {
							  $('#calendar').fullCalendar( 'refetchEvents' );
						  } catch (e) {
							  // TODO: handle exception
						  }finally{
						  }
				  }
				  else{
					  alert("修改事件失败");
				  }
				} 
			}; 
			$("#ff").ajaxSubmit(options);//绑定页面中form表单的id
	}
	else{
		var options = { 
				url : '/calendar/calendar/add',
				type : "POST",//提交方式 
				success : function(result) {//调用Action后返回过来的数据 
					  if(result == 1){
						  $("#dialog").dialog('close');
//						$('#classroomForm').form('clear');
						  try {
							  $('#calendar').fullCalendar( 'refetchEvents' );
						  } catch (e) {
							  // TODO: handle exception
						  }finally{
						  }
				  }
				  else{
					  alert("添加事件失败");
				  }
				} 
			}; 
			$("#ff").ajaxSubmit(options);//绑定页面中form表单的id
	}

}

