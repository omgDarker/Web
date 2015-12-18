
		function getSelected()
        { 
            var row = manager.getSelectedRow();
            if (!row) { alert('请选择行'); return; }
            alert(JSON.stringify(row));
        }

        function getData()
        { 
            var data = manager.getData();
            alert(JSON.stringify(data));
        } 
        var tip;
        function showtip(state){
        if(state==1||state=='true'||state=='success'){
        	tip = $.ligerDialog.tip({  title: '提示信息',content:'操作成功!' });
        	setTimeout(function () { tip.close(); }, 2000);
        }
        else {
        	tip = $.ligerDialog.tip({  title: '提示信息',content:'抱歉，操作失败。'+state});
        	setTimeout(function () { tip.close(); }, 5000);
        }
        
        }
        function beginEdit(rowid,model,message) { 
			var did = manager.getRow(rowid).id;
            $.ligerDialog.open({ height: 400, url: 'manageFind'+model+'ById?id='+did, width: 900, showMax: true, showToggle: true, showMin: true, isResize: true, modal: false, title: '修改'+message});
        }
        function deleteRow(rowid,model)
        {
            if (confirm('确定删除?'))
            {
               
                var did = manager.getRow(rowid).id;
                
                $.post('manageDelete'+model,{id:did},function(data,status){
                if(data=='1'||data=='true'||data=='success'){
                showtip(1);
                	manager.deleteRow(rowid);
                }
                else showtip(data);
                });
                
            }
        }
        function addNewRow(model)
        {
            $.ligerDialog.open({ height: 400, url: 'manageFind'+model+'ById', width: 900, showMax: true, showToggle: true, showMin: true, isResize: true, modal: false, title: '添加'+model});
        } 