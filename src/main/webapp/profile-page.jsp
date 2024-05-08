<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp"/>

<body>
<div class="site-wrap">
    <jsp:include page="header.jsp"/>

    <div class="bg-light py-3">
        <div class="container">
            <div class="row">
                <div class="col-md-12 mb-0">
                    <a href="/">Home</a> <span class="mx-2 mb-0">/</span>
                    <strong class="text-black">Profile</strong></div>
            </div>
        </div>
    </div>

    <div class="site-section">
        <div class="container">
            <form class="row" action="profile-page" method="post" enctype="multipart/form-data">
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-12">
                            <h2 class="h3 mb-3 text-black">Profile Image</h2>

                            <div class="p-3 border d-flex justify-content-center">
                                <label class="m-0" for="imgInp">
                                    <figure class="d-flex justify-content-center m-0">
                                        <c:if test="${account.base64Image != null}">
                                            <img class="icon" src="data:image/jpg;base64,${account.base64Image}"
                                                 id="blah"
                                                 data-toggle="dropdown" alt="image"
                                                 style="width: 15em; height: 15em; border-radius: 50%;">
                                        </c:if>

                                        <c:if test="${account.base64Image == null}">
                                            <img class="icon" src="images/blank-profile-circle.png"
                                                 id="blah"
                                                 data-toggle="dropdown" alt="image"
                                                 style="width: 15em; height: 15em; border-radius: 50%;">
                                        </c:if>
                                    </figure>

                                    <figcaption style="text-align: center">
                                        Click here to change profile image
                                    </figcaption>
                                </label>

                                <input name="profile-image" type="file" id="imgInp" style="display: none;">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-8 mb-5 mb-md-0">
                    <h2 class="h3 mb-3 text-black">Profile Information</h2>

                    <div class="p-3 p-lg-5 border">

                        <div class="form-group row">
                            <div class="col-md-12">
                                <label for="username" class="text-black">
                                    Username <span class="text-danger">*</span>
                                </label>

                                <input type="text" class="form-control" id="username" name="username"
                                       value="${account.username}" readonly>
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-md-6">
                                <label for="first-name" class="text-black">
                                    First Name <span class="text-danger">*</span>
                                </label>

                                <input type="text" class="form-control" id="first-name" name="first-name"
                                       value="${account.firstName}" maxlength="32" pattern="[A-Za-z]{1,32}">
                            </div>

                            <div class="col-md-6">
                                <label for="last-name" class="text-black">
                                    Last Name <span class="text-danger">*</span>
                                </label>

                                <input type="text" class="form-control" id="last-name" name="last-name"
                                       value="${account.lastName}" maxlength="32" pattern="[A-Za-z]{1,32}">
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-md-12">
                                <label for="address" class="text-black">
                                    Address <span class="text-danger">*</span>
                                </label>

                                <input type="text" class="form-control" id="address" name="address"
                                       value="${account.address}">
                            </div>
                        </div>

                        <div class="form-group row mb-5">
                            <div class="col-md-6">
                                <label for="email" class="text-black">
                                    Email Address <span class="text-danger">*</span>
                                </label>

                                <input type="email" class="form-control" id="email" name="email"
                                       value="${account.email}">
                            </div>
                            <div class="col-md-6">
                                <label for="phone" class="text-black">
                                    Phone <span class="text-danger">*</span>
                                </label>

                                <input type="text" class="form-control" id="phone" name="phone"
                                       value="${account.phone}" maxlength="10" pattern="[0-9]{1-10}">
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-md-12">
                                <label for="credit_card" class="text-black">
                                    Credit Card Number <span class="text-danger">*</span>
                                </label>

                                <input type="text" class="form-control" id="credit_card" name="credit_card"
                                       value="${account.creditCard}" minlength="16" maxlength="16" pattern="[0-9]{1-10}">
                            </div>
                        </div>

                        <div class="form-group row mb-5">
                            <div class="col-md-2">
                                <label for="month" class="text-black">
                                    Month <span class="text-danger">*</span>
                                </label>

                                <input type="text" class="form-control" id="month" name="month"
                                       value="${account.month}">
                            </div>
                            <div class="col-md-4">
                                <label for="year" class="text-black">
                                    Year <span class="text-danger">*</span>
                                </label>

                                <input type="text" class="form-control" id="year" name="year"
                                       value="${account.year}">
                            </div>
                            <div class="col-md-2">
                                <label for="cvv" class="text-black">
                                    CVV <span class="text-danger">*</span>
                                </label>

                                <input type="text" class="form-control" id="cvv" name="cvv"
                                       value="${account.cvv}" minlength="3" maxlength="3" pattern=[0-9]{1-10}">
                            </div>
                            <div class="col-md-4">
                                <label for="zip_code" class="text-black">
                                    Zip Code <span class="text-danger">*</span>
                                </label>

                                <input type="text" class="form-control" id="zip_code" name="cvv"
                                       value="${account.zipCode}" minlength="5" maxlength="5" pattern=[0-9]{1-10}">
                            </div>
                        </div>

<%--                        <div class="form-group">--%>
<%--                            <label for="summary" class="text-black">--%>
<%--                                Summary--%>
<%--                            </label>--%>

<%--                            <textarea name="summary" id="summary" cols="30" rows="5" class="form-control"--%>
<%--                                      placeholder="Write your notes here..."></textarea>--%>
<%--                        </div>--%>

                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-lg py-3 btn-block">Update profile</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>
</div>


<script>
    imgInp.onchange = evt => {
        const [file] = imgInp.files
        if (file) {
            blah.src = URL.createObjectURL(file)
        }
    }
</script>
<jsp:include page="scripts.jsp"/>
</body>
</html>