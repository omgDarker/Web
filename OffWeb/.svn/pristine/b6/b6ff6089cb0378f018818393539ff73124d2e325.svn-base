var eee;
        $(function ()
        {
            $.metadata.setType("attr", "validate");
            var v = $("form").validate({
                debug: false,
                errorPlacement: function (lable, element)
                {
                    if (element.hasClass("l-textarea"))
                    {
                        element.ligerTip({ content: lable.html(), target: element[0] }); 
                    }
                    else if (element.hasClass("l-text-field"))
                    {
                        element.parent().ligerTip({ content: lable.html(), target: element[0] });
                    }
                    else
                    {
                        lable.appendTo(element.parents("td:first").next("td"));
                    }
                },
                success: function (lable)
                {
                    lable.ligerHideTip();
                    lable.remove();
                }
            });
            $("form").ligerForm();
           
        });  
    	var editor;
		KindEditor.ready(function(K) {
			editor = K.create('textarea[id="elm1"]', {
				allowFileManager : false,
				uploadJson : 'fileUpload',
			});				
		});
		var editor2;
		KindEditor.ready(function(K) {
			editor2 = K.create('textarea[id="elm2"]', {
				allowFileManager : false,
				uploadJson : 'fileUpload',
			});				
		});
		var dialog;
		//事件，宽度，高度，是否为单选，html元素id，查询的code，查询的type，默认值，其他参数，回调函数，回调参数
		function loadPick(event,mywidth,myheight,radio,tag,code,type,def,params,iCallBack,iCallBackParam) { 
		    var lTop =  event.clientY;
		    var lLeft = document.documentElement.scrollLeft + event.clientX;
		    if (lLeft < 0) lLeft = 5
		    if ((lLeft + mywidth) > $(window).width()) lLeft = $(window).width() - mywidth - 20;
		    if ((lTop + myheight) > $(window).height()) lTop =  $(window).height() - myheight - 70;
		    lTop =(lTop + $(window).scrollTop()) + 'px';
		    //closeWhenEnter:true,
		     dialog= $.ligerDialog.open({ isHidden:false,id:'shop_ligerDialog', height: myheight, width: mywidth, left:lLeft, top:lTop, url: 'pick?type='+type+'&radio='+radio+'&code='+code+'&tag='+tag+'&def='+def+params+'&iCallBack='+iCallBack+'&iCallBackParam='+iCallBackParam, showMax: false, showToggle: false, showMin: false, isResize: false, modal: false, title: '选择'});
		}
		