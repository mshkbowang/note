<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="../static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../static/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="../static/css/animate.css" rel="stylesheet">
    <link href="../static/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-10">
            <div class="row">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="row row-sm text-center">
                            <div class="col-xs-6">
                                <div class="panel padder-v item bg-info">
                                    <div class="h1 text-fff font-thin h1" id="doctor"></div>
                                    <span class="text-muted text-xs">医院医生人数</span>
                                </div>
                            </div>
                            <div class="col-xs-6">
                                <div class="panel padder-v item bg-primary">
                                    <div class="h1 text-fff font-thin h1" id="category"></div>
                                    <span class="text-muted text-xs">医院科室数</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>挂号清单</h5>
                        </div>
                        <div class="ibox-content">
                            <table class="table table-striped table-bordered table-hover dataTables-example">
                                <thead id="qindan">
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
                                    <th>订单状态</th>
                                    <%--<th>操作</th>--%>
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
        <div class="col-sm-2">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>医院医生</h5>
                </div>
                <div class="ibox-content">
                    <ul class="todo-list m-t small-list ui-sortable" id="doctorList">

                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 全局js -->
<script src="../static/js/jquery.min.js?v=2.1.4"></script>
<script src="../static/js/bootstrap.min.js?v=3.3.6"></script>
<script src="../static/js/plugins/layer/layer.min.js"></script>
<!-- 自定义js -->
<script src="../static/js/content.js"></script>
<!-- Data Tables -->
<script src="../static/js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="../static/js/plugins/dataTables/dataTables.bootstrap.js"></script>
<!--flotdemo-->
<script type="text/javascript">
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
                        }}
                    // },
                    //     {
                    //         data: 'workStatus', render: function (data, type, row) {
                    //
                    //             if (data == 1) {
                    //                 return "<button class='btn btn-success'>处理</a>";
                    //             } else {
                    //                 return "<button class='btn btn-info'>未处理</a>";
                    //             }
                    //         }, width: "10%"
                    //     }


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

        // 	$.ajax({
        // 		url: '../getRegList.do',
        // 		type: 'POST',
        // 		dataType: 'JSON',
        // 		success: function(res){
        // 			var data = res;
        // 			//然后 DataTables 这样初始化：
        //             $('.dataTables-example').DataTable( {
        //                 data: data,
        //                 columns: [
        //                     { data: 'registerId' },
        //                     { data: 'hzName' },
        //                     { data: 'address' },
        //                     { data: 'tel'},
        //                     { data: 'doctorName' },
        //                     { data: 'deptName' },
        //                     { data: 'ghStatus',render:function(data,type,row){
        //                         if(data == 1){
        //                             return "<button class='btn btn-success'>正常</a>";
        //                         }else{
        //                             return "<button class='btn btn-danger'>取消</a>";
        //                         }
        //                 	} },
        //                     { data: 'orderTime' },
        //                     { data: 'createTime'}
        //                 ]
        //             } );
        // 		},
        // 		error: function(res){
        // 			layer.msg('加载失败');
        // 		}
        // 	});
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
