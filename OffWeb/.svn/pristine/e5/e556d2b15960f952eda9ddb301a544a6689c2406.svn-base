var manager, g;
        $(f_initGrid);
        function f_initGrid()
        {
        	var model="Comment";
        	var message="评论";
            g = manager = $("#maingrid").ligerGrid({
                columns: [
                { display: '评论id', name: 'id', width: 50, type: 'int', frozen: true },
                { display: '新闻标题', name: 'news.title',width: 160 },
                { display: '评论人', name: 'user.name',width:100 },
                { display: '内容', name: 'content',minWidth: 100 },
                { display: '总赞数',name:'praise',width:100},
                { display: '插入时间',name:'formatStrTime',width: 100},
                { display: '标志位', name: 'flag',width: 80 },
                { display: '操作', isSort: false, width: 120, render: function (rowdata, rowindex, value)
                {
                	 var h = "<a href='javascript:beginEdit(" + rowindex + ",\"" + model + "\",\"" + message + "\")'>修改</a> ";
  	                     h+= "<a href='javascript:deleteRow(" + rowindex + ",\"" + model + "\")'>删除</a> ";
  	                     h+= "<a href='javascript:f_addTab(" + rowindex + ")'>查看回复</a> ";
                    return h; 
                }
                }
                ],
                onSelectRow: function (rowdata, rowindex)
                {
                    $("#txtrowindex").val(rowindex);
                },
                enabledEdit: false,clickToEdit:false, isScroll: false,
                url:"manageLoadCommentList?cId="+cId,	
                pageSize:10,
                width: '100%'
            });   
        }
        function f_addTab(rowid)
        { 
        	var code= manager.getRow(rowid).id;
        	$.ligerDialog.open({ height: 400, url: 'manageCommentList?cId='+code, width: 900, showMax: true, showToggle: true, showMin: true, isResize: true, modal: false, title: "评论的id："+code});
         } 