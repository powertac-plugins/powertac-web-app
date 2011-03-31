package org.powertac.server

import org.powertac.common.command.LoginResponseCmd
import org.powertac.common.command.LoginResponseCmd.Code
import grails.converters.XML

class ApiController {

  static allowedMethods = [login: 'POST']

  def index = {
    render "" // Needs to be blank or any call to /api/ will be redirected to /api/login
  }

  def login = {
//    log.info "${request.XML.apiKey}"
    def response = new LoginResponseCmd(returnCode: Code.OK, serverAddress: "http://www.test.com:1234")
    render(contentType: "text/xml", encoding: "UTF-8", text: response as XML)
  }
}
