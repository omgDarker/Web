var manager, g;
        $(f_initGrid);
        function f_initGrid()
        {
        	var model="User";
        	var message="用户";
            g = manager = $("#maingrid").ligerGrid({
                columns: [
                { display: '用户id', name: 'id', width: 50, type: 'int', frozen: true },
                { display: '用户名', name: 'name',width: 90 },
                { display: '性别', name: 'sex',width:60 },
                { display: '邮箱', name: 'email',width: 160 },
                { display: '电话', name: 'phone',width: 100 },
                { display: 'QQ', name: 'qq',width: 100 },
                { display: '积分', name: 'bounds',width: 80 },
                { display: '等级', name: 'grade',width: 80 },
                { display: '插入时间',name:'formatStrTime',width: 100},
                { display: '标志位', name: 'flag',width: 80 },
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
                url:"manageLoadUserList?p_type="+p_type,	
                pageSize:10,
                width: '100%'
            });   
        }
	