import axios from 'axios';

const VEHICLE_API_BASE_URL = "http://localhost:9999/vehicle/";

class VehicleService{

    getVehicles(){
        return axios.get(VEHICLE_API_BASE_URL+"getAll");
    }

    createVehicle(vehicles) {
        return axios.post(VEHICLE_API_BASE_URL + "addVehicle", vehicles);
      }
    
      getVehiclesByVehicleNo(vehicleNo) {
        return axios.get(VEHICLE_API_BASE_URL + "getById/" + vehicleNo);
      }
    
      updateVehicle(vehicles, vehicleNo) {
        return axios.put(VEHICLE_API_BASE_URL + "updateVehicle/" + vehicleNo, vehicles);
      }
    
      deleteVehicle(id) {
        return axios.delete(VEHICLE_API_BASE_URL + "deleteVehicle/" + id);
      }
}

export default new VehicleService();