package org.powertac.server

import grails.converters.XML
import org.powertac.genco.GenCo

class GenCoController {

  def scaffold = GenCo

  def get = {
    def genCoInstance = GenCo.get(params.id)
    render(contentType: "text/xml", encoding: "UTF-8", text: genCoInstance as XML)
  }
}
