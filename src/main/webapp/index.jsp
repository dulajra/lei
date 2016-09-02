<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Dashboard</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">

    <link rel="stylesheet" href="dist/css/chatbox.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
    <!-- Morris chart -->
    <link rel="stylesheet" href="plugins/morris/morris.css">
    <!-- jvectormap -->
    <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <!-- Date Picker -->
    <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->

        <nav class="navbar navbar-static-top">
            <div class="navbar-header" style="width: 30%">
                <a href="#" class="logo navbar-brand">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini">Chat</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg">Chat</span>
                </a>
            </div>
        </nav>
    </header>

    <div style="float: left;" class="">
        <div class="">
            <div id="demo-chat-body" class="collapse in" style="background-color:#fff; position: fixed;width: 30%;">
                <div id="chatbox-body" class="nano has-scrollbar"
                     style="position: fixed;width: 30%;bottom: 50px;padding-top: 100px;">
                    <div class="nano-content pad-all" tabindex="0" style="background-color: #8cddff;">
                        <ul id="chat-area" class="list-unstyled media-block">
                            <li class="mar-btm">
                                <div class="media-left">
                                    <img src="http://bootdey.com/img/Content/avatar/avatar1.png"
                                         class="img-circle img-sm" alt="Profile Picture">
                                </div>
                                <div class="media-body pad-hor">
                                    <div class="speech">
                                        <a href="#" class="media-heading">Lei</a>

                                        <p>Response</p>

                                        <p class="speech-time">
                                            <i class="fa fa-clock-o fa-fw"></i>09:23AM
                                        </p>
                                    </div>
                                </div>
                            </li>
                            <li class="mar-btm">
                                <div class="media-left">
                                    <img src="http://bootdey.com/img/Content/avatar/avatar1.png"
                                         class="img-circle img-sm" alt="Profile Picture">
                                </div>
                                <div class="media-body pad-hor">
                                    <div class="speech">
                                        <a href="#" class="media-heading">Lei</a>

                                        <p>Response</p>

                                        <p class="speech-time">
                                            <i class="fa fa-clock-o fa-fw"></i>09:23AM
                                        </p>
                                    </div>
                                </div>
                            </li>
                            <li class="mar-btm">
                                <div class="media-left">
                                    <img src="http://bootdey.com/img/Content/avatar/avatar1.png"
                                         class="img-circle img-sm" alt="Profile Picture">
                                </div>
                                <div class="media-body pad-hor">
                                    <div class="speech">
                                        <a href="#" class="media-heading">Lei</a>

                                        <p>Response</p>

                                        <p class="speech-time">
                                            <i class="fa fa-clock-o fa-fw"></i>09:23AM
                                        </p>
                                    </div>
                                </div>
                            </li>
                            <li class="mar-btm">
                                <div class="media-right">
                                    <img src="http://bootdey.com/img/Content/avatar/avatar2.png"
                                         class="img-circle img-sm" alt="Profile Picture">
                                </div>
                                <div class="media-body pad-hor speech-right">
                                    <div class="speech">
                                        <a href="#" class="media-heading">You</a>

                                        <p>Query string</p>

                                        <p class="speech-time">
                                            <i class="fa fa-clock-o fa-fw"></i> 09:23AM
                                        </p>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>

                <style>
                    #chat-bar-footer {
                        width: 30%;
                        position: fixed;
                        margin-bottom: 0;
                        bottom: 0;
                    }
                </style>
                <!--Widget footer-->
                <div id="chat-bar-footer">
                    <div class="panel-footer"
                         style="margin-bottom: 0;border-bottom-left-radius: 0px;border-bottom-right-radius: 0px;">
                        <div class="row">
                            <form id="form" action="" onsubmit="return false;">
                                <div class="col-xs-9">
                                    <input type="text" name="query" placeholder="Enter your text"
                                           class="form-control chat-input" autocomplete="false">
                                </div>
                                <div class="col-xs-3">
                                    <button class="btn btn-primary btn-block" type="submit">Send</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper" style="background-color: #ffffff;width: 70%;float: right;position: fixed;">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Welcome, I'm Lei!
            </h1>
        </section>


        <!-- Main content -->
        <section class="content">
            <!-- Small boxes (Stat box) -->
            <div class="box-body">
                <div class="">
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-aqua">
                            <div class="inner">
                                <h3>150</h3>

                                <p>New Orders</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-bag"></i>
                            </div>
                            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                    <!-- ./col -->
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-green">
                            <div class="inner">
                                <h3>53<sup style="font-size: 20px">%</sup></h3>

                                <p>Bounce Rate</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-stats-bars"></i>
                            </div>
                            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                    <!-- ./col -->
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-yellow">
                            <div class="inner">
                                <h3>44</h3>

                                <p>User Registrations</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-person-add"></i>
                            </div>
                            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                    <!-- ./col -->
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-red">
                            <div class="inner">
                                <h3>65</h3>

                                <p>Unique Visitors</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-pie-graph"></i>
                            </div>
                            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                    <!-- ./col -->
                </div>
            </div>
            <!-- /.row -->
            <!-- Main row -->
            <div class="row">
                <!-- Left col -->
                <section class="col-lg-7 connectedSortable">
                    <!-- Custom tabs (Charts with tabs)-->
                    <div class="nav-tabs-custom">
                        <img src="dist/img/promo.jpg" class="img-responsive"
                             style="display:block;margin-left: auto;margin-right: auto" alt="User Image">

                    </div>

                </section>

                <section class="col-lg-5 connectedSortable">

                    <!-- Map box -->
                    <div class="box box-solid bg-light-blue-gradient">
                        <div class="box-header">
                            <img src="dist/img/keels.png" class="img-responsive"
                                 style="display:block;margin-left: auto;margin-right: auto" alt="User Image">

                        </div>
                    </div>
                    <!-- /.box -->

                    <!-- solid sales graph -->


                </section>
                <!-- right col -->
            </div>
            <!-- /.row (main row) -->

        </section>
        <!-- /.content -->
    </div>
</div>


<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<!-- Sparkline -->
<script src="plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/app.min.js"></script>


<script>
    $('#form').on('submit', function (e) {
        var queryString = e.target.query.value
        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === this.DONE) {
                console.log(this.responseText);
                var chatMessage = "<div class='media-left'> <img src='http://bootdey.com/img/Content/avatar/avatar1.png' class='img-circle img-sm' alt='Profile Picture'> </div> <div class='media-body pad-hor'> <div class='speech'> <a href='#' class='media-heading'>Lei</a> <p>Response</p> <p class='speech-time'> <i class='fa fa-clock-o fa-fw'></i>" + (new Date()).getHours() + ":" + (new Date()).getMinutes() + ":" +
                        (new Date()).getSeconds() + "</p> </div> </div>";
            }
        });

        xhr.open("GET", "http://localhost:8080/lei-api/?query=" + queryString);
        xhr.setRequestHeader("content-type", "application/json");

        xhr.send();
    });
</script>
</body>
</html>
