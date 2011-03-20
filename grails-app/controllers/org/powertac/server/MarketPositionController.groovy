package org.powertac.server

import grails.converters.XML
import org.powertac.common.MarketPosition

class MarketPositionController {

  def scaffold = MarketPosition

  def get = {
    def marketPositionInstance = MarketPosition.get(params.id)
    render(contentType: "text/xml", encoding: "UTF-8", text: marketPositionInstance as XML)
  }

}
