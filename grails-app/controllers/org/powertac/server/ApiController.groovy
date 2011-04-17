package org.powertac.server

import grails.converters.XML
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.powertac.common.Broker
import org.powertac.common.command.LoginResponseCmd
import org.powertac.common.command.LoginResponseCmd.StatusCode


class ApiController {

  static allowedMethods = [login: 'POST']

  def brokerLookupService
  def springSecurityService

  def index = {
    render "" // Needs to be blank or any call to /api/ will be redirected to /api/login
  }

  def login = {
    log.debug("login - start")
    def loginRequest = request.XML
    def broker = brokerLookupService.findByLoginRequest(loginRequest)
    def response

    log.debug("broker.username: ${loginRequest.username.text()}, password: ${loginRequest.password.text()}")

    if (!broker) {
      response = new LoginResponseCmd(status: StatusCode.ERR_USERNAME_NOT_FOUND)
    } else if (broker.password != springSecurityService.encodePassword(loginRequest.password.text())) {
      response = new LoginResponseCmd(status: StatusCode.ERR_INVALID_APIKEY)
    } else {
      response = new LoginResponseCmd(status: StatusCode.OK, serverAddress: ConfigurationHolder.config?.powertac?.connector?.url)
    }

    render(contentType: "text/xml", encoding: "UTF-8", text: response as XML)
    log.debug("login - end")
  }
}
