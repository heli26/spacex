package Order.DC.OrderGenerator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import Order.DC.OrderGenerator.models.Satellite;
import Order.DC.OrderGenerator.repositories.ISatelliteRepository;

@Service
public class SatelliteService {
    @Autowired
    private final ISatelliteRepository _satrepository;

    public SatelliteService(@Qualifier("SatRepo") ISatelliteRepository _satrepository) {
        this._satrepository = _satrepository;
    }

    public boolean Add() {
        int size = _satrepository.GetAll().size();
        int lastOrderId = 0;

        if (size != 0) {
            lastOrderId = _satrepository.GetAll().get(size - 1).getId();
        }
        lastOrderId = lastOrderId + 1;
        String name = "Sat: " + lastOrderId;
        // create sat
        Satellite sat = new Satellite(lastOrderId, name, true);
        boolean result = _satrepository.Add(sat);
        return result;

    }

    public String Health() {
        return _satrepository.Health();
    }

    public int Orbit() {
        return _satrepository.Orbit();
    }

    public String Delete() {
        boolean result = _satrepository.Delete(0);
        if (result) {
            return "Deleted";
        } else {
            return "An Error Occured";
        }
    }
    public List<Satellite> GetAll()
    {
      return _satrepository.GetAll().size()>0?_satrepository.GetAll():null;
    }
}