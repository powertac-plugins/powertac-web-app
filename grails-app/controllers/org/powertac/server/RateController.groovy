package org.powertac.server

import grails.converters.XML
import org.powertac.common.Rate

class RateController {

  def scaffold = Rate

  def get = {
    def rateInstance = Rate.get(params.id)
    render(contentType: "text/xml", encoding: "UTF-8", text: rateInstance as XML)
  }

}
