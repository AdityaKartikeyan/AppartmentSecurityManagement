import axios from 'axios';

const FLAT_API_BASE_URL = "http://localhost:9090/Flat/";

class FlatService{

    getFlat(){
        return axios.get(FLAT_API_BASE_URL + "getAll");
    }
    createFlat(flat) {
        return axios.post(FLAT_API_BASE_URL + 'addFlat', flat);
     }
      getFlatByflatNo(flatNo) {
            return axios.get(FLAT_API_BASE_URL + "getById/" + flatNo);
          }
        
          updateFlat(flat, flatNo) {
            return axios.put(FLAT_API_BASE_URL + "updateFlat/" + flatNo, flat);
          }
          deleteFlat(id) {
            return axios.delete(FLAT_API_BASE_URL + "deleteFlat/" + id);
          }
        }
     

export default new FlatService()