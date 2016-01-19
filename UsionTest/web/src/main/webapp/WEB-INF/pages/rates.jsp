<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="rateList.title"/></title>
    <meta name="menu" content="RateMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="col-sm-10">
    <h2><fmt:message key="rateList.heading"/></h2>

    <form method="get" action="${ctx}/rates" id="searchForm" class="form-inline">
    <div id="search" class="text-right">
        <span class="col-sm-9">
            <input type="text" size="20" name="q" id="query" value="${param.q}"
                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
        </span>
        <button id="button.search" class="btn btn-default" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <fmt:message key="rateList.message"/>

    <div id="actions" class="btn-group">
        <a href='<c:url value="/rateform"/>' class="btn btn-primary">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

<display:table name="rateList" class="table table-condensed table-striped table-hover" requestURI="" id="rateList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="rateform" media="html"
        paramId="id" paramProperty="id" titleKey="rate.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="rate.id"/>
    <display:column property="name" sortable="true" titleKey="rate.name"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="rateList.rate"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="rateList.rates"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="rateList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="rateList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="rateList.title"/>.pdf</display:setProperty>
</display:table>
