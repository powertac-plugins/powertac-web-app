<%@ page import="org.codehaus.groovy.grails.commons.ConfigurationHolder" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>Power TAC - <g:layoutTitle default="Welcome"/></title>
  <link rel="stylesheet" type="text/css" media="all" href="${resource(dir: 'css', file: 'style.css')}"/>
  <g:javascript library="jquery"/>
  <jq:plugin name="shuffle"/>
  <jq:plugin name="cycle"/>
  <g:javascript library="tac"/>
  <g:layoutHead/>
</head>
<body>
<div class="container_16">

  <div id="header">

    <div id="logo" class="grid_4">
      <a href="${resource(dir: '')}" title="Power TAC"></a>
    </div>

    <div id="nav">
      <ul class="grid_8 prefix_4">
        <li><g:link controller="info" action="about">About</g:link></li>
        <li><g:link controller="info" action="terms">Terms of Use</g:link></li>
        <li><g:link controller="info" action="disclaimer">Disclaimer</g:link></li>
        <li><a href="http://www.powertac.org/docs/latest/manual/index.html" target="_blank">Documentation</a></li>
        <li><g:link controller="info" action="contact">Contact</g:link></li>
      </ul>
    </div>

  </div> <!-- header -->

  <div class="clear"></div>

  <div id="wrapper">

    <div id="navigation" class="grid_4">

      <g:applyLayout name="navigationLayout"/>

      <div id="universities">
        <a href="http://www.kit.edu" target="_blank" title="Karlsruhe Institute of Technology (KIT)"><img src="${resource(dir: 'images/logos', file: 'kit_logo.png')}" alt="Karlsruhe Institute of Technology"/></a>
        <a href="http://www.erim.eur.nl/ERIM/Research/Centres/Learning_Agents" target="_blank"><img src="${resource(dir: 'images/logos', file: 'rsm_logo.png')}" alt="Rotterdam School of Management (RSM)" title="Rotterdam School of Management (RSM)"/></a>
        <a href="http://tac.cs.umn.edu/" target="_blank" title="University of Minnesota"><img src="${resource(dir: 'images/logos', file: 'umn_logo.png')}" alt="University of Minnesota"/></a>
      </div>

    </div> <!-- navigation -->

    <div id="content" class="competitionview grid_12">

      <g:layoutBody/>

      <div id="footer">
        <p>Copyright &copy; 2007-2011 Institute of Information Systems and Management (IISM) at KIT, RSM Erasmus University and
        University of Minnesota.</p>
        <p class="additionalInformation">System Information: URL: <a href="${ConfigurationHolder.config?.grails?.serverURL}">${ConfigurationHolder.config?.grails?.serverURL}</a> - Time: ${new Date()} - Version: <a href="https://github.com/powertac/powertac-server" target="_blank"><g:meta name="app.version"/></a></p>
      </div> <!-- footer -->

    </div> <!-- content -->

  </div> <!-- wrapper -->

</div> <!-- container_16 -->

</body>

</html>
