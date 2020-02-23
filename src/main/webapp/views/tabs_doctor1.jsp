<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 选项卡 &amp; 面板</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="../static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../static/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="../static/css/animate.css" rel="stylesheet">
    <link href="../static/css/style.css?v=4.1.0" rel="stylesheet">
    <style>
        .des {
            display: block;
            line-height: 25px;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }
    </style>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeIn">

    <div class="row">
        <div class="col-sm-12">
            <div class="ibox">
                <div class="ibox-title">
                    <h5>科室医生列表</h5>
                    <h5>hhsdgsd</h5>
                </div>
                <div class="ibox-content">
                    <div class="row" id="doctors">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- 全局js -->
<script src="../static/js/jquery.min.js?v=2.1.4"></script>
<script src="../static/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="../static/js/content.js?v=1.0.0"></script>
<script src="../static/js/plugins/layer/layer.min.js"></script>

<script src="../static/js/laydate/laydate.js"></script>
<script type="text/javascript" src="../static/js/jquery.cookie.js"></script>
<script>
    var doctorDatas;

    function getDoctorByDeptId(id) {
        $.ajax({
            url: '../getDoctorByDeptId.do',
            type: 'POST',
            data: {'deptId': id},
            dataType: 'JSON',
            success: function (doctList) {
                doctorDatas = doctList;
                for (let i = 0; i < doctList.length; i++) {
                    var status = doctList[i].workStatus == 1 ? "正常" : "请假";
                    var id = "#time" + i;
                    $("#doctors").append(
                        "<div class='col-sm-4'>" +
                        "<div class='panel panel-success'>" +
                        "<div class='panel-heading'>" + res[i].doctorName + " 相关信息</div>" +
                        "<div class='panel-body'>" +
                        "<p>医生姓名: " + res[i].doctorName + "</p>" +
                        "<p class='des'>医生简介: " + res[i].doctorDes + "</p>" +
                        "<p>所属科室: " + res[i].deptName + "</p>" +
                        "<p>出诊时间: " + res[i].workTime + "</p>" +
                        "<p style='color:red'>当前工作状态: " + workStatus + "</p>" +

                        "<div class='form-group'>" +
                        "<label class='col-sm-2 control-label' style='padding:0px'>挂号时间：</label>" +
                        "<div class='col-sm-10'>" +
                        "<input id='time" + i + "' class='laydate-icon form-control layer-date'>" +
                        "</div>" +
                        "</div>" +
                        "<button class='btn btn-info' onclick='register(" + i + ")'>挂号</button>" +
                        "</div>" +
                        "</div>" +
                        "</div>"
                    );
                    laydate.render({
                        elem: '#time' + i //指定元素
                    });

                }

            },
            error: function (res) {
                layer.msg('加载失败');
            }
        });
    }

    function getDoctorById(id) {
        $.ajax({
            url: '../getDocById.do',
            type: 'POST',
            data: {'doctorId': id},
            dataType: 'JSON',
            success: function (res) {
                doctorDatas = res;
                var status = res.workStatus == 1 ? "正常" : "请假";
                $("#doctors").append(
                    "<div class='col-sm-4'>" +
                    "<div class='panel panel-success'>" +
                    "<div class='panel-heading'>" + res.doctorName + " 相关信息</div>" +
                    "<div class='panel-body'>" +"<input value='"+res.doctorId+"' type='hidden' id='doctorId'> "+
                    "<p>医生姓名: " + res.doctorName + "</p>" +
                    "<p class='des'>医生简介: " + res.doctorDes + "</p>" +
                    "<p>所属科室: " + res.deptName + "</p>" +
                    "<p>出诊时间: " + res.workTime + "</p>" +
                    "<p style='color:red'>当前工作状态: " + status + "</p>" +

                    "<div class='form-group'>" +
                    "<label class='col-sm-2 control-label' style='padding:0px'>挂号时间：</label>" +
                    "<div class='col-sm-10'>" +
                    "<input id='time' class='laydate-icon form-control layer-date'>" +
                    "</div>" +
                    "</div>" +
                    "<button class='btn btn-info' onclick='register(-1)'>挂号</button>" +
                    "</div>" +
                    "</div>" +
                    "</div>"
                );
                laydate.render({
                    elem: '#time' + i //指定元素
                });


            },
            error: function (res) {
                layer.msg('加载失败');
            }
        });
    }

    function register(index) {
        //  console.log(index+"^^^^^^^^^^^^^^^^^^^^^66")
        var userData;
        var userId = $.cookie('username');
        if (userId == null) {
            setTimeout(function () {
                window.location.href = "/note/";
            }, 1000);
        }
        $.ajax({
            url: '../getUserData.do',
            type: 'POST',
            data: {
                'userId': userId
            },
            dataType: 'JSON',
            success: function (result) {
                userData=result
            }
        })
        //console.log(index+"+++++++0000");
        if (index >= 0) {
            var data = doctorDatas[index];
        } else {
            var data = doctorDatas;
        }
        console.log(data);//根据
        if (data.workStatus == 1) {
            //选择时间
            if (data == -1) {
                var time = $('#time').val();

            } else {
                var time = $('#time').val();

            }

            //当前系统时间 转换为年月日
            var now = new Date();

            var nowTime = now.getFullYear() + "-" + ((now.getMonth() + 1) < 10 ? "0" : "") + (now.getMonth() + 1) + "-" + (now.getDate() < 10 ? "0" : "") + now.getDate();

            var timestamp = now.getTime();
            // console.log(timestamp);
            var registerTime = new Date(time).getTime();
            // console.log(registerTime);
            var cha = timestamp - registerTime;
            // console.log(cha);
            if (cha >= 0) {
                alert("对不起,请预约今天之后的时间");
            } else {
                //判断预约的日期为星期几
                var week = getMyDay(new Date(time));
                // console.log(userData.doctorId);
                // console.log(userData.doctorName);
                // console.log(userData.deptName);
                // console.log(userData.deptId);
                // console.log(userData.workStatus);
                // console.log(userData.status);
                // console.log(userData.workTime);
                // console.log(userData.doctorDes);
                // console.log(data.userId);
                console.log(data.deptName);
                console.log(data.doctorId);
                console.log(registerTime);
                console.log(time);
                console.log(nowTime);
                var userId = $.cookie('username');
                console.log(userId);
                if (data.workTime.indexOf(week) > -1) {
                    layer.confirm('确认预约该医生的诊疗？', {
                        btn: ['确定', '取消'] //按钮
                    }, function () {
                        var userId=$.cookie('username');
                        console.log(userId);
                        var doctorId=data.doctorId;
                        console.log(doctorId);
                        var registerTime=time;
                        console.log(registerTime);
                        var createTime=nowTime;
                        console.log(nowTime);

                        //提交
                        $.ajax({
                            url: '../addOrder.do',
                            type: 'POST',
                            data: JSON.stringify({
                                'userId': userId,
                                'doctorId': data.doctorId,
                                'registerTime': registerTime,
                                'createTime': createTime
                            }),
                            dataType:'JSON',
                            contentType: "application/json; charset=utf-8",
                            success: function (result) {
                                if (result == "success") {
                                    layer.alert('挂号预约成功', function (index) {
                                        layer.close(index);
                                        parent.layer.closeAll();
                                    });
                                }
                            },
                            error: function (res) {
                                layer.msg('挂号预约失败');
                            }
                        })
                    }, function () {
                    });
                } else {
                    layer.msg("请选择当前医生出诊的时间预约！");
                }
            }

        } else if (data.workStatus == 0) {
            layer.msg("对不起！当前医生处于请假状态，请选择其他医生");
        }
    }

    //判断周几
    function getMyDay(date) {
        var week;
        if (date.getDay() == 0) week = "星期日"
        if (date.getDay() == 1) week = "星期一"
        if (date.getDay() == 2) week = "星期二"
        if (date.getDay() == 3) week = "星期三"
        if (date.getDay() == 4) week = "星期四"
        if (date.getDay() == 5) week = "星期五"
        if (date.getDay() == 6) week = "星期六"
        return week;
    }

</script>
</body>

</html>
