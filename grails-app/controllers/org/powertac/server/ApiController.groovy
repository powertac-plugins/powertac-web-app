package org.powertac.server

import grails.converters.XML
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.powertac.common.Broker
import org.powertac.common.command.LoginResponseCmd
import org.powertac.common.command.LoginResponseCmd.StatusCode

class ApiController {

  static allowedMethods = [login: 'POST']

  def index = {
    render "" // Needs to be blank or any call to /api/ will be redirected to /api/login
  }

  def login = {
    def loginRequest = request.XML
    def broker = Broker.findByUsername("${loginRequest.username}")
    def response

    if (!broker) {
      response = new LoginResponseCmd(status: StatusCode.ERR_USERNAME_NOT_FOUND)
    } else if (broker.apiKey != loginRequest.apiKey.text()) {
      response = new LoginResponseCmd(status: StatusCode.ERR_INVALID_APIKEY)
    } else {
      response = new LoginResponseCmd(status: StatusCode.OK, serverAddress: ConfigurationHolder.config.powertac.broker.url)
    }

    render(contentType: "text/xml", encoding: "UTF-8", text: response as XML)
  }
}
