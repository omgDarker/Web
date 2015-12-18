var manager, g;
        $(f_initGrid);
        function f_initGrid()
        {
        	var model="Staticdata";
        	var message="Staticdata";
            g = manager = $("#maingrid").ligerGrid({
                columns: [
                { display: '主键', name: 'id', width: 50, type: 'int', frozen: true },
                { display: '类型', name: 'type',minWidth: 80 },
                { display: 'Fcode', name: 'pcode',width: 80 },
                { display: 'Code', name: 'code',width: 80 },
                { display: '名称', name: 'name',width: 100 },
                { display: '英文名称', name: 'enName',width: 100 },
                { display: '值', name: 'value',width: 60 },
                { display: '排序', name: 'order',width: 120 },
                { display: '操作', isSort: false, width: 200, render: function (rowdata, rowindex, value)
                {
                	var h = "<a href='javascript:beginEdit(" + rowindex + ",\"" + model + "\",\"" + message + "\")'>修改</a> ";
 	                h+= "<a href='javascript:deleteRow(" + rowindex + ",\"" + model + "\")'>删除</a> ";
	                h+= "<a href='javascript:f_addTab(" + rowindex + ")'>查看子元素</a> ";
                    return h; 
                }
                },
                { display: '描述', name: 'description',width: 400 }
                ],
                onSelectRow: function (rowdata, rowindex)
                {
                    $("#txtrowindex").val(rowindex);
                },
                enabledEdit: false,clickToEdit:false, isScroll: false,
                url:"manageLoadStaticdataList?spcode="+p_pcode,	
                pageSize:10,
                width: '100%'
               
            });   
        }
        function f_addTab(rowid)
        { 
        	var code= manager.getRow(rowid).code;
        	$.ligerDialog.open({ height: 400, url: 'manageStaticdataList?spcode='+code, width: 900, showMax: true, showToggle: true, showMin: true, isResize: true, modal: false, title: "主键Key："+code});
         } 
