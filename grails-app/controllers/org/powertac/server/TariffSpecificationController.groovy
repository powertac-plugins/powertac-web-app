package org.powertac.server

import grails.converters.XML
import org.powertac.common.TariffSpecification

class TariffSpecificationController {

  def scaffold = TariffSpecification

  def get = {
    def tariffSpecificationInstance = TariffSpecification.get(params.id)
    render(contentType: "text/xml", encoding: "UTF-8", text: tariffSpecificationInstance as XML)
  }
}
