<%@ page import="org.powertac.common.Competition; org.powertac.server.CompetitionController" %>
%{--
  - Copyright 2009-2010 the original author or authors.
  -
  - Licensed under the Apache License, Version 2.0 (the "License");
  - you may not use this file except in compliance with the License.
  - You may obtain a copy of the License at
  -
  -  http://www.apache.org/licenses/LICENSE-2.0
  -
  - Unless required by applicable law or agreed to in writing, software
  - distributed under the License is distributed on an
  -
  - "AS IS" BASIS,  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
  -
  - either express or implied. See the License for the specific language
  - governing permissions and limitations under the License.
  --}%

<html>
<head>
  <title>Welcome</title>
  <meta name="layout" content="main"/>
</head>
<body>

<h1>Dashboard</h1>

<div class="clear"></div>

<div id="content-box">

  <div class="section">
    <div class="section-header">
      Current Competition
    </div>
    <div class="section-content">
      <g:if test="${Competition.currentCompetition()}">
        <p><g:link controller="competition" action="start" id="${Competition.currentCompetition()?.id}">Start competition "${Competition.currentCompetition()?.name}"</g:link></p>
      </g:if>
      <g:else>
        <p>No current competition found, <g:link controller="competition" action="create">create new competition</g:link>.</p>
      </g:else>
    </div>
  </div>

  <div class="section section-last">
    <div class="section-header">
      Installed PowerTAC Plugins
    </div>
    <div class="section-content">
      <ul>
        <g:set var="pluginManager"
            value="${applicationContext.getBean('pluginManager')}"></g:set>

        <g:each var="plugin" in="${pluginManager.userPlugins}">
          <g:if test="${plugin.name.contains('powertac')}">
            <li>${plugin.name} - ${plugin.version}</li>
          </g:if>
        </g:each>

      </ul>
    </div>
  </div>

</div>

</body>
</html>
