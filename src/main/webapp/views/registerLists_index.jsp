<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - 数据表格</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="../static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../static/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <!-- Data Tables -->
    <link href="../static/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link href="../static/css/animate.css" rel="stylesheet">
    <link href="../static/css/style.css?v=4.1.0" rel="stylesheet">
	<style>
		.float-e-margins .btn {margin-bottom: 0px;}		
		.tableBtn{float:left;width:30%;margin-top:0px;margin-left:5px;padding:2px 8px;}
	</style>
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>我的挂号单<small>列表</small></h5>
                        <div class="ibox-tools">
                        </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-striped table-bordered table-hover dataTables-example">
                            <thead>
                                <tr>
                                    <th>挂号单ID</th>
                                    <th>预约人姓名</th>
                                    <th>挂号科室</th>
                                    <th>挂号医生</th>
                                    <th>挂号单状态</th>
                                    <th>预约时间</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody id="deptList">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 全局js -->
    <script src="../static/js/jquery.min.js?v=2.1.4"></script>
    <script src="../static/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="../static/js/plugins/jeditable/jquery.jeditable.js"></script>
    <!-- Data Tables -->
    <script src="../static/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="../static/js/plugins/dataTables/dataTables.bootstrap.js"></script>
    <!-- 自定义js -->
    <script src="../static/js/content.js?v=1.0.0"></script>
	<script src="../static/layer/layer.js"></script>
	<script type="text/javascript" src="../static/js/jquery.cookie.js"></script>
    <!-- Page-Level Scripts -->
    <script>
        $(document).ready(function () {
         	var userId = $.cookie('username');
        	$.ajax({
        		url: '../getOrderListByUserId.do',
        		type: 'POST',
        		data:{'userId':userId},
        		dataType: 'JSON',
        		success: function(res){
        			var data = res;
        			//然后 DataTables 这样初始化：
                    $('.dataTables-example').DataTable( {
                        data: data,
                        columns: [
                            { data: 'orderId' },
                            { data: 'wName' },
                            { data: 'doctorName' },
                            { data: 'deptName' },
                            { data: 'wStatus',render:function(data,type,row){
                                if(data == 1){
                                    return "<button class='btn btn-success'>正常</a>";
                                }else{
                                    return "<button class='btn btn-danger'>取消</a>";
                                }
                        	} },
                            {
                                data: function (obj) {
                                    return getTime(obj.registerTime);
                                }
                            },
                            { data: null}
                        ],
                        columnDefs:[{
                            targets: 6,
                            render: function (data, type, row, meta) {
                            	if(row.wStatus == 1){
                            		return '<a type="button" class="btn btn-info" href="#" onclick=changeghStatus(' + row.orderId + ') >预约 </a>';
                            	}else{
                            		return '<a type="button" class="btn btn-danger" href="#" disabled>取消预约 </a>';
                            	}
                            	
                                
                            }
                        },
                            { "orderable": false, "targets": 4 },
                        ],
                    } );
        		},
        		error: function(res){
        			layer.msg('加载失败');
        		}
        	});
        });
        function changeghStatus(id){
            	layer.confirm('确认取消预约？', {
          		  btn: ['确定','取消'] //按钮
          		}, function(){
          			$.ajax({
                  		url: '../updateghStatus.do',
                  		type: 'POST',
                  		data: {
                  			'registerId':id
                  		},
                  		dataType: 'JSON',
                  		success: function(result){
                  			if(result=="success"){
                  				layer.alert('修改成功',function(index){
                  					layer.close(index);
                  					reload();
                  				});
                  			}
                  		},
                  		error: function(result){
                  			layer.msg('修改失败');
                  		}
                  	});
          		}, function(){
          	});
        }
        //重新加载
        function reload(){
        	window.location.reload();
        }
        function getTime(time) {
            if (typeof (time) == "undefined") {
                return "";
            }
            var oDate = new Date(time),
                oYear = oDate.getFullYear(),
                oMonth = oDate.getMonth() + 1,
                oDay = oDate.getDate(),
                oHour = oDate.getHours(),
                oMin = oDate.getMinutes(),
                oSen = oDate.getSeconds(),
                oTime = oYear + '-' + getzf(oMonth) + '-' + getzf(oDay) + '-' + ' ' + getzf(oHour) + ':' + getzf(oMin) + ':' + getzf(oSen)
            ;
            return oTime;
        }

        //补0操作,当时间数据小于10的时候，给该数据前面加一个0
        function getzf(num) {
            if (parseInt(num) < 10) {
                num = '0' + num;
            }
            return num;
        }
    </script>

</body>

</html>
