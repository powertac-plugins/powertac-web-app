package org.powertac.server

import grails.converters.XML
import org.powertac.common.WeatherReport

class WeatherReportController {

  def scaffold = WeatherReport

  def get = {
    def weatherInstance = WeatherReport.get(params.id)
    render (contentType:"text/xml",encoding:"UTF-8", text: weatherInstance as XML)
  }
}
