<%@page pageEncoding="UTF-8"
   import="java.util.*, java.text.*, model.UserModule"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Andrea - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Abril+Fatface&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">


    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <div id="colorlib-page">
        <a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
        <aside id="colorlib-aside" role="complementary" class="js-fullheight">
            <nav id="colorlib-main-menu" role="navigation">
                <ul>
                    <h1 id="colorlib-logo" class="mb-4" style="line-height: 1.2;font-size: 3.5em;"><a href=""
                            style="background-image: url(images/bg_1.jpg);">${
                            sessionScope.login }'s <br> Home
                            <span></span></a></h1>


                    <div class='logbar'>
                        <br>

                    </div>
                </ul>

            </nav>

            <div class="colorlib-footer">
                <!-- <h2>${ sessionScope.login }</h2> -->
                <a href='logout.do?username="${ sessionScope.login }'>
                    <button class="btn btn-primary">Logout </button></a>



                <p class="pfooter">
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    Copyright &copy;
                    <script>document.write(new Date().getFullYear());</script> All rights reserved | This template
                    is
                    made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com"
                        target="_blank">Colorlib</a>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </p>
            </div>
        </aside> <!-- END COLORLIB-ASIDE -->
        <div id="colorlib-main">
            <section class="ftco-section">
                <div class="container">
                    <div class="row px-md-4">
                        <form method='post' action='message.do' style="width: 100%;">
                            <div class="col-md-12">
                                <div class="blog-entry ftco-animate d-md-flex">
                                    <div class="text text-2 pl-md-4">
                                        <h3 class="mb-2">Submit a new post
                                        </h3>
                                        <p>
                                            <input type="text" name='userTitle' style="width:100%;" required
                                                placeholder="Title">
                                            ${ requestScope.userTitle }
                                        </p>

                                        <p class="mb-4"><%
                                                        String userMessage = (String) request.getAttribute("userMessage");
                                                        %></p>
                                        <p>
                                            <textarea id="editor" cols="30" rows="10" name='userMessage'
                                                style="width:100%;" placeholder="message..."
                                                required>${ requestScope.userMessage }</textarea>
                                        </p>

                                        <div class="form-group">
                                            <button type='submit' class="btn btn-primary" id="submit">Submit</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>



                        </form>
                        <%
                            DateFormat dateFormat = DateFormat.getDateTimeInstance(
                                DateFormat.FULL, DateFormat.FULL, Locale.US);
                            List<UserModule> UserModules = (List<UserModule>) request.getAttribute("UserModules");
                            for(UserModule UserModule : UserModules) {
                            %>
                        <div class="col-md-12">
                            <div class="blog-entry ftco-animate d-md-flex">
                                <!-- <a href="" class="img img-2" style=""></a> -->
                                <div class="text text-2 pl-md-4">
                                    <h3 class="mb-2"><%= UserModule.getTitle() %></h3>
                                    <div class="meta-wrap">
                                        <p class="meta">
                                            <span><i
                                                    class="icon-calendar mr-2"></i><%= dateFormat.format(UserModule.getDate()) %></span>
                                            <span><i
                                                    class="icon-comment2 mr-2"></i><%= UserModule.getUsername() %></span>
                                        </p>
                                    </div>
                                    <p class="mb-4"><%= UserModule.getTxt() %><br></p>
                                    <a href='delete.do?message=<%= UserModule.getDate().getTime() %>'>
                                        <button class="btn btn-primary">Delete</button>
                                    </a>
                                </div>
                            </div>
                        </div>

                        <%
                            }
                            %>

                    </div>
                </div>
            </section>
        </div><!-- END COLORLIB-MAIN -->
    </div><!-- END COLORLIB-PAGE -->

    <!-- loader -->
    <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px">
            <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee" />
            <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                stroke="#F96D00" /></svg></div>


    <script src="js/jquery.min.js"></script>
    <script src="js/jquery-migrate-3.0.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/jquery.waypoints.min.js"></script>
    <script src="js/jquery.stellar.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/aos.js"></script>
    <script src="js/jquery.animateNumber.min.js"></script>
    <script src="js/scrollax.min.js"></script>
    <script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
    <script src="js/google-map.js"></script>
    <script src="js/main-a.js"></script>

</body>

</html>