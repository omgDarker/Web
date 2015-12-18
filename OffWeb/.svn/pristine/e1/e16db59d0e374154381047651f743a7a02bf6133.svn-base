var manager, g;
        $(f_initGrid);
        function f_initGrid()
        {
        	var model="Hotword";
        	var message="热词";
            g = manager = $("#maingrid").ligerGrid({
                columns: [
                { display: '主键', name: 'id', width: 50, type: 'int', frozen: true },
                { display: '标题', name: 'name',minWidth: 400 },
                { display: '标识', name: 'flag',width: 60 },
                { display: '搜索次数', name: 'searchTimes',width: 100 },
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
                url:"manageLoadHotwordList?flag="+p_flag,	
                pageSize:10,
                width: '100%'
               
            });   
        }
		
         
       
       