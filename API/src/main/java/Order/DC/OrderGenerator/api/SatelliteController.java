package Order.DC.OrderGenerator.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Order.DC.OrderGenerator.models.Satellite;
import Order.DC.OrderGenerator.services.SatelliteService;





@RestController
public class SatelliteController {

    private final SatelliteService _satService;

    @Autowired
    public SatelliteController(SatelliteService _satService) {
        this._satService = _satService;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value="/sat/health", method=RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String Management() {       
       return _satService.Health();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/sat/orbit", method = RequestMethod.GET)
    public int GetAssignedOrders() {
     return  _satService.Orbit();  
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/sat/add", method = RequestMethod.POST)
    public boolean Add(){
     return  _satService.Add();  
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/sat/delete", method = RequestMethod.POST)
    public String Delete(){
     return  _satService.Delete();  
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/sat/getall", method = RequestMethod.GET)
    public List<Satellite> GetAll() {
     return  _satService.GetAll();  
    }
}