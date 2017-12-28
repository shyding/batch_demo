webix.ready(function(){

    var urlRoot = 'http://localhost:8080';
	//var props = ['name','email','age','a','b','c','d','e','f','g'];
	var props = ['id','supplierCompany','supplierSite','supplierBankCode','supplierBankName','supplierExtend1','supplierExtend2','supplierExtend3','supplierExtend4','supplierExtend5','poNumber','poCompany','poDepartment','poPrepaymentPoNumber','poExtend1','poExtend2','poExtend3','poExtend4','poExtend5','poExtend6','poExtend7','poExtend8','poExtend9','invoiceNumber','invoiceType','invoiceAmount','invoideDateReceived','invoiceDateExpense','invoiceDateExpenseStart','invoiceDateExpensePeriod','invoiceExpenseType','invoiceFinLocation','invoiceFinCurrency','invoiceFinCurrencyPayment','invoiceBasic1','invoiceBasic2','invoiceBasic3','invoiceBasic4','invoiceBasic5','invoiceBasic6','invoiceBasic7','invoiceBasic8','invoiceBasic9']
	var items = [];
	var columns = [];

//    function getData(){
//        var url = urlRoot+ '/posts/1';
//        webix.ajax().get(url, { action:"info", id:123}, function(text, xml, xhr){
//            //response
//            var data = JSON.parse(text);
//            console.log(data);
//        });
//        //webix.ajax().post("some.php", { action:"info", id:123});
//    }
//
//    getData();
	


    //造假数据
//	for(var i=0;i<20;i++){
//		var item = {};
//		props.forEach(function(prop,j){
//			item[prop] = prop+'-'+'ABCDEFGHIJK'.substr(Math.floor(Math.random()*11),1);
//		})
//		item.id = i;
//		items[i] = item;
//	}
	
	function generateData(num){
		var startDate = new Date();
		var startMillis = startDate.getTime();
		webix.message("开始时间"+startDate.toLocaleTimeString());
		var url = urlRoot+ '/supplier/generateImport';
		webix.ajax().get(url, { number:num}, function(text, xml, xhr){
			var endDate = new Date();
			var endMillis = endDate.getTime();
			webix.message("结束时间" + endDate.toLocaleTimeString());
			//response
			var data = JSON.parse(text);
			console.log(data);
			items = data;
//			webix.message( JSON.stringify(items));
			$$("gridView").clearAll();
			$$("gridView").define('data', items);
			$$("msgLabel").define('label', "耗时" + (endMillis-startMillis)/1000 + "秒");
			$$("msgLabel").refresh();
		});
	}

	//构建列
	props.forEach(function(prop,i){
		var column = {};
		column.id = prop;
		column.header = prop;
		column.width = prop.length*7 +15;
		column.adjust = true;
		column.tooltip = prop+'1';

		if(i===props.length-1){
            column.fillspace = 1;
			//column.header = {content: 'headerMenu'};
		}
		columns[i] = column;
	});

    //界面子元素定义
    var gridView = 
    {
		id: 'gridView',
        view: 'datatable',
        columns: columns,
        data: items
    };
	var btn1 = 
	{
		view : "button",
		label : "Generate 10 Mock Data",
		click : function(){
			generateData(10);
		}

	};
    var btn2 = {
        view:"button",
        label:'Count Mock Data',
        click:function(){
    		var startDate = new Date();
    		var startMillis = startDate.getTime();
    		webix.message("开始时间"+startDate.toLocaleTimeString());
    		var url = urlRoot+ '/supplier/count';
    		webix.ajax().get(url, {}, function(text, xml, xhr){
    			var endDate = new Date();
    			var endMillis = endDate.getTime();
    			webix.message("结束时间" + endDate.toLocaleTimeString());
    			//response
    			var data = JSON.parse(text);
    			console.log(data);
    			webix.message( JSON.stringify(data));
    			$$("msgLabel").define('label', "总共" + data + "条待处理数据； " + "耗时" + (endMillis-startMillis)/1000 + "秒");
				$$("msgLabel").refresh();
    		});
    	
        }
    };
    var btn3 = {
            view:"button",
            label:'Clear Mock Data',
            type:"danger",
            css:"dangerousButtonClass",
            click:function(){
        		var startDate = new Date();
        		var startMillis = startDate.getTime();
        		webix.message("开始时间"+startDate.toLocaleTimeString());
        		var url = urlRoot+ '/supplier/clean';
        		webix.ajax().get(url, {}, function(text, xml, xhr){
        			var endDate = new Date();
        			var endMillis = endDate.getTime();
        			webix.message("结束时间" + endDate.toLocaleTimeString());
        			//response
        			var data = JSON.parse(text);
        			console.log(data);
        			webix.message( JSON.stringify(data));
        			$$("msgLabel").define('label', "总共" + data + "条数据被删除； " + "耗时" + (endMillis-startMillis)/1000 + "秒");
    				$$("msgLabel").refresh();
        		});
        	
            }
        };
    var label = {
        id:'msgLabel',
    	view:'label',
        label:'xxxxxxxxx'
    };
	var btn4 = 
	{
		view : "button",
		label : "Generate 100 Mock Data",
		click : function(){
			generateData(100);
		}
	};
	var btn5 = 
	{   view:"button", 
		label:"Process Supplier Invoice", 
		click:function(){
			var startDate = new Date();
			var startMillis = startDate.getTime();
			webix.message("开始时间"+startDate.toLocaleTimeString());
			var url = urlRoot+ '/apw/invoice2certif';
			webix.ajax().get(url, { number:0}, function(text, xml, xhr){
				var endDate = new Date();
				var endMillis = endDate.getTime();
				webix.message("结束时间" + endDate.toLocaleTimeString());
				webix.message("耗时" + (endMillis-startMillis)/1000 + "秒");
				//response
				var data = JSON.parse(text);
				console.log(data);
				items = data;
//				webix.message( JSON.stringify(items));
				$$("gridView").clearAll();
				$$("gridView").define('data', items);
				$$("msgLabel").define('label', "处理" + items.length + "条数据； " + "耗时" + (endMillis-startMillis)/1000 + "秒");
				$$("msgLabel").refresh();
			});
		}
	};
	var btn6 = 
	{   view:"button", 
			label:"Batch Process Supplier Invoice", 
			click:function(){
				var startDate = new Date();
				var startMillis = startDate.getTime();
				webix.message("开始时间"+startDate.toLocaleTimeString());
				var url = urlRoot+ '/apw/invoice2certif/batch';
				webix.ajax().get(url, { number:0}, function(text, xml, xhr){
					var endDate = new Date();
					var endMillis = endDate.getTime();
					webix.message("结束时间" + endDate.toLocaleTimeString());
					webix.message("耗时" + (endMillis-startMillis)/1000 + "秒");
					//response
					var data = JSON.parse(text);
					console.log(data);
					items = data;
//					webix.message( JSON.stringify(items));
					$$("gridView").clearAll();
					$$("gridView").define('data', items);
					$$("msgLabel").define('label', "处理" + items.length + "条数据； " + "耗时" + (endMillis-startMillis)/1000 + "秒");
					$$("msgLabel").refresh();
				});
			}
		};

	//界面布局
	table = webix.ui({
		//container: 'testA',
        autoheight:true,
        rows:[
            {
                cols:[btn1,btn2,btn3]
            },{
                cols:[btn4,btn5,btn6]
            },
            {
                id:'layout2',
                rows:[label]
            },{
                id:"scrollview",
                autoheight:true,
                rows:[{id:'spacer'}]
            }
        ]
	});

    //动态渲染表格
    setTimeout(function(){
        $$('scrollview').addView(gridView,0);
        $$('scrollview').removeView('spacer');
        //table.resizeChildren();
    },0);
	
});

