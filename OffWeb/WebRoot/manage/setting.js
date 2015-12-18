var manager, g;
        $(f_initGrid);
        function f_initGrid()
        {
        	var model="Setting";
        	var message="系统参数";
            g = manager = $("#maingrid").ligerGrid({
                columns: [
                { display: '主键', name: 'id', width: 50, type: 'int', frozen: true },
                { display: 'KEY', name: 'key',width: 160 },
                { display: '备注', name: 'remark',minWidth: 260 },
                { display: 'KEY值', name: 'value',width: 160 },
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
                url:"manageLoadSettingList",	
                pageSize:10,
                width: '100%'
               
            });   
        }
