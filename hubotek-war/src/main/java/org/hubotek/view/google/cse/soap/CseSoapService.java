package org.hubotek.view.google.cse.soap;

import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.spi.JsonbProvider;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.hubotek.service.ejb.cse.GoogleCseEngineService;
import org.hubotek.view.cse.GoogleCustomSearchEngine;

@WebService(targetNamespace = "http://hubotek.org/cseengines",
serviceName = "CseService",
portName = "CseService",
name = "CseService")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public class CseSoapService {

	@EJB
	GoogleCseEngineService googleCseEngineService;

	@WebMethod(operationName = "listEngines", action = "listEngines")
	@WebResult(name = "enginesList")
	public List<GoogleCustomSearchEngine> listAvailableEngines()
	{ 
		return list();
	}

	@WebMethod(operationName = "listEnginesJSON", action = "listEnginesJSON")
	@WebResult(name = "enginesJSON")
	public String listAvailableEnginesJson()
	{ 
		return JsonbProvider.provider().create().build().toJson(list());
	}

	private  List<GoogleCustomSearchEngine> list()
	{ 


		return googleCseEngineService.getEngines();
	}
}
