<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 基本表单</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="../static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../static/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="../static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="../static/css/animate.css" rel="stylesheet">
    <link href="../static/css/style.css?v=4.1.0" rel="stylesheet">
	<style>
		.form-control, .single-line{padding:4px 12px;}
	</style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="panel panel-heading ">
                        <h5>修改医生信息</h5>
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

    <!-- iCheck -->
    <script src="../static/js/plugins/iCheck/icheck.min.js"></script>
    <script src="../static/layer/layer.js"></script>
    <script>
	    $(document).ready(function () {
	        $('.i-checks').iCheck({
	            checkboxClass: 'icheckbox_square-green',
	            radioClass: 'iradio_square-green',
	        });
	    });
	    //根据doctorId获取医生信息
	    function getDocById(doctorId){
	    	$.ajax({
        		url: '../getDocById.do',
        		type: 'POST',
        		data: {'doctorId':doctorId},
        		dataType: 'JSON',
        		success: function(doc){
        		    doctorDatas=doc;


        		    $("#doctors").append(
                        "<div class='col-sm-4'>"+
                        "<form role='form' class='form-horizontal'> "+
                        "<div class='panel-heading'>"+doc.doctorName+" 相关信息</div>"+
                        "<div class='panel-body'>"+
                        "<p>医生姓名: "+doc.doctorName+"</p>"+
                        "<p>所属科室: "+doc.deptName+"</p>"+
                        "<div class='form-group'>"+
                            "<label class='col-sm-2 control-label' style='padding:0px'>医生简介:</label> "+
                            "<div class='col-sm-10'>"+
                            "<input id='docDes' type='text' placeholder='请输入医生简介' class='form-control' value="+doc.doctorDes+"> "+
                        "<input id='doctorId' type='hidden'value="+doc.doctorId+"> "+
                            "</div>"+
                        "</div>"+
                        "<div class='form-group'>"+

                                    "<label>看诊时间(必选)</label>"+
                                    "<div class='col-sm-12'>"+
                                    "<label class='checkbox-inline i-checks'>"+
                        "<input type='checkbox' value='星期一' name='workTime'"+">星期一</label>"+
                                    "<label class='checkbox-inline i-checks'>"+
                                    "<input type='checkbox' value='星期二' name='workTime'>星期二</label>"+
                                    "<label class='checkbox-inline i-checks'>"+
                                    "<input type='checkbox' value='星期三' name='workTime'>星期三</label>"+
                                    "<label class='checkbox-inline i-checks'>"+
                                   "<input type='checkbox' value='星期四' name='workTime'>星期四</label>"+
                                    "<label class='checkbox-inline i-checks'>"+
                                    "<input type='checkbox' value='星期五' name='workTime'>星期五</label>"+
                                    "<label class='checkbox-inline i-checks'>"+
                                    "<input type='checkbox' value='星期六' name='workTime'>星期六</label>"+
                                    "<label class='checkbox-inline i-checks'>"+
                                    "<input type='checkbox' value='星期日' name='workTime'>星期日</label>"+
                                    "</div>"+
                        "</div>"+
                        "</div>"+
                        "</div>"+
                        "<button type='button' class='btn btn-sm btn-primary pull-right m-t-n-xs' onclick='updateDoc()'>" +
                        "<strong>更 新</strong>" +
                        "</button>"+
                            "</form>"+
                            "<div>"
                );
                    // laydate.render({
                    //     elem: '#time' //指定元素
                    // });
        			$('#doctorId').val(doc.doctorId);
        			$('#doctorName').val(doc.doctorName);
        			$('#doctorDes').val(doc.doctorDes);

                    var workTimeArr=[];定义一个数组
                    workTimeArr=doc.registerTime;

                    $('input[name="workTime"]:checked').each(function () {
                        workTimeArr.push($(this).val());
                    })
                    var workTime=workTimeArr.join(",");

        			for(var i=0;i<workTimeArr.length;i++){
        				$("input[type='checkbox']").each(function(){
                           if($(this).val() == workTimeArr[i]){
                        	   $(this).attr('checked',true);
                        	   $(this).parent().attr('class','icheckbox_square-green checked');
                           }
                        });
        			}
        		},
        		error: function(res){
        			layer.msg('编辑失败');
        		}
        	});
	    }
	    //更新医生信息
        function updateDoc(){
        	var doctorId=$('#doctorId').val();
        	//console.log("@#@@#^^^^^^^^^^^^^^^^^^^^^^^^^"+doctorId);

        	// var docName = $('#docName').val();
        	// console.log(docName);
        	var docDes = $('#docDes').val();
        	console.log(docDes);
        	//var deptName = $("select option:checked").text();
        	var workTimeArr =[];//定义一个数组    
            $('input[name="workTime"]:checked').each(function(){
            	workTimeArr.push($(this).val());  
            });
        	var workTime = workTimeArr.join(",");
        	if(workTime == ""){
        		layer.msg("请选择医生上班时间!");
        	}
        	// alert(workTime);
        	// for(var j=0;j<workTimeArr.length;j++){
        	//     alert(workTimeArr[j]);
            // }

        	$.ajax({
        		url: '../updateDoc.do',
        		type: 'POST',
        		data: {
        		    'doctorId':doctorId,
                    'doctorDes':docDes,
                    'workTime':workTime,
                   },
        		dataType: 'JSON',
        		success: function(result){
        			var frameIndex = parent.layer.getFrameIndex(window.name); //获取窗口索引
        			if(result=="success"){
        				layer.alert('更新成功',function(index){
        					layer.close(index);
        					parent.reload();
        					parent.layer.close(frameIndex);
        				});
        			}else if(result == "error"){
        				layer.msg('更新失败');
        			}
        		},
        		error: function(result){
        			layer.msg('更新失败');
        		}
        	});
        }
    </script>
</body>
</html>
