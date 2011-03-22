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
  <title>Statistics</title>
  <meta name="layout" content="main"/>
</head>
<body>

<h1>Statistics</h1>

<div class="clear"></div>

<div id="content-box">

  <div class="section">
    <div class="section-header">
      JMS Statistics
    </div>
    <div class="section-content">
      <div class="list">
        <table>
          <thead>
          <tr>

            <th>Key</th>
            <th>Value</th>
          </tr>
          </thead>
          <tbody>
          <g:each in="${stats?.keySet()}" status="i" var="stat">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

              <td>${stat}</td>

              <td>${stats[stat]}</td>

            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
    </div>
  </div>

</div>

</body>
</html>
