var manager, g;
        $(f_initGrid);
        function f_initGrid()
        {
        	var model="News";
        	var message="新闻";
            g = manager = $("#maingrid").ligerGrid({
                columns: [
                { display: '主键', name: 'id', width: 50, type: 'int', frozen: true },
                { display: '标题', name: 'cntitle',minWidth: 250 },
                { display: '类别', name: 'type',width:60 },
                { display: '标识', name: 'flag',width: 60 },
                { display: '评论', name: 'canComment',width: 60 },
                { display: '标签', name: 'tag',width: 60 },
                { display: '点击量', name: 'click',width: 60 },
				{ display: '时间', name: 'date',width: 120 },
                { display: '操作', isSort: false, width: 120, render: function (rowdata, rowindex, value)
                {
                	var h = "<a href='javascript:beginEdit(" + rowindex + ",\"" + model + "\",\"" + message + "\")'>修改</a> ";
 	                h+= "<a href='javascript:deleteRow(" + rowindex + ",\"" + model + "\")'>删除</a> ";
                    return h; 
                }
                }
                ],
                onSelectRow: function (rowdata, rowindex)
                {
                    $("#txtrowindex").val(rowindex);
                },
                enabledEdit: false,clickToEdit:false, isScroll: false,
                url:"manageLoadNewsList?type="+p_type+"&flag="+p_flag,	
                pageSize:10,
                width: '100%'
               
            });   
        }
		
