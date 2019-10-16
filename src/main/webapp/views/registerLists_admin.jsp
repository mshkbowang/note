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
                                    <th>预约人住址</th>
                                    <th>联系方式</th>
                                    <th>挂号科室</th>
                                    <th>挂号医生</th>
                                    <th>挂号单状态</th>
                                    <th>预约时间</th>
                                    <th>挂号时间</th>
                                </tr>
                            </thead>
                            <tbody id="orderList">
                            
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

    <!-- Page-Level Scripts -->
    <script>
        $(document).ready(function () {
            //获取医生相关信息
        $.ajax({
            url: '../getAllOrderList.do',
            type: 'POST',
            dataType: 'JSON',
            success: function (doctList) {
                $('#doctor').html(doctList.length);
                for (var i = 0; i < doctList.length; i++) {
                    $('#doctorList').append("<li><span class='docLi' onclick='showDoctor(" + doctList[i].doctorId + ")'>" + doctList[i].doctorName + "</span></li>");
                }
                $('.dataTables-example').DataTable({
                    data: doctList,
                    columns: [
                        {data: 'orderId'},
                        {data: 'wName'},
                        {data: 'address'},
                        {data: 'tel'},
                        {data: 'deptName'},
                        {data: 'doctorName'},

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
                        {
                            data: function (obj) {
                                return getTime(obj.createTime);
                            }
                        }
                    ]
                })
                ;
                return;
            },
            error: function (docList) {
                layer.msg('加载失败');
            }
        });
        //获取科室相关信息
        $.ajax({
            url: '../getDeptList.do',
            type: 'POST',
            dataType: 'JSON',
            success: function (deptList) {
                $('#category').html(deptList.length);
            },
            error: function (deptList) {
                layer.msg('加载失败');
            }
        });
        });
        //重新加载
        function reload() {
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
