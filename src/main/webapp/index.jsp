<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp"/>

<body>
<div class="site-wrap">
    <jsp:include page="header.jsp"/>

    <div class="site-blocks-cover" style="background-image: url(images/grocery.jpg);" data-aos="fade">
<%--        <div class="container">--%>
<%--            <div class="row align-items-start align-items-md-center justify-content-end">--%>
<%--                <div class="col-md-5 text-center text-md-left pt-5 pt-md-0">--%>
<%--                    <h1 class="mb-2">Healthy Organic Food From Your Local Market</h1>--%>

<%--                    <div class="intro-text text-center text-md-left">--%>
<%--                        <p class="mb-4"> Free Pickup or Free Delivery Available for Orders under 20 LBS</p>--%>
<%--                        <p>--%>
<%--                            <a href="shop" class="btn btn-sm btn-primary">Shop Now</a>--%>
<%--                        </p>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div>

    <div class="site-section site-section-sm site-blocks-1">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="">
                    <div class="icon mr-4 align-self-start">
                        <span class="icon-truck"></span>
                    </div>

                    <div class="text">
                        <h2 class="text-uppercase">Free Shipping with Orders under 20 LBS</h2>
                        <p>Organic groceries delivered straight to your door the next business day if you order before closing hours</p>
                    </div>
                </div>

                <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="100">
                    <div class="icon mr-4 align-self-start">
                        <span class="icon-thumb_up"></span>
                    </div>
                    <div class="text">
                        <h2 class="text-uppercase">Best Quality</h2>
                        <p>High-quality, locally grown organic products</p>
                    </div>
                </div>

                <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="200">
                    <div class="icon mr-4 align-self-start">
                        <span class="icon-help"></span>
                    </div>
                    <div class="text">
                        <h2 class="text-uppercase">Customer Support</h2>
                        <p>Have Questions? We have answers</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%--    <jsp:include page="collections-section.jsp"/>--%>

<%--    <jsp:include page="featured-products.jsp"/>--%>

<%--    <div class="site-section block-8">--%>
<%--        <div class="container">--%>
<%--            <div class="row justify-content-center  mb-5">--%>
<%--                <div class="col-md-7 site-section-heading text-center pt-4">--%>
<%--                    <h2>Big Sale!</h2>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="row align-items-center">--%>
<%--                <div class="col-md-12 col-lg-7 mb-5">--%>
<%--                    <a href="#"><img src="images/blog_1.jpg" alt="Image placeholder"--%>
<%--                                     class="img-fluid rounded"></a>--%>
<%--                </div>--%>
<%--                <div class="col-md-12 col-lg-5 text-center pl-md-5">--%>
<%--                    <h2><a href="#">50% less in all items</a></h2>--%>
<%--                    <p class="post-meta mb-4">By <a href="#">Carl Smith</a> <span class="block-8-sep">&bullet;</span>--%>
<%--                        September 3, 2018</p>--%>
<%--                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quisquam iste dolor accusantium facere--%>
<%--                        corporis ipsum animi deleniti fugiat. Ex, veniam?</p>--%>
<%--                    <p><a href="shop" class="btn btn-primary btn-sm">Shop Now</a></p>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

    <jsp:include page="footer.jsp"/>
</div>

<jsp:include page="scripts.jsp"/>
</body>
</html>