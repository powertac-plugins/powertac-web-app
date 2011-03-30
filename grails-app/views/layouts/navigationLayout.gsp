<%@ page import="org.powertac.common.Competition" %>
<%--
  Sidebar navigation rendering
  User: cblock
  Date: 06.01.11
  Time: 19:09
--%>

<div class="user-box">
  <ul>
    %{--<g:isLoggedIn>
      <li>Logged in as <g:link controller="register" class="user"><g:loggedInUserInfo field="userRealName"></g:loggedInUserInfo></g:link>.</li>
      <li><g:link controller="logout"><g:message code="auth.logout"/></g:link></li>
    </g:isLoggedIn>

    <g:isNotLoggedIn>--}%
    <li><g:message code="auth.welcome.anonymous"/> <g:link controller="login" action="auth" class="user"><g:message code="auth.login"/></g:link></li>
    %{--</g:isNotLoggedIn>--}%
  </ul>
</div>

<div class="link-box">
  <ul>
    <li>Power TAC</li>
    <li><g:link controller="info" action="about" class="about">About</g:link></li>
    <li><g:link controller="info" action="disclaimer" class="disclaimer">Disclaimer</g:link></li>
    <li><g:link controller="info" action="contact" class="contact">Contact</g:link></li>
  </ul>
</div>

%{--<g:ifAllGranted role="ROLE_ADMIN">--}%
<div class="link-box">
  <ul>
    <li>Admin Area</li>
    <li><g:link controller="info" action="statistics" class="statistics" title="Statistics">Statistics</g:link></li>
    <li><g:link controller="info" action="plugins" class="plugins" title="Plugins">Plugins</g:link></li>
    <li><g:link controller="runtimeLogging" class="logging" title="Adjust Logging">Adjust Logging</g:link></li>
  </ul>
</div>
%{--</g:ifAllGranted>--}%

<div class="link-box">
  <ul>
    <g:if test="${Competition.currentCompetition()}">
      <li><g:link controller="competition" action="show" class="competition" id="${Competition.currentCompetition().id}" title="${Competition.currentCompetition().name}">${Competition.currentCompetition().name}</g:link></li>
      <li><a href="${createLink(uri: '/')}" class="dashboard" title="Dashboard">Dashboard</a></li>
      <li><g:link controller="broker" action="list" class="brokers" title="Brokers">Brokers</g:link></li>
      <li><g:link controller="cashPosition" action="list" class="cashpositions" title="Cash Positions ">Cash Positions</g:link></li>
      <li><g:link controller="marketPosition" action="list" class="marketpositions" title="Market Positions">Market Positions</g:link></li>
      <li><g:link controller="genCo" action="list" class="genco" title="GenCo">GenCo</g:link></li>
      <li><g:link controller="customerInfo" action="list" class="customerinfo" title="Customer Info">Customer Info</g:link></li>
      <li><p class="market">Market</p></li>
      <li><g:link controller="marketTransaction" action="list" class="markettransactions" title="Market Transactions">Market Transactions</g:link></li>
      <li><g:link controller="orderbook" action="list" class="orderbooks" title="Orderbooks">Orderbooks</g:link></li>
      <li><g:link controller="shout" action="list" class="shouts" title="Shouts">Shouts</g:link></li>
      <li><g:link controller="timeslot" action="list" class="timeslots" title="Timeslots">Timeslots</g:link></li>
      <li><g:link controller="tariff" action="list" class="tariffs" title="Tariffs">Tariffs</g:link></li>
      <li><g:link controller="rate" action="list" class="rates" title="Rates">Rates</g:link></li>
      <li><g:link controller="tariffSpecification" action="list" class="tariffspecifications" title="Tariff Specifications">Tariff Specifications</g:link></li>
      <li><g:link controller="tariffTransaction" action="list" class="tarifftransactions" title="Tariff Transactions">Tariff Transactions</g:link></li>
      <li><g:link controller="weather" action="list" class="weatherforecasts" title="Weather Forecasts">Weather Forecasts</g:link></li>
      <li><g:link controller="weather" action="list" class="weatherreports" title="Weather Reports">Weather Reports</g:link></li>
    </g:if>
    <g:else>
      <li>No current competition found</li>
      <li><g:link controller="competition" action="create" class="createcompetition" title="Create new competition">Create new competition</g:link></li>
    </g:else>
  </ul>
</div>
