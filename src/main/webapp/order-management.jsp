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
                <div class="col-md-12 mb-0"><a href="index.jsp">Home</a> <span class="mx-2 mb-0">/</span> <strong
                        class="text-black">Orders Management</strong></div>
            </div>
        </div>
    </div>

    <div class="site-section">
        <div class="container">
            <div class="row mb-5">
                <div class="col-md-12">
                    <div class="site-blocks-table">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>Image</th>
                                <th>ID</th>
                                <th style="max-width: 120px">Product name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th style="min-width: 195px">Remove</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${order_detail_list}" var="o">
                                <tr>
                                    <td class="product-thumbnail">
                                        <img src="data:image/jpg;base64,${o.product.base64Image}" alt="Image" class="img-fluid">
                                    </td>

                                    <td>${o.product.id}</td>

                                    <td>${o.product.name}</td>

                                    <td>$${o.price}</td>

                                    <td>${o.quantity}</td>

                                    <td>${o.quantity * o.price}</td>

                                    <td>
<%--                                        <a href="edit-order?order-id=${o.id}" class="btn btn-primary btn-sm"--%>
<%--                                           style="background-color: green ; border-color: green">--%>
<%--                                            <span class="icon icon-pencil"></span>--%>
<%--                                        </a>--%>

                                        <a href="remove-order?order-id=${o.id}"
                                           class="btn btn-primary btn-sm ${(o.isDeleted) ? "disabled" : " "}"
                                           style="background-color: red ; border-color: red">
                                            <span class="icon icon-trash"></span>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</div>

<jsp:include page="scripts.jsp"/>
</body>
</html>